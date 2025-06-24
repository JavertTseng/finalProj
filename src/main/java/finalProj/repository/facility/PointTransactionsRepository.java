package finalProj.repository.facility;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finalProj.domain.facility.PointTransactionsBean;

@Repository
public interface PointTransactionsRepository extends JpaRepository<PointTransactionsBean, Integer> {

	// 查特定住戶的所有交易紀錄
	List<PointTransactionsBean> findByUnitId(Integer unitId);

	// 查來源 ID 對應的所有交易
	List<PointTransactionsBean> findBySourceSourceId(Integer sourceId);

}
