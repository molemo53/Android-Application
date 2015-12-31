package molemo.quotejob.repositories.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tsemol01 on 2015/12/03.
 */
public class RestMethods {
    public static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return restTemplate;
    }

    public static HttpHeaders getHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;
    }
}
