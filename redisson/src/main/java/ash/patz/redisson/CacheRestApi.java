package ash.patz.redisson;

import ash.patz.redisson.service.ICacheService;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/cache/api")
public class CacheRestApi {

    @Autowired
    private ICacheService cacheService;
    private static final String keyPrefix = "test.91579D65B1C1235F9E4EB14FAB46CA4E778F778DCB6B74C81AB6AC128ACAF53F98A7EE9F2B7D7152B26EFF6063BF29ED.";

    @GetMapping(path = "/get")
    public ResponseEntity<Object> getAllKeys() throws JSONException {
        Map<String, String> data = new HashMap<>();
        for(int i = 1; i <= 1; i++) {
            String key = keyPrefix + i;
            String expiresAt = cacheService.get(key);
            if(StringUtils.isNotBlank(expiresAt)) {
                data.put(key, expiresAt);
            }
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping(path = "/get/local")
    public ResponseEntity<Object> getAllLocalKeys() throws JSONException {
        JSONObject data = new JSONObject();
        for(int i = 1; i <= 1; i++) {
            String key = keyPrefix + i;
            String expiresAt = cacheService.getFromLocalMap(key);
            data.put(key, expiresAt);
        }
        return new ResponseEntity<Object>(data, HttpStatus.OK);

    }

    /*@PostMapping(path = "/put")
    public ResponseEntity<Object> putAllKeys() {

    }*/
}
