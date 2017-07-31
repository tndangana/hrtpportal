package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.Religion;
import zw.co.tndangana.hrtp.repository.ReligionRepository;
import zw.co.tndangana.hrtp.service.ReligionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 6/21/17.
 */
@Service
public class ReligionServiceImpl implements ReligionService {
    @Resource
    private ReligionRepository religionRepository;

    @Override
    public Religion save(Religion religion) {
        return religionRepository.save(religion);
    }

    @Override
    public List<Religion> findAll() {
        return (List<Religion>)religionRepository.findAll();
    }

    @Override
    public Religion findOne(Long id) {
        return religionRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
       religionRepository.delete(id);
    }

    @Override
    public void delete(Religion religion) {
    religionRepository.delete(religion);
    }
}
