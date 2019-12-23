package com.kgh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kgh.domain.BoardVO;
import com.kgh.domain.Criteria;
import com.kgh.domain.PageDTO;
import com.kgh.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	private BoardService service;
	
	//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("list ..... ");
//		model.addAttribute("list", service.getList());
//	}
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		log.info("list GetMapping" + cri);
		System.out.println("#-=>"+cri +"$");
		System.out.println("#0=>"+model +"$");
		model.addAttribute("list",service.getList(cri));
//		model.addAttribute("pageMaker",new PageDTO(cri,123));
		int total = service.getTotal(cri);
		log.info("total:"+total);
		model.addAttribute("pageMaker",new PageDTO(cri,total));
		System.out.println("#1=>"+cri);
		System.out.println("#2=>"+service.getList(cri));
		System.out.println("#3=>"+total);
		System.out.println("#4=>"+model);
		
		
		
	}
	@GetMapping("/register")
	public void register() {
		
	}
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register : " + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		System.out.println("#BoardController.java post @/register");
		return "redirect:/board/list";
	}
//	서 ${[NAME].property} 형태로 Model 객체의 값을 사용할 수 있게 된다.

	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno,@ModelAttribute("cri")Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("board",service.get(bno));	
		System.out.println("#BoardController.java get @/modify");
	}
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
		log.info("modify : " + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result" + "success");
		}
//		rttr.addAttribute("pageNum",cri.getPageNum());
//		rttr.addAttribute("amount",cri.getAmount());
//		rttr.addAttribute("type",cri.getType());
//		rttr.addAttribute("keyword",cri.getKeyword());
		System.out.println("#BoardController.java post @/modify");
		return "redirect:/board/list" + cri.getListLink();
	}
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
		log.info("remove..."+bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
//		rttr.addAttribute("pageNum",cri.getPageNum());
//		rttr.addAttribute("amount",cri.getAmount());
//		rttr.addAttribute("type",cri.getType());
//		rttr.addAttribute("keyword",cri.getKeyword());
		System.out.println("# BoardController.java post @/remove");
		return "redirect:/board/list" + cri.getListLink();
	}
}
