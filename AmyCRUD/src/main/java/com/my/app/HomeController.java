package com.my.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.app.bean.AmyboardDto;
import com.my.app.dao.AmyboardDao;



@Controller
public class HomeController {
	
	@Autowired
	AmyboardDao dao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/main.do")
	public String home(Model model) {
		model.addAttribute("list", dao.boardGetAll());
		model.addAttribute("total", dao.boardGetCount());
		return "main";
	}
	
	@RequestMapping("/Insert.do")
	public String insert() {
		return "insert";
	}
	
	@RequestMapping("/InsertProc.do")
	public String insertProc(AmyboardDto dto) {
		dao.boardInsert(dto);
		return "redirect:/main.do";
	}
	
	@RequestMapping("/ViewPost.do")
	public String viewPost(int idx, Model model) {
		model.addAttribute("view",dao.boardGetOne(idx));
		return "view";
	}
	
	@RequestMapping("/DeleteProc.do")
	public String deleteProc(int idx) {
		dao.boardDelete(idx);
		return "redirect:/main.do";
	}
	
	@RequestMapping("/Update.do")
	public String update(int idx, Model model) {
		model.addAttribute("view",dao.boardGetOne(idx));
		return "update";
	}
	
	@RequestMapping("/UpdateProc.do")
	public String updateProc(AmyboardDto dto) {
		dao.boardUpdate(dto);
		return "redirect:/main.do";
	}
	

	
}
