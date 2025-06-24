package finalProj.service.facility;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProj.domain.facility.PointSourcesBean;
import finalProj.exception.ResourceNotFoundException;
import finalProj.repository.facility.PointSourcesRepository;

@Service
@Transactional
public class PointSourcesServiceImpl implements PointSourcesService {

    @Autowired
    private PointSourcesRepository pointSourcesRepository;

    @Override
    public PointSourcesBean save(PointSourcesBean source) {
        return pointSourcesRepository.save(source);
    }

    @Override
    public PointSourcesBean findById(Integer id) {
        return pointSourcesRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("找不到 ID 為 " + id + " 的點數來源"));
    }

    @Override
    public List<PointSourcesBean> findByUnitId(Integer unitId) {
        return pointSourcesRepository.findByUnitId(unitId);
    }
    

    @Override
    public PointSourcesBean updateStatus(Integer sourceId, String status) {
        PointSourcesBean source = findById(sourceId);
        source.setPointStatus(status);
        return pointSourcesRepository.save(source);
    }

    @Override
    public List<PointSourcesBean> findExpiringSources(LocalDateTime beforeDate) {
        return pointSourcesRepository.findByExpiredAtBeforeAndPointStatus(beforeDate, "active");
    }

    @Override
    public List<PointSourcesBean> findByUnitIdAndType(Integer unitId, String sourceType) {
        return pointSourcesRepository.findByUnitIdAndSourceType(unitId, sourceType);
    }

	@Override
	public List<PointSourcesBean> findByUnitIdAndRemainingGreaterThanAndPointStatusOrderByExpiredAtAsc(Integer unitId,
			int remaining, String pointStatus) {
		return pointSourcesRepository.findByUnitIdAndRemainingGreaterThanAndPointStatusOrderByExpiredAtAsc(unitId,
				remaining, pointStatus);
	}

	
	
}
