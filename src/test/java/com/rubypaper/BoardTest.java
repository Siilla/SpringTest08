package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.board.domain.BoardVO;
import com.rubypaper.board.persistence.BoardServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTest {

	@Autowired
	private BoardServiceImpl service;
	
	@Test
	public void insert() {
		for (int i=1; i<=3; i++) {
			BoardVO vo = new BoardVO();
			vo.setTitle("둘리"+i+"입니다.");
			vo.setWriter("member");
			vo.setContent("둘리"+i+"입니다.");
			vo.setCreateDate(new Date());
			vo.setCnt(1);
			service.insert(vo);
		}
	}

	//@Before
	public void delete() {
		for (int i=1; i<=10; i++) {
		BoardVO vo = new BoardVO();
		vo.setSeq(1000+i);
		service.delete(vo);
		}
	}
	
	//@Test
	public void select() {
		
		BoardVO vo = new BoardVO();
		List<BoardVO> li = service.getBoardList(vo);
		
		for (BoardVO m:li) {
			System.out.println("===>"+m.toString());
		}
	}
	
}
