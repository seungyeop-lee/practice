package com.xbeast7.boot.test.service;

import com.xbeast7.boot.test.domain.Book;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookRestService {

    private final RestTemplate restTemplate;

    public BookRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder //RestTemplate는 RestTemplateBuilder를 이용해 생성
                .rootUri("/rest/test")  //RestTemplate로 Rest서버에 접속 할 때마다 기본으로 들어갈 URI
                .build();
    }

    public Book getRestBook() {
        //Get방식으로 지정한 URI에 접속하여 지정한 클래스에 매핑하여 반환
        return this.restTemplate.getForObject("/rest/test", Book.class);
    }
}
