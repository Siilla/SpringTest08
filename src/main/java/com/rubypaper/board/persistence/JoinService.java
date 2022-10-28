package com.rubypaper.board.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rubypaper.board.domain.JoinVO;

public interface JoinService {
	List<JoinVO> join1(JoinVO vo);
	List<JoinVO> join2(JoinVO vo);
	JoinVO join3(JoinVO vo);
	
}
