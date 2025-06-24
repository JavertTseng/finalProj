package finalProj.domain.facility;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "point_transactions")
public class PointTransactionsBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "community_id", nullable = false)
    private Integer communityId;

    @Column(name = "unit_id", nullable = false)
    private Integer unitId;

    @ManyToOne
    @JoinColumn(name = "source_id", referencedColumnName = "source_id")
    @JsonBackReference("source-transaction")
    private PointSourcesBean source;

    @Column(name = "change_type", nullable = false)
    private String changeType;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "related_unit_id")
    private Integer relatedUnitId;

    @Column(name = "transaction_description")
    private String transactionDescription;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // ----------- Getter / Setter ------------

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
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

    public PointSourcesBean getSource() {
        return source;
    }

    public void setSource(PointSourcesBean source) {
        this.source = source;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getRelatedUnitId() {
        return relatedUnitId;
    }

    public void setRelatedUnitId(Integer relatedUnitId) {
        this.relatedUnitId = relatedUnitId;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // ----------- toString ------------

    @Override
    public String toString() {
        return "PointTransactionBean{" +
                "transactionId=" + transactionId +
                ", communityId=" + communityId +
                ", unitId=" + unitId +
                ", sourceId=" + (source != null ? source.getSourceId() : null) +
                ", changeType='" + changeType + '\'' +
                ", amount=" + amount +
                ", relatedUnitId=" + relatedUnitId +
                ", transactionDescription='" + transactionDescription + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
