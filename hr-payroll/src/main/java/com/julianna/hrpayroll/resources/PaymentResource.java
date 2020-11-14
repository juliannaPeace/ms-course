package com.julianna.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julianna.hrpayroll.entities.Payment;
import com.julianna.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;

	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable long workerId, @PathVariable Integer days) {

		Payment payment = service.getPayment(workerId, days);

		return ResponseEntity.ok().body(payment);
	}

	public ResponseEntity<Payment> getPaymentAlternative(long workerId, Integer days) {

		Payment payment = new Payment("Alternativo", 1200.00, days);

		return ResponseEntity.ok().body(payment);
	}

}
