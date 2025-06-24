package finalProj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finalProj.service.facility.PointTransactionsService;

@RestController
@RequestMapping("/pointTransactions")
public class PointTransactionsController {
	
	@Autowired
	private PointTransactionsService pointTransactionsService;
}
