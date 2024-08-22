package com.kh.project.service;

import java.time.LocalDate;
import java.util.Map;

import com.kh.project.domain.ConsumerVo;

public interface ConsumerService {
	
	// 아이디 중복 체크
	public boolean checkDupId(String consumer_id);
	
	// 주민등록번호로부터 생년월일 추출
	public LocalDate getBirthDate(String residentNumber);
	
	// 고객 등록
	public boolean register(ConsumerVo vo);
	
	// 선택 조회
	public ConsumerVo selectById(String consumer_id);
	
	// 비번 확인
	public boolean checkCorrectPw(Map<String, Object> map);
	
	// 정보 수정
	public boolean modify(ConsumerVo vo);
	
	// 고객 정보 삭제
	public boolean remove(String consumer_id);
	
	// 포인트 수정
	public boolean updatePoint(Map<String, Object> map);
	
}
