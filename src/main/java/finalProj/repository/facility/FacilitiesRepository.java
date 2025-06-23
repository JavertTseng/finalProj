package finalProj.repository.facility;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finalProj.domain.facility.FacilitiesBean;

@Repository
public interface FacilitiesRepository extends JpaRepository<FacilitiesBean, Integer> {
	

	
}
