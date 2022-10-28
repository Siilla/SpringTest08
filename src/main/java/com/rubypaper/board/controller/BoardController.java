package com.rubypaper.board.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.board.domain.BoardVO;
import com.rubypaper.board.domain.JoinVO;
import com.rubypaper.board.persistence.BoardServiceImpl;
import com.rubypaper.board.persistence.JoinServiceImpl;

@Controller
@RequestMapping("/board")
public class BoardController {

	
	@Autowired
	BoardServiceImpl boardService;
	
	@Autowired
	JoinServiceImpl joinService;
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(Model model, JoinVO vo){
		model.addAttribute("li", joinService.join1(vo));
		return "board/getBoardList";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(Model model, JoinVO vo, BoardVO vo2){
		boardService.cnt(vo2);
		model.addAttribute("m", joinService.join3(vo));
		System.out.println("=====>VO값 : "+vo);
		return "board/getBoard";
	}

	@RequestMapping("/insertBoard")
	public String insertBoard(){
		return "board/insertBoard";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo){
		vo.setCreateDate(new Date());
		vo.setCnt(3);
		boardService.insert(vo);
		
		return "redirect:getBoardList.do";
	}
	
}
