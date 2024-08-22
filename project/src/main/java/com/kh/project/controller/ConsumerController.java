package com.kh.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.project.domain.ConsumerVo;
import com.kh.project.service.ConsumerService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/consumer/*")
@Log4j
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/registerPost")
	public String registerPost(ConsumerVo consumerVo, RedirectAttributes rttr) {
		log.info("consumerVo:" + consumerVo);
		boolean result = consumerService.register(consumerVo);
		rttr.addFlashAttribute("registerResult", result);
		return "redirect:/consumer/login";
	}
	
	@GetMapping("/checkDupId")
	@ResponseBody
	public boolean checkDupId(String consumer_id) {
		boolean result = consumerService.checkDupId(consumer_id);
		return result;
	}
	
}
