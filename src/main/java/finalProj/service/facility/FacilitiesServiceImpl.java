package finalProj.service.facility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProj.domain.facility.FacilitiesBean;
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
		return facilitiesRepository.findById(id).orElse(null);
	}

	@Override
	public FacilitiesBean save(FacilitiesBean facility) {
		return facilitiesRepository.save(facility);
	}

	@Override
	public void deleteById(Integer id) {
		facilitiesRepository.deleteById(id);
	}

}
