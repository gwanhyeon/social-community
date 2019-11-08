package com.kgh.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	
//	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date dueDate;


}
