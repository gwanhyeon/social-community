package com.kgh.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kgh.domain.TestDTO;
import com.kgh.domain.TestDTOList;
import com.kgh.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/viewTest/*")
@Log4j
public class TestController {
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
		
		
	}
	
	
	
	@RequestMapping(value = "/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void getTest1() {
		log.info("Get mapping Test1");
	}
	@GetMapping("/basicOnlyGet")
	public void getTest2() {
		log.info("Get mapping Test 2");
	}
	@GetMapping("/ex01")
	public String ex01(TestDTO dto) {
		log.info("hello /ex01");
		log.info(dto);
		return "ex01";
	}
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name,
			@RequestParam("age") int age) {
		log.info("name" + name);
		log.info("age" + age);
		return "ex02";
		
	}
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids" + ids);
		return "/ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array id: " + Arrays.toString(ids));
		return "/ex02Array";
	
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(TestDTOList list) {
		log.info("list dtos: "+ list);
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo : " + todo);
		return "/ex03";
	}
    @GetMapping("/ex04")
    public String ex04(TestDTO dto, @ModelAttribute("page") int page) {
    		log.info("dto: " + dto);
    		log.info("page:" + page);
    		return "/viewTest/ex04";
    }
    
    // void 타입의 일부
    @GetMapping("/ex05")
    public void ex05() {
    		log.info("/ex05");
    }
    
    @GetMapping("/ex06")
    public @ResponseBody TestDTO ex06() {
    		log.info("/ex06...");
		
    		TestDTO dto = new TestDTO();
    		dto.setAge(26);
    		dto.setName("Gwan-hyeon kim");
    	
    		return dto;
    }
    
    @GetMapping("/ex07")
    public ResponseEntity<String> ex07(){
    		log.info("ex 07");
    		String msg= "{\"name\": \"gwan-hyeon kim\"}";
    		HttpHeaders headers= new HttpHeaders();
    		headers.add("Content-Type","application/json;charset=UTF-8");
    		return new ResponseEntity<>(msg,headers,HttpStatus.OK);
    		
    }
   @GetMapping("/exUpload")
   public void exUpload() {
	   log.info("/exUpload");
   }
   
   @PostMapping("/exUploadPost")
   public void exUploadPost(ArrayList<MultipartFile> files) {
	   try {
		   files.forEach( file-> {
			   log.info("-----");
			   log.info("name:" + file.getOriginalFilename());
			   log.info("size: " + file.getSize());

			   });
	} catch (NullPointerException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		   
   }
}
