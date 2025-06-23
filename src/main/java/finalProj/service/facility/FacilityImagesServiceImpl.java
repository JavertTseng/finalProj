package finalProj.service.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProj.domain.facility.FacilityImagesBean;
import finalProj.repository.facility.FacilityImagesRepository;

@Service
public class FacilityImagesServiceImpl implements FacilityImagesService {

	@Autowired
	private FacilityImagesRepository facilityImagesRepository;

	@Override
	public List<FacilityImagesBean> findAll() {
		return facilityImagesRepository.findAll();
	}

	@Override
	public List<FacilityImagesBean> findByFacilityId(Integer facilityId) {
		return facilityImagesRepository.findByFacilityFacilityId(facilityId); // 這個方法需自訂 Repository
	}

	@Override
	public FacilityImagesBean findById(Integer id) {
		return facilityImagesRepository.findById(id).orElse(null);
	}

	@Override
	public FacilityImagesBean save(FacilityImagesBean image) {
		return facilityImagesRepository.save(image);
	}

	@Override
	public void deleteById(Integer id) {
		facilityImagesRepository.deleteById(id);
	}
}
