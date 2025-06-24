package finalProj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finalProj.service.facility.PointSourcesService;

@RestController
@RequestMapping("/pointSources")
public class PointSourcesController {
	
	@Autowired
	private PointSourcesService pointSourcesService;
}
