package finalProj.service.facility;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProj.domain.facility.FacilityReservationBean;
import finalProj.repository.facility.FacilityReservationRepository;

@Service
public class FacilityReservationServiceImpl implements FacilityReservationService {

	@Autowired
	private FacilityReservationRepository facilityReservationRepository;

	@Override
	public List<FacilityReservationBean> findAll() {
		return facilityReservationRepository.findAll();
	}

	@Override
	public FacilityReservationBean findById(Integer id) {
		return facilityReservationRepository.findById(id).orElse(null);
	}

	@Override
	public FacilityReservationBean save(FacilityReservationBean reservation) {
		return facilityReservationRepository.save(reservation);
	}

	@Override
	public void deleteById(Integer id) {
		facilityReservationRepository.deleteById(id);
	}

	@Override
	public List<FacilityReservationBean> findByFacilityIdAndTimeRange(Integer facilityId, LocalDateTime start,
			LocalDateTime end) {
		return facilityReservationRepository.findByFacilityFacilityIdAndReservationStartTimeBetween(facilityId, start,
				end);
	}

	@Override
	public List<FacilityReservationBean> findByUnitId(Integer unitId) {
		return facilityReservationRepository.findByUnitId(unitId);
	}

}
