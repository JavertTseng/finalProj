package finalProj.repository.facility;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finalProj.domain.facility.PointAccountBean;

@Repository
public interface PointAccountRepository extends JpaRepository<PointAccountBean, Integer> {

}
