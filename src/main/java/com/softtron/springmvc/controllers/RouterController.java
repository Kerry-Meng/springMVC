package com.softtron.springmvc.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;
import com.softtron.springmvc.daos.OrderDao;
import com.softtron.springmvc.domains.TUser;
import com.softtron.springmvc.services.UserService;

@Controller
@SessionAttributes({ "user2" })
public class RouterController {
	@Autowired
	OrderDao orderDao;
	@Autowired
	UserService UserService;

	@ModelAttribute("user")
	public void init(Integer id, Map map) {
		if (id != null) {
			TUser user = new TUser();// 去数据库查询
			user.setUsername("xiaohong");
			user.setPassword("666");
			user.setDate(new Date());
			map.put("user", user);
		}
	}

	@ModelAttribute("user2")
	public TUser init2() {
		TUser user = new TUser();// 去数据库查询
		user.setUsername("xiaohong");
		user.setPassword("666");
		user.setDate(new Date());
		return user;
	}

	@RequestMapping(path = "/index")
	public String index() {
		System.out.println("index");
		return "index";/// WEB-INF/jsp/index.jsp
	}

	@RequestMapping(path = "/index2/{page}")
	public void index2(@PathVariable String page, HttpServletRequest request) {
		System.out.println(request.getParameter("name"));
		System.out.println(page);
	}

	/// index3?name=xiaozhang
	// @RequestMapping(path = "/index3",method=RequestMethod.POST)
	// @GetMapping(path="/index3")
	@PostMapping(path = "/index3")
	public void index3(@RequestParam(value = "name") String username) {
		System.out.println(username);
	}

	@ResponseBody
	@RequestMapping(path = "/index4")
	public TUser index4(@RequestBody TUser user, HttpServletRequest request) {
		// System.out.println(user);
		System.out.println(request.getSession().getAttribute("user2"));
		return user;
	}

	@RequestMapping(path = "/index5")
	public void index5() {
		try {
			UserService.task();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
