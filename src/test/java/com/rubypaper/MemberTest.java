package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.board.domain.MemberVO;
import com.rubypaper.board.domain.Role;
import com.rubypaper.board.persistence.MemberServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberTest {

	@Autowired
	private MemberServiceImpl service;
	
	@Test
	public void insert1() {
		MemberVO vo = new MemberVO();
		vo.setId("member3");
		vo.setName("둘리3");
		vo.setPassword("member333");
		vo.setRole(Role.ROLE_MEMBER);
		vo.setEnabled("TRUE");
		service.insert(vo);
	}
	
	//@Test
	public void insert2() {
		MemberVO vo = new MemberVO();
		vo.setId("admin");
		vo.setName("도우너");
		vo.setPassword("admin123");
		vo.setRole(Role.ROLE_ADMIN);
		vo.setEnabled("TRUE");
		service.insert(vo);
	}
	
	//@Test
	public void insert3() {
		MemberVO vo = new MemberVO();
		vo.setId("ppk");
		vo.setName("너구리");
		vo.setPassword("ppk123");
		vo.setRole(Role.ROLE_MEMBER);
		vo.setEnabled("TRUE");
		service.insert(vo);
	}

	//@Test
	public void select() {
		MemberVO vo = new MemberVO();
		List<MemberVO> li = service.getMemberList(vo);
		
		for (MemberVO m:li) {
			System.out.println("===>"+m.toString());
		}
	}
	
	
	
}
