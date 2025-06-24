package finalProj.service.facility;

import java.time.LocalDateTime;
import java.util.List;

import finalProj.domain.facility.FacilityReservationsBean;

public interface FacilityReservationsService {
	
	List<FacilityReservationsBean> findAll();

	FacilityReservationsBean findById(Integer id);

	FacilityReservationsBean save(FacilityReservationsBean reservation);

	void deleteById(Integer id);

	List<FacilityReservationsBean> findByFacilityIdAndTimeRange(Integer facilityId, LocalDateTime start,
			LocalDateTime end);

	List<FacilityReservationsBean> findByUnitId(Integer unitId);
}
