package com.hlql.example.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project {

	private Long id;
	private String name;
	private Employee manager;

	private List<Employee> employees = new ArrayList<Employee>();
}
