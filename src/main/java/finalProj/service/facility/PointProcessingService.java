package finalProj.service.facility;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProj.domain.facility.PointAccountsBean;
import finalProj.domain.facility.PointSourcesBean;
import finalProj.domain.facility.PointTransactionsBean;

@Service
@Transactional
public class PointProcessingService {

    // PointProcessingService建立點數交易的全部邏輯，包含三張表的餘額顯示，點數來源控管，交易紀錄
	
    @Autowired
    private PointAccountsService pointAccountsService;

    @Autowired
    private PointSourcesService pointSourcesService;

    @Autowired
    private PointTransactionsService pointTransactionsService;

    //預約點數扣除
    public void processReservationPointDeduction(Integer accountId, int amount, Integer reservationId) {
        // 檢查帳戶餘額
        PointAccountsBean account = pointAccountsService.findById(accountId);
        if (account.getTotalBalance() < amount) {
            throw new RuntimeException("點數不足");
        }

        // 優先扣除即將到期的 source
		List<PointSourcesBean> activeSources = pointSourcesService
				.findByUnitIdAndRemainingGreaterThanAndPointStatusOrderByExpiredAtAsc(account.getUnitId(), 0,
						"active");

        int remainingAmount = amount;
        for (PointSourcesBean source : activeSources) {
            if (remainingAmount <= 0) break;

            int deduct = Math.min(source.getRemaining(), remainingAmount);
            source.setRemaining(source.getRemaining() - deduct);
            if (source.getRemaining() == 0) {
                source.setPointStatus("used");
            }
            pointSourcesService.save(source);

            // 建立扣點紀錄
            PointTransactionsBean txn = new PointTransactionsBean();
            txn.setUnitId(account.getUnitId());
            txn.setSourceId(source.getSourceId());
            txn.setAmount(-deduct);
            txn.setReservationId(reservationId);
            txn.setTransactionType("RESERVE");
            txn.setTransactionTime(LocalDateTime.now());
            pointTransactionsService.save(txn);

            remainingAmount -= deduct;
        }

        // 更新帳戶總點數
        pointAccountsService.decreasePoints(accountId, amount);
    }
    
	// 轉移點數
    public void processTransferPoint(Integer accountId, int amount, Integer reservationId) {
        //to do
    }
    
	// 系統調整
    public void processSystemPoint(Integer accountId, int amount, Integer reservationId) {
        //to do
    }
    
	// 儲值
    public void processTopupPoint(Integer accountId, int amount, Integer reservationId) {
        //to do
    }
    
    // 建立帳戶
    public void processCreatePoint(Integer accountId, int amount, Integer reservationId) {
        //to do
    }
    
    // 刪除帳戶
    public void processDeletePoint(Integer accountId, int amount, Integer reservationId) {
        //to do
    }

}

