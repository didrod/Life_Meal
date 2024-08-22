package com.kh.project.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.project.domain.ConsumerVo;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ConsumerServiceTests {
	
	@Autowired
	private ConsumerService consumerService;
	
	@Test
	public void testInstance() {
		log.info("consumerService:" + consumerService);
	}
	
	@Test
	public void testCheckDupId() {
		String consumer_id = "id9742";
		boolean result = consumerService.checkDupId(consumer_id);
		log.info("result:" + result);
	}
	
	@Test
	public void testInsert() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(1998, Calendar.MARCH, 02);
		java.sql.Date sqlDate = new java.sql.Date(calendar.getTimeInMillis());
		
		ConsumerVo vo = ConsumerVo.builder()
				.consumer_id("id9742")
				.consumer_pw("pw9742")
				.consumer_name("첫고객")
				.consumer_phone_number("01012345678")
				.birth(sqlDate)
				.consumer_adress("울산광역시 남구 삼산로35번길 19")
				.consumer_email("id9742@naver.com")
				.consumer_point(0)
				.build();
		
		boolean result = consumerService.register(vo);
		log.info("result:" + result);
	}
	
	@Test
	public void testSelectById() {
		ConsumerVo vo = consumerService.selectById("id9742");
		log.info("vo:" + vo);
	}
	
	@Test
	public void testCheckCorrectPw() {
		Map<String, Object> map = new HashMap<>();
		map.put("consumer_id", "id9742");
		map.put("consumer_pw", "pw9742"); //-> 어차피 아이디는 session에서 받아오니까 count가 0이 나오면
													// 비번이 옳지 않다고 하면 될 듯
		boolean result = consumerService.checkCorrectPw(map);
		log.info("result:" + result);
	}
	
	@Test
	public void testUpdate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2000, Calendar.AUGUST, 03);
		java.sql.Date sqlDate = new java.sql.Date(calendar.getTimeInMillis());
		
		ConsumerVo vo = consumerService.selectById("id9742");
		vo.setConsumer_pw("pw1234");
		vo.setConsumer_name("수정손님");
		vo.setBirth(sqlDate);
		vo.setConsumer_phone_number("01044444444");
		vo.setConsumer_adress("울산광역시 중구 도서관길 72");
		vo.setConsumer_email("id9742@naver.com");
		
		boolean result = consumerService.modify(vo);
		log.info("result:" + result);
	}
	
	@Test
	public void testDelete() {
		boolean result = consumerService.remove("id9742");
		log.info("result:" + result);
	}
	
	@Test
	public void testUpdatePoint() {
		Map<String, Object> map = new HashMap<>();
		map.put("consumer_id", "id9742");
		map.put("ppoint", 3);
		boolean result = consumerService.updatePoint(map);
		log.info("result:" + result);
	}
}
