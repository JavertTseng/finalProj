package finalProj.repository.facility;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finalProj.domain.facility.FacilityReservationsBean;

@Repository
public interface FacilityReservationsRepository extends JpaRepository<FacilityReservationsBean, Integer> {
	
	// 查詢某公設在某段時間內的預約（避免衝突）
	List<FacilityReservationsBean> findByFacilityFacilityIdAndReservationStartTimeBetween(Integer facilityId,
			LocalDateTime start, LocalDateTime end);

	// 查住戶的所有預約
	List<FacilityReservationsBean> findByUnitId(Integer unitId);

}
