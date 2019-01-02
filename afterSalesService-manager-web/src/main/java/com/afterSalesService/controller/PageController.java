package com.afterSalesService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面展示
 * @author wjx
 *
 */
@Controller
public class PageController {
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}

}
