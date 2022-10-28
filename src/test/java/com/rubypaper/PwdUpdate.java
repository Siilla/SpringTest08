package com.rubypaper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.board.domain.MemberVO;
import com.rubypaper.board.persistence.MemberServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PwdUpdate {
	

	@Autowired
	MemberServiceImpl service;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void test() {
		MemberVO vo = new MemberVO();
		vo.setId("admin");
		vo.setPassword(encoder.encode("admin123"));
		
		service.updatePwd(vo);
	}
	
}
