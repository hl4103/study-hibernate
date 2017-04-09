package com.hlql.many2oneone2many;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

	private Long id;
	private String name;
	
	private Department dept;
}
