package finalProj.service.facility;

import java.util.List;

import finalProj.domain.facility.PointTransactionsBean;

public interface PointTransactionsService {
	// 新增一筆異動紀錄（加點、扣點、轉移）
	PointTransactionsBean save(PointTransactionsBean transaction);

	// 查詢某位住戶所有點數異動紀錄（含儲值、扣點、轉帳等）
	List<PointTransactionsBean> findByUnitId(Integer unitId);
	

	// 刪除或作廢交易（如取消預約後反轉異動）
	void deleteById(Integer transactionId);

	// 查詢所有點數異動（管理員報表用）
	List<PointTransactionsBean> findAll();
}
