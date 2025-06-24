package finalProj.dto;

import java.util.List;

import finalProj.domain.facility.FacilitiesBean;

public class FacilitiesResponse {
    private Boolean success;
    private String message;
    private Long count;
    private List<FacilitiesBean> list;
    
	@Override
	public String toString() {
		return "FacilitiesResponse [success=" + success + ", message=" + message + ", count=" + count + ", list=" + list
				+ "]";
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<FacilitiesBean> getList() {
		return list;
	}
	public void setList(List<FacilitiesBean> list) {
		this.list = list;
	}
    
}
