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
@Table(name = "facility_reservation")
public class FacilityReservationBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_id")
	private Integer reservationId;

	@Column(name = "community_id")
	private Integer communityId;

	@Column(name = "unit_id", nullable = false)
	private Integer unitId;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@ManyToOne
	@JoinColumn(name = "facility_id", referencedColumnName = "facility_id")
	@JsonBackReference("facility-reservations")
	private FacilitiesBean facility;

	@Column(name = "number_of_users")
	private Integer numberOfUsers;

	@Column(name = "reservation_start_time", nullable = false)
	private LocalDateTime reservationStartTime;

	@Column(name = "reservation_end_time", nullable = false)
	private LocalDateTime reservationEndTime;

	@Column(name = "is_admin", nullable = false)
	private Boolean isAdmin = false;

	@Column(name = "required_points")
	private Integer requiredPoints;

	@Column(name = "actual_used_points")
	private Integer actualUsedPoints;

	@Column(name = "remark")
	private String remark;

	@Column(name = "reservation_status")
	private String reservationStatus = "APPROVED";

	@Column(name = "created_at")
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "canceled_at")
	private LocalDateTime canceledAt;

	@Column(name = "cancel_reason")
	private String cancelReason;

	// ---------- Getters & Setters ----------

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public FacilitiesBean getFacility() {
		return facility;
	}

	public void setFacility(FacilitiesBean facility) {
		this.facility = facility;
	}

	public Integer getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(Integer numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}

	public LocalDateTime getReservationStartTime() {
		return reservationStartTime;
	}

	public void setReservationStartTime(LocalDateTime reservationStartTime) {
		this.reservationStartTime = reservationStartTime;
	}

	public LocalDateTime getReservationEndTime() {
		return reservationEndTime;
	}

	public void setReservationEndTime(LocalDateTime reservationEndTime) {
		this.reservationEndTime = reservationEndTime;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getRequiredPoints() {
		return requiredPoints;
	}

	public void setRequiredPoints(Integer requiredPoints) {
		this.requiredPoints = requiredPoints;
	}

	public Integer getActualUsedPoints() {
		return actualUsedPoints;
	}

	public void setActualUsedPoints(Integer actualUsedPoints) {
		this.actualUsedPoints = actualUsedPoints;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getCanceledAt() {
		return canceledAt;
	}

	public void setCanceledAt(LocalDateTime canceledAt) {
		this.canceledAt = canceledAt;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	// ---------- toString ----------

    @Override
    public String toString() {
        return "FacilityReservationBean{" +
                "reservationId=" + reservationId +
                ", communityId=" + communityId +
                ", unitId=" + unitId +
                ", createdBy='" + createdBy + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                ", reservationStartTime=" + reservationStartTime +
                ", reservationEndTime=" + reservationEndTime +
                ", isAdmin=" + isAdmin +
                ", requiredPoints=" + requiredPoints +
                ", actualUsedPoints=" + actualUsedPoints +
                ", remark='" + remark + '\'' +
                ", reservationStatus='" + reservationStatus + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", canceledAt=" + canceledAt +
                ", cancelReason='" + cancelReason + '\'' +
                '}';
    }
}
