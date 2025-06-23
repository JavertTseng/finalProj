package finalProj.repository.facility;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finalProj.domain.facility.FacilityImagesBean;

@Repository
public interface FacilityImagesRepository extends JpaRepository<FacilityImagesBean, Integer> {
	 
	List<FacilityImagesBean> findByFacilityFacilityId(Integer facilityId);
	
}
