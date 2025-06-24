package finalProj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finalProj.service.facility.FacilityReservationsService;

@RestController
@RequestMapping("/FacilityReservations")
public class FacilityReservationsController {
	
	@Autowired
	private FacilityReservationsService facilityReservationsService;
	
}
