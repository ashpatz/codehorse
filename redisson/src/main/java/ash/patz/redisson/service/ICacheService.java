package ash.patz.redisson.service;

public interface ICacheService {
    void set(String key, String value, int ttlSecs);
    String get(String key);
    String getFromLocalMap(String key);
    void touch(String key, int ttlSecs);
    void remove(String key);
}
