package com.kh.project.mapper;

import java.util.Map;

import com.kh.project.domain.ConsumerVo;

public interface ConsumerMapper {
	
	// 아이디 중복 체크
	public int checkDupId(String consumer_id);
	
	// 고객 등록
	public int insert(ConsumerVo vo);
	
	// 선택 조회
	public ConsumerVo selectById(String consumer_id);
	
	// 비번 확인
	public int checkCorrectPw (Map<String, Object> map);
	
	// 정보 수정
	public int update(ConsumerVo vo);
	
	// 고객 정보 삭제
	public int delete(String consumer_id);
	
	// 포인트 수정
	public int updatePoint(Map<String, Object> map);
	
}
