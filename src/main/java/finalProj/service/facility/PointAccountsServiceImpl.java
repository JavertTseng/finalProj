package finalProj.service.facility;

import java.time.LocalDateTime;
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
	private PointAccountsRepository pointAccountRepository;

	@Override
	public List<PointAccountsBean> findAll() {
		return pointAccountRepository.findAll();
	}

	@Override
	public PointAccountsBean findById(Integer id) {
		return pointAccountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("找不到 ID 為 " + id + " 的帳號。"));
	}

//	@Override
//	public PointAccountBean findByCommunityIdAndUnitId(Integer communityId, Integer unitId) {
//		return null;
//	}

	@Override
	public PointAccountsBean save(PointAccountsBean account) {
		if (account.getAccountId() != null && !pointAccountRepository.existsById(account.getAccountId())) {
			throw new ResourceNotFoundException("無法更新，找不到公設 ID: " + account.getAccountId());
		}
		return pointAccountRepository.save(account);
	}

	@Override
	public PointAccountsBean increasePoints(Integer accountId, int amount, String sourceType) {
		PointAccountsBean account = pointAccountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("找不到帳戶 ID：" + accountId));

		if ("topup".equalsIgnoreCase(sourceType)) {
			account.setTopupBalance(account.getTopupBalance() + amount);
		} else {
			account.setSystemBalance(account.getSystemBalance() + amount);
		}
	    account.setTotalBalance(account.getTotalBalance() + amount);
	    account.setUpdatedAt(LocalDateTime.now());
		return null;
	}

	@Override
	public PointAccountsBean decreasePoints(Integer accountId, int amount) {
		return null;
	}

	@Override
	public void deleteById(Integer id) {

	}

}
