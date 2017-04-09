package com.hlql.mapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
	private Long id;
	private String name;
	private Set<String> emailSet = new HashSet<String>();// 存储多个邮箱
	private List<String> emailList = new ArrayList<String>();
	private List<String> emailBag = new ArrayList<String>();
}
