package com.xbeast7.boot.test;

import com.xbeast7.boot.test.controller.BookController;
import com.xbeast7.boot.test.domain.Book;
import com.xbeast7.boot.test.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.hamcrest.Matchers.contains;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)   //컨트롤러 테스트용(스프링 시큐리티, 필터의 테스트까지 가능)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;    //Spring MVC테스트용 객체

    @MockBean   //테스트용 목객체 추입
    private BookService bookService;

    @Test
    public void Book_MVC_Test() throws Exception {
        Book book = new Book("Spring Boot Book", LocalDateTime.now());
        //given()은 기존은 when()과 동일, BDD에 맞춰 테스트 메소드 명을 변경했을 뿐
        given(bookService.getBookList()).willReturn(Collections.singletonList(book));

        mvc.perform(get("/books"))  //get method로 "/books"에 접근 하는 경우
                .andExpect(status().isOk()) //반환코드는 200
                .andExpect(view().name("book")) //뷰 리졸버에 전달 될 뷰의 이름은 "book"
                .andExpect(model().attributeExists("bookList")) //모델에 "bookList" 속성이 있음
                .andExpect(model().attribute("bookList", contains(book)));  //"bookList"속성에 book객체가 존재
    }

}