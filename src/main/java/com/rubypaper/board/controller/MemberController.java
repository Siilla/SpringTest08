package com.rubypaper.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.board.domain.BoardVO;
import com.rubypaper.board.domain.MemberVO;
import com.rubypaper.board.persistence.BoardServiceImpl;
import com.rubypaper.board.persistence.MemberServiceImpl;

@Controller
@RequestMapping("/board")
public class MemberController {

	@Autowired
	MemberServiceImpl memberService;
	
	@Autowired
	BoardServiceImpl boardService;
	
	@RequestMapping("/getMemberList.do")
	public String getMemberList(Model model,MemberVO vo) {
		model.addAttribute("li", memberService.getMemberList(vo));
		return "board/getMemberList";
	}
	
	@RequestMapping("/delete.do")
	public String delete(MemberVO vo, BoardVO vo2) {
		
		//vo2.setWriter(vo.getId());
		
		memberService.delete(vo);
		boardService.deleteWriter(vo2);
		
		return "redirect:getMemberList.do";
	}
}
