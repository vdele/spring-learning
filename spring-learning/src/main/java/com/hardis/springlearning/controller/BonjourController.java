package com.hardis.springlearning.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BonjourController
{


	@RequestMapping(value = "/bonjour", method = RequestMethod.GET)
	public String afficherBonjour(@RequestParam(value = "personne") final String pPersonne, final ModelMap pModel)
	{
		pModel.addAttribute("personne", pPersonne);
		return "bonjour";
	}

	@RequestMapping(value = "/personneTest")
	public @ResponseBody String personneTest()
	{
		return "Not useful";
	}


	/*
	 * @RequestMapping(value = "/stadiums/{stadiumName}") public String showStadiumDetails(@PathVariable String
	 * stadiumName, final Model model) throws UnsupportedEncodingException { stadiumName = URLDecoder.decode(stadiumName,
	 * "UTF-8"); final StadiumData stadium = stadiumFacade.getStadium(stadiumName);
	 * stadium.setName(StadiumsNameEncoded.getNameEncoded(stadium.getName())); model.addAttribute("stadium", stadium);
	 * return "StadiumDetails"; }
	 *
	 */

}
