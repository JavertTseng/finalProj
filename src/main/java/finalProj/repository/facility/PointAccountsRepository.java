package finalProj.repository.facility;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finalProj.domain.facility.PointAccountsBean;

@Repository
public interface PointAccountsRepository extends JpaRepository<PointAccountsBean, Integer> {

}
