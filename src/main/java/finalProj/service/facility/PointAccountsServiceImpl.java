package finalProj.service.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProj.domain.facility.PointAccountsBean;
import finalProj.exception.ResourceNotFoundException;
import finalProj.repository.facility.PointAccountsRepository;

@Service
@Transactional
public class PointAccountsServiceImpl implements PointAccountsService {

	@Autowired
	private PointAccountsRepository pointAccountsRepository;

	@Override
	public List<PointAccountsBean> findAll() {
		return pointAccountsRepository.findAll();
	}

	@Override
	public PointAccountsBean findById(Integer id) {
		return pointAccountsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("找不到帳戶 ID：" + id));
	}

	@Override
	public PointAccountsBean findByCommunityIdAndUnitId(Integer communityId, Integer unitId) {
		return pointAccountsRepository.findByCommunityIdAndUnitId(communityId, unitId)
				.orElseThrow(() -> new ResourceNotFoundException("找不到社區 " + communityId + " 的住戶 " + unitId + " 的帳戶"));
	}

	@Override
	public PointAccountsBean save(PointAccountsBean account) {
		return pointAccountsRepository.save(account);
	}

	@Override
	public PointAccountsBean increasePoints(Integer accountId, int amount, String sourceType) {
		PointAccountsBean account = findById(accountId);
		if ("topup".equals(sourceType)) {
			account.setTopupBalance(account.getTopupBalance() + amount);
		}else {
			account.setSystemBalance(account.getSystemBalance() + amount);			
		}
		account.setTotalBalance(account.getTotalBalance() + amount);
		// 若你有另外紀錄 PointSources，可在這裡新增來源紀錄
		return pointAccountsRepository.save(account);
	}

	@Override
	public PointAccountsBean decreasePoints(Integer accountId, int amount) {
		PointAccountsBean account = findById(accountId);
		if (account.getTotalBalance() < amount) {
			throw new IllegalArgumentException("點數不足，無法扣除。");
		}
		account.setTotalBalance(account.getTotalBalance() - amount);
		return pointAccountsRepository.save(account);
	}

	@Override
	public void deleteById(Integer id) {
		if (!pointAccountsRepository.existsById(id)) {
			throw new ResourceNotFoundException("帳戶 ID 不存在，無法刪除：" + id);
		}
		pointAccountsRepository.deleteById(id);
	}
}