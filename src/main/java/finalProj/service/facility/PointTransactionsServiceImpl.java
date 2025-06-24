package finalProj.service.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProj.domain.facility.PointTransactionsBean;
import finalProj.repository.facility.PointTransactionsRepository;

@Service
@Transactional
public class PointTransactionsServiceImpl implements PointTransactionsService {

	@Autowired
	private PointTransactionsRepository pointTransactionsRepository;

	@Override
	public PointTransactionsBean save(PointTransactionsBean transaction) {
		return pointTransactionsRepository.save(transaction);
	}

	@Override
	public List<PointTransactionsBean> findByUnitId(Integer unitId) {
		return pointTransactionsRepository.findByUnitId(unitId);
	}

	@Override
	public void deleteById(Integer transactionId) {
		pointTransactionsRepository.deleteById(transactionId);
	}

	@Override
	public List<PointTransactionsBean> findAll() {
		return pointTransactionsRepository.findAll();
	}

}
