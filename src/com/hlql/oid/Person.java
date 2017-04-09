package com.hlql.oid;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

	private Long id;
	private String name;

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

}
