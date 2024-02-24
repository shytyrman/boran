package com.example.boran.parser;

import com.example.boran.model.Currency;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.rmi.server.LogStream.log;

public class SampleParser implements Parser{

    public void parse() throws IOException {
        Document doc;
        try {
            doc = Jsoup.connect("https://mig.kz/").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log(doc.title());
        String USD_course = doc.select("td").eachText().toArray()[2].toString();
        LocalDateTime day = LocalDateTime.now();
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("day", day.toString());
        requestBody.put("dollar", USD_course);

        final String uri = "http://localhost:8080/api/add_currency";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Currency> responseEntity = restTemplate.postForEntity(uri, requestEntity, Currency.class);

        System.out.println(responseEntity.getBody());
    }

}
