package finalProj.service.facility;

import java.time.LocalDateTime;
import java.util.List;

import finalProj.domain.facility.PointSourcesBean;

public interface PointSourcesService {
	 // 新增點數來源（例如配點或儲值）
    PointSourcesBean save(PointSourcesBean source);

    // 根據 ID 查詢單筆點數來源
    PointSourcesBean findById(Integer id);

    // 查詢某住戶所有的點數來源（有效期限排序）
    List<PointSourcesBean> findByUnitId(Integer unitId);

    // 更新點數來源狀態（手動標記已使用完或過期）
    PointSourcesBean updateStatus(Integer sourceId, String status);

    // 查詢即將到期的來源（可搭配排程用）
    List<PointSourcesBean> findExpiringSources(LocalDateTime beforeDate);

    // 依來源類型查詢（例如只查 monthly、topup）
    List<PointSourcesBean> findByUnitIdAndType(Integer unitId, String sourceType);
    
    List<PointSourcesBean> findByUnitIdAndRemainingGreaterThanAndPointStatusOrderByExpiredAtAsc(
    	    Integer unitId, int remaining, String pointStatus);
}
