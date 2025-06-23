package finalProj.service.facility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import finalProj.domain.facility.FacilitiesBean;
import finalProj.domain.facility.FacilityImagesBean;

@SpringBootTest
public class FacilityImagesServiceTest {
	@Autowired
	private FacilityImagesService facilityImagesService;

	@Test
	public void testFindAll() {
		List<FacilityImagesBean> images = facilityImagesService.findAll();

		assertNotNull(images);
		assertTrue(images.size() >= 0); // 可視資料狀況調整
	}

	@Test
	public void testFindByFacilityId() {

		Integer facilityId = 5;
		List<FacilityImagesBean> images = facilityImagesService.findByFacilityId(facilityId);

		assertNotNull(images);
		assertTrue(images.size() >= 0); // 可視資料狀況調整
	}

	@Test
	public void testFindById() {

		Integer id = 1;
		FacilityImagesBean images = facilityImagesService.findById(id);

		assertNotNull(images);
		assertEquals("/images/facilities/lounge.jpg", images.getImageUrl()); // 可視資料狀況調整
	}

	@Test
	public void testSaveAndDelete() {

		FacilityImagesBean image = new FacilityImagesBean();

		image.setImageUrl("test_url.jpg");
		image.setImageDescription("測試用圖片");
		image.setSortOrder(1);
		image.setCreatedAt(LocalDateTime.now());

		// 設定關聯的公設
		FacilitiesBean facility = new FacilitiesBean();
		facility.setFacilityId(1); // 假設 DB 中有 ID 為 1 的公設
		image.setFacility(facility);
		
		FacilityImagesBean saved = facilityImagesService.save(image);

		assertNotNull(saved);
		assertEquals("test_url.jpg", saved.getImageUrl()); // 可視資料狀況調整
		
		
		Integer deletedId = saved.getImageId();
		FacilityImagesBean existingBean = facilityImagesService.findById(deletedId);
		assertNotNull(existingBean);
		
		facilityImagesService.deleteById(deletedId);
		FacilityImagesBean deletedBean = facilityImagesService.findById(deletedId);
		assertNull(deletedBean);
				
	}
}
