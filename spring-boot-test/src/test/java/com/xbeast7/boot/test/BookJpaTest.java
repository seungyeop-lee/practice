package com.xbeast7.boot.test;

import com.xbeast7.boot.test.domain.Book;
import com.xbeast7.boot.test.repository.BookRepository;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest    //JPA관련 테스트 설정만 로드
//@ActiveProfiles("local-test")   //사용자가 정의한 환경을 테스트에 적용
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)    //ActiveProfiles에서 설정한 프로파일 환경값으로 데이터 소스 적용
public class BookJpaTest {

    private final static String BOOT_TEST_TITLE = "Spring Boot Test Book";

    @Autowired
    private TestEntityManager testEntityManager;    //테스트용 EntityManager

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void Book_save_test() {
        Book book = Book.builder().title(BOOT_TEST_TITLE).publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book);    //EntityManager를 이용해 해당 객체를 영속화 시킴
        assertThat(bookRepository.getOne(book.getIdx()), is(book)); //JPA를 이용해 만든 repository를 이용해 객체 획득 테스트
    }

    @Test
    public void BookList_save_search_test() {
        Book book1 = Book.builder().title(BOOT_TEST_TITLE + "1").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book1);
        Book book2 = Book.builder().title(BOOT_TEST_TITLE + "2").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book2);
        Book book3 = Book.builder().title(BOOT_TEST_TITLE + "3").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book3);

        List<Book> bookList = bookRepository.findAll();
        assertThat(bookList, hasSize(3));
        assertThat(bookList, contains(book1, book2, book3));
    }

    @Test
    public void BookList_save_delete_test() {
        Book book1 = Book.builder().title(BOOT_TEST_TITLE + "1|").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book1);
        Book book2 = Book.builder().title(BOOT_TEST_TITLE + "2").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book2);

        bookRepository.deleteAll();
        assertThat(bookRepository.findAll(), IsEmptyCollection.empty());
    }
}
