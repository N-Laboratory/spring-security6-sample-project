package com.example.springsecuritysample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.example.springsecuritysample.security.LoginUserDetails;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String index(Model model) {
		return "login";
	}

	@RequestMapping("/myPage")
	public String myPage(Model model) {
		return "myPage";
	}

	// If you get authentication info, use this method.
	// @GetMapping("/foo")
	// public String foo(@AuthenticationPrincipal LoginUserDetails userDetails) {
	// }
}