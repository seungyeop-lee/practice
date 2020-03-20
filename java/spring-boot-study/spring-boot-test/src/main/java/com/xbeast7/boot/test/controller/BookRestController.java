package com.xbeast7.boot.test.controller;

import com.xbeast7.boot.test.domain.Book;
import com.xbeast7.boot.test.service.BookRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller와 @ResponseBody가 합쳐진 어노테이션
public class BookRestController {

    @Autowired
    private BookRestService bookRestService;

    @GetMapping(path = "/rest/test",    //Mapping할 URI
            produces = MediaType.APPLICATION_JSON_VALUE)    //response의 Content-Type
    public Book getRestBooks() {
        return bookRestService.getRestBook();
    }
}
