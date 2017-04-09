package com.hlql.example.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Phone {

	private Long id;
	private String types;
	private String number;
	private Employee employee;
}
