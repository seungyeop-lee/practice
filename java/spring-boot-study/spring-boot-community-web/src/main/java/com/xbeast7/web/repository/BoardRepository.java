package com.xbeast7.web.repository;

import com.xbeast7.web.domain.Board;
import com.xbeast7.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
