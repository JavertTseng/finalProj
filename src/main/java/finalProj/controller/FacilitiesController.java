package finalProj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finalProj.service.facility.FacilitiesService;

@RestController
@RequestMapping("/facilities")
public class FacilitiesController {
	
	@Autowired
	private FacilitiesService facilitiesService;
	
	
}
