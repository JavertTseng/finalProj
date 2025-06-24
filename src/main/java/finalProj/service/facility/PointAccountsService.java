package finalProj.service.facility;

import java.util.List;

import finalProj.domain.facility.PointAccountsBean;

public interface PointAccountsService {
	
	// 查詢所有住戶的點數帳戶（管理用途）
	List<PointAccountsBean> findAll();

	// 依帳戶 ID 查單筆
	PointAccountsBean findById(Integer id);

	// 依社區與住戶 ID 查找（唯一值）
	PointAccountsBean findByCommunityIdAndUnitId(Integer communityId, Integer unitId);

	// 新增或更新帳戶（首次建立或系統調整用）
	PointAccountsBean save(PointAccountsBean account);

	// 加點（可用於儲值、系統發放）
	PointAccountsBean increasePoints(Integer accountId, int amount, String sourceType);

	// 扣點（預約時使用）
	PointAccountsBean decreasePoints(Integer accountId, int amount);

	// 刪除帳戶（通常不開放，保留管理用途）
	void deleteById(Integer id);
}
