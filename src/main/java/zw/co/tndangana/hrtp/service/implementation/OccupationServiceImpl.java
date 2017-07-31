package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.Occupation;
import zw.co.tndangana.hrtp.repository.OccupationRepository;
import zw.co.tndangana.hrtp.service.OccupationService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 6/22/17.
 */
@Service
public class OccupationServiceImpl implements OccupationService {


    @Resource
    private OccupationRepository occupationRepository;
    @Override
    public Occupation save(Occupation occupation) {
        return occupationRepository.save(occupation);
    }

    @Override
    public List<Occupation> findAll() {
        return (List<Occupation>) occupationRepository.findAll();
    }

    @Override
    public Occupation findOne(Long id) {
        return occupationRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        occupationRepository.delete(id);
    }

    @Override
    public void delete(Occupation occupation) {
        occupationRepository.delete(occupation);
    }
}
