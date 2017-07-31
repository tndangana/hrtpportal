package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.ict.SocialMediaApplication;
import zw.co.tndangana.hrtp.repository.SocialMediaApplicationRepository;
import zw.co.tndangana.hrtp.service.SocialMediaApplicationService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */
@Service
public class SocialMediaApplicationServiceImpl implements SocialMediaApplicationService{

@Resource
private SocialMediaApplicationRepository socialMediaApplicationRepository;
    @Override
    public SocialMediaApplication save(SocialMediaApplication socialMediaApplication) {
        return socialMediaApplicationRepository.save(socialMediaApplication);
    }

    @Override
    public List<SocialMediaApplication> findAll() {
        return (List<SocialMediaApplication>)socialMediaApplicationRepository.findAll();
    }

    @Override
    public SocialMediaApplication findOne(Long id) {
        return socialMediaApplicationRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
      socialMediaApplicationRepository.delete(id);
    }

    @Override
    public void delete(SocialMediaApplication socialMediaApplication) {

    }
}
