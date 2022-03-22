package com.nttdata.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import com.nttdata.hrpayroll.entities.Payment;
import com.nttdata.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;

	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}

	@GetMapping(value = "/{workerId}/{days}")
	public Payment getPaymentRest(@PathVariable Long workerId, @PathVariable Integer days) {
		Map<String, Long> uriVariables = new HashMap<>();
		uriVariables.put("id", workerId);

		ResponseEntity<Payment> responseEntity = new RestTemplate().getForEntity(
				"http://192.168.15.81/hr-worker/workers/{id}", Payment.class,
				uriVariables);

		Payment payment = responseEntity.getBody();

		return new Payment(payment.getName(), payment.getDailyIncome(), days);
	}

	@GetMapping(value = "/soma")
	public int soma() {
		int valor1 = 1;
		int valor2 = 1;
		return valor1 + valor2;
	}

	@GetMapping(value = "/soma/{valor1}/{valor2}")
	public int soma(@PathVariable int valor1, @PathVariable int valor2) {
		return valor1 + valor2;
	}

}
