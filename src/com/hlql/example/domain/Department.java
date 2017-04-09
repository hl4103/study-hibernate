package com.hlql.example.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {
	
	private Long id;
	private String name;
	private String sn;
	private String province;
	private String city;
	private String street;

	private Employee manager;
	
	private List<Employee> emps = new ArrayList<Employee>();
}
