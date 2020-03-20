package com.xbeast7.web.controller;

import com.xbeast7.web.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping({"", "/"})  //RequestMapping의 주소로 접근했을 때 실행
    public String board(
            @RequestParam(value = "idx", defaultValue = "0") Long idx,  //idx라는 이름의 파라미터화 매핑, 값이 없을 경울 0으로 초기화
            Model model) {
        model.addAttribute("board", boardService.findBoardByIdx(idx));  //idx가 default값일 경우 해당하는 Board가 없기 때문에 null이 반환
        return "/board/form";   // src/resources/templates를 기준으로 바인딩 할 타깃의 뷰 경로 지정
    }

    @GetMapping("/list")    //RequestMapping 뒤 /list가 붙어있는 주소로 접근했을 때 실행
    public String list(
            @PageableDefault Pageable pageable, //페이징 처리에 대한 규약, @PageableDefault로 기본값이 설정 됨
            Model model) {
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "/board/list";
    }
}
