package com.kgh.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	
	//게시판검색 기능 구현하기
	private String type;
	private String keyword;
	
	public Criteria() {
		// TODO Auto-generated constructor stub
		
		this(1,10);
		
		System.out.println("#Crieria.java");
	}
	public Criteria(int pageNum,int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum",this.pageNum)
				.queryParam("amout", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
				return builder.toUriString();
	}
}
