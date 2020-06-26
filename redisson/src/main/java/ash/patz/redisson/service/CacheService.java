package ash.patz.redisson.service;

import org.apache.commons.lang3.ObjectUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ash.patz.redisson.utils.Constants.HASH_FIELD_EXPIRES_AT;
import static ash.patz.redisson.utils.Constants.HASH_FIELD_VALUE;

@Service
public class CacheService implements ICacheService {

    private RedissonClient redissonClient;
    private Map<String, RMap> rmapMap;

    private Logger log = LoggerFactory.getLogger(CacheService.class);

    public CacheService() {
        this.redissonClient = createRedissonClient();
        this.rmapMap = new ConcurrentHashMap<>();
    }

    private RedissonClient createRedissonClient() {
        Config config = new Config();
        config.setCodec(new StringCodec());
        Codec codec = config.getCodec();
        log.info("Codec is {}", codec.toString());
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        // use "rediss://" for SSL connection

        return Redisson.create(config);
    }

    @PreDestroy
    void destroy() {
        if (ObjectUtils.isNotEmpty(redissonClient)) {
            redissonClient.shutdown();
        }
    }

    @Override
    public void set(String key, String value, int ttlSecs) {
        Map<Object, Object> map = new HashMap<>();
        map.put(HASH_FIELD_VALUE, value);
        map.put(HASH_FIELD_EXPIRES_AT, getExpiresAt(ttlSecs));

        RMap<Object, Object> hash = redissonClient.getMap(key);
        hash.putAll(map);

        if (ttlSecs >= 0) {
            hash.expire(ttlSecs, TimeUnit.SECONDS);
        } else {
            hash.clearExpire();
        }
    }

    @Override
    public String get(String key) {
        RMap<String, Object> hash = redissonClient.getMap(key);
        Map<String, Object> stringObjectMap = hash.readAllMap();
        Map<String, Object> map = hash.getAll(Stream.of(HASH_FIELD_VALUE, HASH_FIELD_EXPIRES_AT).collect(Collectors.toCollection(HashSet::new)));
//        return (String) hash.get(HASH_FIELD_VALUE);
        return (String) stringObjectMap.get(HASH_FIELD_EXPIRES_AT);
    }

    @Override
    public String getFromLocalMap(String key){
        RMap<Object, Object> hash = rmapMap.computeIfAbsent(key, redissonClient::getMap);
//        return (String) hash.get(HASH_FIELD_VALUE);
        return (String) hash.get(HASH_FIELD_EXPIRES_AT);
    }

    @Override
    public void touch(String key, int ttlSecs) {
        RMap<Object, Object> hash = redissonClient.getMap(key);
        hash.fastPut(HASH_FIELD_EXPIRES_AT, getExpiresAt(ttlSecs));

        if (ttlSecs >= 0) {
            hash.expire(ttlSecs, TimeUnit.SECONDS);
        } else {
            hash.clearExpire();
        }
    }

    @Override
    public void remove(String key) {
        RMap<Object, Object> hash = redissonClient.getMap(key);
        if (hash != null) {
            hash.delete();
        }
    }

    public String getExpiresAt(int ttlSecs) {
        if (ttlSecs >= 0) {
            DateTimeFormatter ISO_DATETIME_FORMATTER = ISODateTimeFormat.dateTimeNoMillis().withZoneUTC();
            return ISO_DATETIME_FORMATTER.print(new DateTime().plusSeconds(ttlSecs));
        }
        return "";
    }
}
