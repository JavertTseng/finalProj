package finalProj.service.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProj.domain.facility.FacilitiesBean;
import finalProj.exception.ResourceNotFoundException;
import finalProj.repository.facility.FacilitiesRepository;

@Service
public class FacilitiesServiceImpl implements FacilitiesService {

	@Autowired
	private FacilitiesRepository facilitiesRepository;

	@Override
	public List<FacilitiesBean> findAll() {
		return facilitiesRepository.findAll();
	}


	@Override
	public FacilitiesBean findById(Integer id) {
		// 使用 orElseThrow() 來拋出異常
		return facilitiesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("找不到 ID 為 " + id + " 的設施。"));
	}

	@Override
	public FacilitiesBean save(FacilitiesBean facility) {
		if (facility.getFacilityId() != null && !facilitiesRepository.existsById(facility.getFacilityId())) {
			throw new ResourceNotFoundException("無法更新，找不到公設 ID: " + facility.getFacilityId());
		}
		return facilitiesRepository.save(facility);
	}

	@Override
	public void deleteById(Integer id) {
		if (!facilitiesRepository.existsById(id)) {
			throw new ResourceNotFoundException("刪除失敗，找不到 ID: " + id);
		}
		facilitiesRepository.deleteById(id);
	}
}
