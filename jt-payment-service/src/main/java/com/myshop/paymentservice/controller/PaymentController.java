package com.myshop.paymentservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/payment")
public class PaymentController {

	@GetMapping("/test")
	public String Test() {
		return "working";
	}
}
