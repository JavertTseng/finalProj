package finalProj.service.facility;

import java.time.LocalDateTime;
import java.util.List;

import finalProj.domain.facility.FacilityReservationBean;

public interface FacilityReservationService {
	
	List<FacilityReservationBean> findAll();

	FacilityReservationBean findById(Integer id);

	FacilityReservationBean save(FacilityReservationBean reservation);

	void deleteById(Integer id);

	List<FacilityReservationBean> findByFacilityIdAndTimeRange(Integer facilityId, LocalDateTime start,
			LocalDateTime end);

	List<FacilityReservationBean> findByUnitId(Integer unitId);
}
