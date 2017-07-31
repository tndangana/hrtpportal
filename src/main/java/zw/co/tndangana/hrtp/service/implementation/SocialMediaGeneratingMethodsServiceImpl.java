package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.ict.SocialMediaGeneratingMethods;
import zw.co.tndangana.hrtp.repository.SocialMediaGeneratingMethodsRepository;
import zw.co.tndangana.hrtp.service.SocialMediaGeneratingMethodsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */
@Service
public class SocialMediaGeneratingMethodsServiceImpl implements SocialMediaGeneratingMethodsService {
   @Resource
   private SocialMediaGeneratingMethodsRepository socialMediaGeneratingMethodsRepository;

    @Override
    public SocialMediaGeneratingMethods save(SocialMediaGeneratingMethods socialMediaGeneratingMethods) {
        return socialMediaGeneratingMethodsRepository.save(socialMediaGeneratingMethods);
    }

    @Override
    public List<SocialMediaGeneratingMethods> findAll() {
        return (List<SocialMediaGeneratingMethods>) socialMediaGeneratingMethodsRepository.findAll();
    }

    @Override
    public SocialMediaGeneratingMethods findOne(Long id) {
        return socialMediaGeneratingMethodsRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
  socialMediaGeneratingMethodsRepository.delete(id);
    }

    @Override
    public void delete(SocialMediaGeneratingMethods socialMediaGeneratingMethods) {

    }
}
