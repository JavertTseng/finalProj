package finalProj.service.facility;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import finalProj.domain.facility.PointSourcesBean;

@SpringBootTest
public class PointSourcesServiceTest {

	@Autowired
	PointSourcesService pointSourcesService;

	@Test
	public void testFindByUnitId() {

		Integer UnitId = 104;
		List<PointSourcesBean> sources = pointSourcesService.findByUnitId(UnitId);

		int totalPoints = sources.stream()
				.mapToInt(PointSourcesBean::getRemaining)
				.sum();
		
		Optional<PointSourcesBean> soonestExpiring = sources.stream()
			    .filter(s -> s.getExpiredAt() != null)
			    .min(Comparator.comparing(PointSourcesBean::getExpiredAt));
		
		if(soonestExpiring.isPresent()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String expiredDate = soonestExpiring.get().getExpiredAt().format(formatter);
			Integer expiredPoint = soonestExpiring.get().getRemaining();			
			System.out.println("剩餘點數 : " + totalPoints + "，即將有" + expiredPoint + "點在" + expiredDate + "到期");			
		}else {
			System.out.println("剩餘點數 : " + totalPoints);
		}
		

		// Assert
		assertNotNull(sources, "查無此 UnitId 的資料");

	}

}
