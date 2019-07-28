package com.xbeast7.boot.test.repository;

import com.xbeast7.boot.test.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
