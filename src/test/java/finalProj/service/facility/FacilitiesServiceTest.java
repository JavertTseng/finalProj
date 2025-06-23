package finalProj.service.facility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import finalProj.domain.facility.FacilitiesBean;

@SpringBootTest
public class FacilitiesServiceTest {

	@Autowired
	private FacilitiesService facilitiesService;

	@Test
	public void testSaveFacility() {
		FacilitiesBean facility = new FacilitiesBean();
		facility.setCommunityId(1);
		facility.setFacilityName("測試健身房");
		facility.setMaxUsers(5);
		facility.setFacilityLocation("B1");
		facility.setOpenTime(LocalTime.of(9, 0));
		facility.setCloseTime(LocalTime.of(21, 0));
		facility.setFee(10);
		facility.setFacilityStatus("active");
		facility.setCreatedAt(LocalDateTime.now());

		FacilitiesBean saved = facilitiesService.save(facility);

		assertNotNull(saved.getFacilityId());
		assertEquals("測試健身房", saved.getFacilityName());
	}

	@Test
	public void testFindById() {
		// Arrange
		Integer facilityId = 1;

		// Act
		FacilitiesBean facility = facilitiesService.findById(facilityId);

		// Assert
		assertNotNull(facility, "查無此 ID 的資料");
		assertEquals("交誼廳", facility.getFacilityName(), "名稱不符");
	}

	@Test
	public void testFindAll() {

		List<FacilitiesBean> facilities = facilitiesService.findAll();

		// Assert
		assertNotNull(facilities);
		assertFalse(facilities.isEmpty());

		FacilitiesBean firstFacility = facilities.get(0);

		System.out.println("第一筆公設名稱：" + firstFacility.getFacilityName());
		assertEquals("交誼廳", firstFacility.getFacilityName()); // 根據你 insert 的順序來設計
	}

	@Test
	public void testDeleteById() {

		Integer deletedId = 9;
		FacilitiesBean existingBean = facilitiesService.findById(deletedId);
		assertNotNull(existingBean);

		facilitiesService.deleteById(deletedId);
		FacilitiesBean deletedBean = facilitiesService.findById(deletedId);

		assertNull(deletedBean);
	}
}
