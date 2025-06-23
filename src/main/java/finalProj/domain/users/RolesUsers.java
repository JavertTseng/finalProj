package finalProj.domain.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rolesusers")
public class RolesUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rolesusers_id")
    private Integer rolesusersId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "users_id", nullable = false)
    private Users userId;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "roles_id", nullable = false)
    private Roles roleId;

    @ManyToOne
    @JoinColumn(name = "community_id", referencedColumnName = "community_id")
    private Community community;

    // --- Getters and Setters ---
	public Integer getRolesusersId() {
		return rolesusersId;
	}

	public void setRolesusersId(Integer rolesusersId) {
		this.rolesusersId = rolesusersId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public Roles getRoleId() {
		return roleId;
	}

	public void setRoleId(Roles roleId) {
		this.roleId = roleId;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	@Override
	public String toString() {
		return "RolesUsers [rolesusersId=" + rolesusersId + ", userId=" + userId + ", roleId=" + roleId + ", community="
				+ community + ", getRolesusersId()=" + getRolesusersId() + ", getUserId()=" + getUserId()
				+ ", getRoleId()=" + getRoleId() + ", getCommunity()=" + getCommunity() + "]";
	}
	
}

