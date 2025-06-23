package finalProj.domain.facility;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
	name = "point_account",
	uniqueConstraints = @UniqueConstraint(columnNames = {"unit_id", "community_id"})
	)
public class PointAccountBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Integer accountId;

	@Column(name = "community_id", nullable = false)
	private Integer communityId;

	@Column(name = "unit_id", nullable = false)
	private Integer unitId;

	@Column(name = "total_balance", nullable = false)
	private Integer totalBalance = 0;

	@Column(name = "system_balance", nullable = false)
	private Integer systemBalance = 0;

	@Column(name = "topup_balance", nullable = false)
	private Integer topupBalance = 0;

	@Column(name = "is_active", nullable = false, columnDefinition = "bit default 1")
	private Boolean isActive = true;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt = LocalDateTime.now();

	// ---------- Getters & Setters ----------

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public Integer getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Integer totalBalance) {
		this.totalBalance = totalBalance;
	}

	public Integer getSystemBalance() {
		return systemBalance;
	}

	public void setSystemBalance(Integer systemBalance) {
		this.systemBalance = systemBalance;
	}

	public Integer getTopupBalance() {
		return topupBalance;
	}

	public void setTopupBalance(Integer topupBalance) {
		this.topupBalance = topupBalance;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

    // ---------- toString ----------

    @Override
    public String toString() {
        return "PointAccountBean{" +
                "accountId=" + accountId +
                ", communityId=" + communityId +
                ", unitId=" + unitId +
                ", totalBalance=" + totalBalance +
                ", systemBalance=" + systemBalance +
                ", topupBalance=" + topupBalance +
                ", isActive=" + isActive +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
