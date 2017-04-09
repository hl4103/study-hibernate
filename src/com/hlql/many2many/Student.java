package com.hlql.many2many;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

	private Long id;
	private String name;
	private Set<Teacher> teachers = new HashSet<Teacher>();
}
