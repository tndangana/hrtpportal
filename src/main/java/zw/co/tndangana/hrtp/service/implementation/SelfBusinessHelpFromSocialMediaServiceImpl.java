package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.ict.SelfBusinessHelpFromSocialMedia;
import zw.co.tndangana.hrtp.repository.SelfBusinessHelpFromSocialMediaRepository;
import zw.co.tndangana.hrtp.service.SelfBusinessHelpFromSocialMediaService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/11/17.
 */
@Service
public class SelfBusinessHelpFromSocialMediaServiceImpl implements SelfBusinessHelpFromSocialMediaService {
    @Resource
    private SelfBusinessHelpFromSocialMediaRepository selfBusinessHelpFromSocialMediaRepository;
    @Override
    public SelfBusinessHelpFromSocialMedia save(SelfBusinessHelpFromSocialMedia selfBusinessHelpFromSocialMedia) {
        return selfBusinessHelpFromSocialMediaRepository.save(selfBusinessHelpFromSocialMedia);
    }

    @Override
    public List<SelfBusinessHelpFromSocialMedia> findAll() {
        return (List<SelfBusinessHelpFromSocialMedia>) selfBusinessHelpFromSocialMediaRepository.findAll();
    }

    @Override
    public SelfBusinessHelpFromSocialMedia findOne(Long id) {
        return selfBusinessHelpFromSocialMediaRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
   selfBusinessHelpFromSocialMediaRepository.delete(id);
    }

    @Override
    public void delete(SelfBusinessHelpFromSocialMedia selfBusinessHelpFromSocialMedia) {

    }
}
