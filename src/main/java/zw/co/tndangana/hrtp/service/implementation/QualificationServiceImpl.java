package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.Qualification;
import zw.co.tndangana.hrtp.repository.QualificationRepository;
import zw.co.tndangana.hrtp.service.QualificationService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 6/22/17.
 */
@Service
public class QualificationServiceImpl implements QualificationService{

    @Resource
    private QualificationRepository qualificationRepository;
    @Override
    public Qualification save(Qualification qualification) {
        return qualificationRepository.save(qualification);
    }

    @Override
    public List<Qualification> findAll() {
        return (List<Qualification>) qualificationRepository.findAll();
    }

    @Override
    public Qualification findOne(Long id) {
        return qualificationRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        qualificationRepository.delete(id);
    }

    @Override
    public void delete(Qualification qualification) {
        qualificationRepository.delete(qualification);
    }
}
