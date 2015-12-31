package molemo.quotejob.repositories.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import molemo.quotejob.domain.AddJob;
import molemo.quotejob.model.AddJobResource;
import molemo.quotejob.repositories.RestAPI;

/**
 * Created by tsemol01 on 2015/12/03.
 */
public class RestQuote implements RestAPI<AddJobResource, Long>{

    final String BASE_URL = "http://backendapi-molemo.rhcloud.com/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public AddJobResource get(Long id)
    {
        final String url = BASE_URL+"quote/"+id.toString();

        HttpEntity<AddJobResource> requestEntity = new HttpEntity<>(requestHeaders);

        ResponseEntity<AddJobResource> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, AddJobResource.class);

        AddJobResource jobResource = responseEntity.getBody();

        return jobResource;
    }


    @Override
    public String post (AddJobResource entity)
    {
        final String url = BASE_URL+"quote/create/";

        HttpEntity<AddJobResource> requestEntity = new HttpEntity<AddJobResource>(entity,requestHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

       String result = responseEntity.getBody();

        return result;
    }

    @Override
    public String put (AddJob entity)
    {
        final String url = BASE_URL+"quote/update/"+entity.getId().toString();

        HttpEntity<AddJob> requestEntity = new HttpEntity<>(entity,requestHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);

        String result = responseEntity.getBody();

        return result;
    }

    @Override
    public String delete (AddJob entity)
    {

        final String url = BASE_URL+"quote/delete/"+entity.getId().toString();

        HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);

        String result = responseEntity.getBody();

        return result;

    }

    @Override
    public List<AddJobResource> getAll()
    {
        List<AddJobResource> quotesList = new ArrayList<>();
        final String url = BASE_URL+"quote/quotes/";

        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<AddJobResource[]> responseEntity = restTemplate.exchange(url,HttpMethod.GET, requestEntity, AddJobResource[].class);

        AddJobResource[] result = responseEntity.getBody();

        for (AddJobResource job:result)
        {
            quotesList.add(job);
        }

        return quotesList;
    }


}
