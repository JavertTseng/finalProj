package finalProj.service.facility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import finalProj.domain.facility.PointTransactionsBean;

@SpringBootTest
public class PointTransactionsServiceTest {

	@Autowired
	PointTransactionsService pointTransactionsService;

	@Test
	public void testFindByUnitId() {

		Integer UnitId = 104;
		List<PointTransactionsBean> tx = pointTransactionsService.findByUnitId(UnitId);

		// Assert
		assertNotNull(tx, "查無此 UnitId 的資料");
		assertEquals(-10, tx.get(0).getAmount());

	}

}
