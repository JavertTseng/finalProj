package finalProj.domain.facility;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "point_source")
public class PointSourceBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "source_id")
	private Integer sourceId;

	@Column(name = "community_id", nullable = false)
	private Integer communityId;

	@Column(name = "unit_id", nullable = false)
	private Integer unitId;

	@Column(name = "source_type", nullable = false)
	private String sourceType; // e.g. "monthly", "topup"

	@Column(name = "source_description")
	private String sourceDescription;

	@Column(name = "amount", nullable = false)
	private Integer amount;

	@Column(name = "remaining", nullable = false)
	private Integer remaining;

	@Column(name = "issued_at")
	private LocalDateTime issuedAt = LocalDateTime.now();

	@Column(name = "expired_at")
	private LocalDateTime expiredAt;

	@Column(name = "point_status")
	private String pointStatus = "active";

	@OneToMany(mappedBy = "source", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference("source-transaction")
	private List<PointTransactionBean> transactions;
	
	// ---------- Getters & Setters ----------

	public List<PointTransactionBean> getTransactions() {
	    return transactions;
	}

	public void setTransactions(List<PointTransactionBean> transactions) {
	    this.transactions = transactions;
	}	
	
	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
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

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getSourceDescription() {
		return sourceDescription;
	}

	public void setSourceDescription(String sourceDescription) {
		this.sourceDescription = sourceDescription;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getRemaining() {
		return remaining;
	}

	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}

	public LocalDateTime getIssuedAt() {
		return issuedAt;
	}

	public void setIssuedAt(LocalDateTime issuedAt) {
		this.issuedAt = issuedAt;
	}

	public LocalDateTime getExpiredAt() {
		return expiredAt;
	}

	public void setExpiredAt(LocalDateTime expiredAt) {
		this.expiredAt = expiredAt;
	}

	public String getPointStatus() {
		return pointStatus;
	}

	public void setPointStatus(String pointStatus) {
		this.pointStatus = pointStatus;
	}

	// ---------- toString ----------

    @Override
    public String toString() {
        return "PointSourceBean{" +
                "sourceId=" + sourceId +
                ", communityId=" + communityId +
                ", unitId=" + unitId +
                ", sourceType='" + sourceType + '\'' +
                ", sourceDescription='" + sourceDescription + '\'' +
                ", amount=" + amount +
                ", remaining=" + remaining +
                ", issuedAt=" + issuedAt +
                ", expiredAt=" + expiredAt +
                ", pointStatus='" + pointStatus + '\'' +
                '}';
    }
}