package ash.patz.learning.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestUtil {
    private static int socketTimeout = 5000;
    private static int connectionTimeout = 5000;
    private static int maxNumberPerRoute = 5;
    private static int maxNumberTotalConnections = 5;

    private static RestTemplate restTemplate;

    private static Logger log = LoggerFactory.getLogger(RestUtil.class);

    public static synchronized RestTemplate getRestTemplate() {
        if (restTemplate == null) {
            restTemplate = new RestTemplate(getClientHttpRequestFactory());
        }
        return restTemplate;
    }

    private static ClientHttpRequestFactory getClientHttpRequestFactory() {
        // pooling connection manager
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager =
                new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(maxNumberTotalConnections);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(maxNumberPerRoute);

        RequestConfig requestConfig =
                RequestConfig.custom()
                        .setConnectionRequestTimeout(connectionTimeout) //Returns the timeout in milliseconds used when requesting a connection from the connection manager.
                        .setConnectTimeout(connectionTimeout) //Determines the timeout in milliseconds until a connection is established.
                        .setSocketTimeout(socketTimeout).build(); //a maximum period inactivity between two consecutive data packets

        CloseableHttpClient httpClient =
                HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager)
                        .setDefaultRequestConfig(requestConfig).build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        log.info("Generated ClientHttpRequestFactory");
        return requestFactory;
    }

}
