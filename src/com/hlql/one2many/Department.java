package com.hlql.one2many;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {
	private Long id;
	private String name;

	private Set<Employee> emps = new HashSet<Employee>();
}
