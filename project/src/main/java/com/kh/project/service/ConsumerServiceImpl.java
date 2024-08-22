package com.kh.project.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.project.domain.ConsumerVo;
import com.kh.project.mapper.ConsumerMapper;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Autowired
	private ConsumerMapper consumerMapper;

	@Override
	public boolean checkDupId(String consumer_id) {
		return (consumerMapper.checkDupId(consumer_id) == 1 ) ? true : false;
	}

	@Override
	public LocalDate getBirthDate(String residentNumber) {
		// 주민등록번호 유효성 검증
		if (residentNumber.length() !=14 || residentNumber.charAt(6) != '-') {
			throw new IllegalArgumentException("주민등록번호의 길이나 형식이 올바르지 않습니다.");
		}
		
		// 생년월일 부분 추출
		String birthDateStr = residentNumber.substring(0, 6);
		
		// 연도 처리 (1900 or 2000)
		String yearPrefix = "19"; // 기본
		int year = Integer.parseInt(birthDateStr.substring(0, 2));
		if(year > 22) {
			yearPrefix = "20";
		}
		String formattedYear = yearPrefix + birthDateStr.substring(0, 2);
		
		// 생년월일 포맷
		String formattedDate = formattedYear + birthDateStr.substring(2);
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

	    try {
            return LocalDate.parse(formattedDate, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("주민등록번호에서 추출한 생년월일이 유효하지 않은 날짜입니다.");
        }
	}

	@Override
	public boolean register(ConsumerVo vo) {
		return (consumerMapper.insert(vo) == 1 ) ? true : false;
	}

	@Override
	public ConsumerVo selectById(String consumer_id) {
		ConsumerVo vo = consumerMapper.selectById(consumer_id);
		return vo;
	}

	@Override
	public boolean checkCorrectPw(Map<String, Object> map) {
		return (consumerMapper.checkCorrectPw(map) == 1 ) ? true : false;
	}

	@Override
	public boolean modify(ConsumerVo vo) {
		return (consumerMapper.update(vo) == 1 ) ? true : false;
	}

	@Override
	public boolean remove(String consumer_id) {
		return (consumerMapper.delete(consumer_id) == 1 ) ? true : false;
	}

	@Override
	public boolean updatePoint(Map<String, Object> map) {
		return (consumerMapper.updatePoint(map) == 1 ) ? true : false;
	}
	
}
