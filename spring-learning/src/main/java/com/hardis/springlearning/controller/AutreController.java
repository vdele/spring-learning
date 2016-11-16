package com.hardis.springlearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AutreController
{

	@RequestMapping("/{anotherParam}")
	public String anyElseParam(@PathVariable final String anotherParam, final Model model)
	{
		model.addAttribute("laPage", anotherParam);
		System.out.println("titi");
		return "404";
	}
}
