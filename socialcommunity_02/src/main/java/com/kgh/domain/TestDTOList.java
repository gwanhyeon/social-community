package com.kgh.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TestDTOList {
	private List<TestDTO> list;
	
	public TestDTOList() {
		list = new ArrayList<>();
		
	}
	
	
}
