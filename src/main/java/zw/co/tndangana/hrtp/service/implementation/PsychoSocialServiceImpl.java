package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.domain.psycho.PsychoSocial;
import zw.co.tndangana.hrtp.repository.PsychoSocialRepository;
import zw.co.tndangana.hrtp.service.PsychoSocialService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/13/17.
 */
@Service
public class PsychoSocialServiceImpl implements PsychoSocialService {
    @Resource
    private PsychoSocialRepository psychoSocialRepository;
    @Override
    public PsychoSocial save(PsychoSocial psychoSocial) {
        return psychoSocialRepository.save(psychoSocial);
    }

    @Override
    public List<PsychoSocial> findAll() {
        return (List<PsychoSocial>) psychoSocialRepository.findAll();
    }

    @Override
    public PsychoSocial findOne(Long id) {
        return psychoSocialRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
  psychoSocialRepository.delete(id);
    }

    @Override
    public void delete(PsychoSocial psychoSocial) {

    }

    @Override
    public List<PsychoSocial> findPsychoSocialsByPatient(Patient patient) {
        return psychoSocialRepository.findPsychoSocialsByPatient(patient);
    }
}
