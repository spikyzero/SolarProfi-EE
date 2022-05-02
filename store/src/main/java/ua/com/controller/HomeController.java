package ua.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.constants.Fields;


@Controller
@RequestMapping("/")
public class HomeController implements GeneralController
{
	@GetMapping
	public String showHome(final Model model)
	{
		model.addAttribute(Fields.ATTRIBUTE_TITLE, TITLE_HOME);
		return FORWARD_HOME;
	}
}
