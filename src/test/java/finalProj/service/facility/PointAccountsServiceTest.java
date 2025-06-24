package finalProj.service.facility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import finalProj.domain.facility.PointAccountsBean;

@SpringBootTest
public class PointAccountsServiceTest {

	@Autowired
	PointAccountsService pointAccountsService;

	@Test
	public void testFindById() {

		Integer accountId = 1;
		PointAccountsBean account = pointAccountsService.findById(accountId);

		// Assert
		assertNotNull(account, "查無此 ID 的資料");
		assertEquals(101, account.getUnitId(), "名稱不符");
	}

	@Test
	public void testIncreasePoints() {

		Integer accountId = 1;
		int amount = 10;
		String sourceType = "system";

		PointAccountsBean before = pointAccountsService.findById(accountId);
		int originalTopup = before.getTopupBalance();
		int originalSystem = before.getSystemBalance();
		int originalTotal = before.getTotalBalance();

		PointAccountsBean updated = pointAccountsService.increasePoints(accountId, amount, sourceType);
		// 驗證加點後的結果
		assertEquals(originalTopup + ("topup".equals(sourceType) ? amount : 0), updated.getTopupBalance());
		assertEquals(originalSystem + ("system".equals(sourceType) ? amount : 0), updated.getSystemBalance());
		assertEquals(originalTotal + amount, updated.getTotalBalance());
		assertEquals(accountId, updated.getAccountId());

	}
}
