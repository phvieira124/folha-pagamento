package com.nttdata.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.hrpayroll.entities.Payment;
import com.nttdata.hrpayroll.entities.Worker;
import com.nttdata.hrpayroll.feignclients.WorkerFeignClient;

@Service("hrPayRollService")
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {

		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);

	}
}
