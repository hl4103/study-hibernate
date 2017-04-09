package com.hlql.many2oneone2many;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {
	private Long id;
	private String name;
	private List<Employee> emps = new ArrayList<Employee>();
}
