package finalProj.service.facility;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import finalProj.domain.facility.FacilitiesBean;
import finalProj.domain.facility.FacilityReservationBean;

@SpringBootTest
public class FacilityReservationServiceTest {

	@Autowired
	private FacilityReservationService facilityReservationService;

	@Test
	public void testFindById() {
		FacilityReservationBean reservation = facilityReservationService.findById(7);
		assertNotNull(reservation);
		System.out.println(reservation);
	}

	@Test
	public void testFindAll() {
		List<FacilityReservationBean> reservation = facilityReservationService.findAll();
		assertNotNull(reservation);
		assertTrue(reservation.size() >= 0);
	}

	@Test
	public void testSave() {
		FacilityReservationBean reservation = new FacilityReservationBean();
		FacilitiesBean facility = new FacilitiesBean();
		facility.setFacilityId(1); // 必須確保這個 ID 在資料庫中已存在

		reservation.setFacility(facility); // 設定整個關聯物件
		reservation.setUnitId(101);
		reservation.setCreatedBy("測試人員");
		reservation.setReservationStartTime(LocalDateTime.now().plusDays(1));
		reservation.setReservationEndTime(LocalDateTime.now().plusDays(1).plusHours(1));
		reservation.setReservationStatus("APPROVED");
		reservation.setNumberOfUsers(2);

		FacilityReservationBean saved = facilityReservationService.save(reservation);
		assertNotNull(saved.getReservationId());
	}

	@Test
	public void testDeleteById() {
		// 請替換成一筆實際存在的 reservationId
		Integer idToDelete = 11;
		facilityReservationService.deleteById(idToDelete);
		assertNull(facilityReservationService.findById(idToDelete));
	}

	@Test
	public void testFindByUnitId() {
		List<FacilityReservationBean> result = facilityReservationService.findByUnitId(101);
		assertNotNull(result);
		result.forEach(System.out::println);
	}

	@Test
	public void testFindByFacilityIdAndTimeRange() {
		LocalDateTime start = LocalDateTime.now().with(LocalTime.of(8, 0)); //當天早上8:00
		LocalDateTime end = start.plusDays(7);//往後5天內都算

		List<FacilityReservationBean> result = facilityReservationService.findByFacilityIdAndTimeRange(2, start, end);
		assertNotNull(result);
		result.forEach(System.out::println);
	}

}
