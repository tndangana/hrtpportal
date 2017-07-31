package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.psycho.PsychoSocial;
import zw.co.tndangana.hrtp.domain.psycho.SkillTrainingReceived;
import zw.co.tndangana.hrtp.repository.SkillTrainingReceivedRepository;
import zw.co.tndangana.hrtp.service.SkillTrainingReceivedService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/13/17.
 */
@Service
public class SkillTrainingReceivedServiceImpl implements SkillTrainingReceivedService {
    @Resource
    private SkillTrainingReceivedRepository skillTrainingReceivedRepository;
    @Override
    public SkillTrainingReceived save(SkillTrainingReceived skillTrainingReceived) {
        return skillTrainingReceivedRepository.save(skillTrainingReceived);
    }

    @Override
    public List<SkillTrainingReceived> findAll() {
        return (List<SkillTrainingReceived>) skillTrainingReceivedRepository.findAll();
    }

    @Override
    public SkillTrainingReceived findOne(Long id) {
        return skillTrainingReceivedRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
   skillTrainingReceivedRepository.delete(id);
    }

    @Override
    public void delete(SkillTrainingReceived skillTrainingReceived) {

    }


}
