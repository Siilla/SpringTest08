package com.rubypaper.board.persistence;

import java.util.List;

import com.rubypaper.board.domain.MemberVO;

public interface MemberService {
	void insert(MemberVO vo);
	void delete(MemberVO vo);

	List<MemberVO> getMemberList(MemberVO vo);
	MemberVO getMember(MemberVO vo);
	
	void updatePwd(MemberVO vo);

}
