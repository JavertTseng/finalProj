package finalProj.service.facility;

import java.util.List;

import finalProj.domain.facility.FacilitiesBean;

public interface FacilitiesService {
	
	List<FacilitiesBean> findAll();                         // 查詢全部
	
    FacilitiesBean findById(Integer id);                    // 查詢單筆
    
    FacilitiesBean save(FacilitiesBean facility);           // 新增或更新
    
    void deleteById(Integer id);                            // 刪除
    
}
