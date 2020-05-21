package ash.patz.learning.service;

import ash.patz.learning.util.RestUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class RemoteService {

    private RestTemplate restTemplate = RestUtil.getRestTemplate();

    public String invokeRemoteService() {
//        String url = "http://localhost:3001/random/delay";
        String url = "https://fiu3s35e7l.execute-api.us-west-2.amazonaws.com/test/random/delay";
        String response = null;
        try {
            response =  restTemplate.getForObject(url, String.class);
        } catch (HttpClientErrorException ex) {
            System.out.println("Remote service returned non 2XX response");
            System.out.println(ex.getMessage());
        }
        return response;
    }

}
