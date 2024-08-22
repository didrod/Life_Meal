package com.kh.project.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ConsumerVo {
	
	private String consumer_id;
	private String consumer_pw;
	private String consumer_name;
	private String consumer_phone_number;
	private Date birth;
	private String consumer_adress;
	private String consumer_email;
	private int consumer_point;

}