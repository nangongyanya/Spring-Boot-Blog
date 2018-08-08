package com.lakey.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lakey.blog.vo.Menu;

/**
 * 用户控制器.
 *
 * @since 1.0.0 2018 年 8 月 8 日
 * @author Rimon
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

	/**
	 * 获取后台管理主页面
	 * @return
	 */
	@GetMapping
	public ModelAndView listUsers(Model model) {
		List<Menu> list = new ArrayList<>();
		list.add(new Menu("用户管理", "/users"));
		model.addAttribute("list", list);
		return new ModelAndView("/admins/index", "model", model);
	}
 
	 
}
