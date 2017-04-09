package com.hlql.enum01;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

	private Long id;
	private String name;
	private Gender sex;
	
	// 组件
	private Address bornAddress;
	private Address address;
}
