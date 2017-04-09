package com.hlql.example.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

	private Long id;
	private String name;
	private BigDecimal salary;
	private Date hireDate;
	
	private Department department;
}
