package finalProj.repository.facility;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import finalProj.domain.facility.PointSourcesBean;

@Repository
public interface PointSourcesRepository extends JpaRepository<PointSourcesBean, Integer> {

	// 查還有點數可用，且尚未過期的來源（常用於扣點）
	@Query("SELECT p FROM PointSourcesBean p WHERE p.unitId = :unitId AND p.remaining > 0 AND (p.expiredAt IS NULL OR p.expiredAt > :now) ORDER BY p.expiredAt ASC")
	List<PointSourcesBean> findAvailableSources(@Param("unitId") Integer unitId, @Param("now") LocalDateTime now);

}
