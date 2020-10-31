package com.julianna.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.julianna.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Jujubas", 200.0, days);
	}
}
