package finalProj.service.facility;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProj.domain.facility.FacilityReservationsBean;
import finalProj.exception.ResourceNotFoundException;
import finalProj.repository.facility.FacilityReservationsRepository;

@Service
public class FacilityReservationsServiceImpl implements FacilityReservationsService {

	@Autowired
	private FacilityReservationsRepository facilityReservationRepository;

	@Override
	public List<FacilityReservationsBean> findAll() {
		List<FacilityReservationsBean> reservations = facilityReservationRepository.findAll();
		if (reservations.isEmpty()) {
			throw new ResourceNotFoundException("目前尚無任何預約資料。");
		}
		return facilityReservationRepository.findAll();
	}

	@Override
	public FacilityReservationsBean findById(Integer id) {
		return facilityReservationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("找不到 ID 為 " + id + " 的預約資料。"));
	}

	@Override
	public FacilityReservationsBean save(FacilityReservationsBean reservation) {
		return facilityReservationRepository.save(reservation);
	}

	@Override
	public void deleteById(Integer id) {
		if (!facilityReservationRepository.existsById(id)) {
			throw new ResourceNotFoundException("無法刪除，找不到 ID 為 " + id + " 的預約資料。");
		}
		facilityReservationRepository.deleteById(id);
	}

	@Override
	public List<FacilityReservationsBean> findByFacilityIdAndTimeRange(Integer facilityId, LocalDateTime start,
			LocalDateTime end) {
		List<FacilityReservationsBean> reservations = facilityReservationRepository
				.findByFacilityFacilityIdAndReservationStartTimeBetween(facilityId, start, end);
		if (reservations.isEmpty()) {
			throw new ResourceNotFoundException("找不到公設 ID 為 " + facilityId + " 在指定時間區間的預約紀錄。");
		}
		return reservations;
	}

	@Override
	public List<FacilityReservationsBean> findByUnitId(Integer unitId) {
		List<FacilityReservationsBean> reservations = facilityReservationRepository.findByUnitId(unitId);
		if (reservations.isEmpty()) {
			throw new ResourceNotFoundException("找不到住戶 ID 為 " + unitId + " 的預約紀錄。");
		}
		return reservations;
	}

}
