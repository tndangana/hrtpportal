package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.ict.SocialMediaBenefits;
import zw.co.tndangana.hrtp.repository.SocialMediaBenefitsRepository;
import zw.co.tndangana.hrtp.service.SocialMediaBenefitsService;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by tndangana on 7/5/17.
 */
@Service
public class SocialMediaBenefitsServiceImpl implements SocialMediaBenefitsService{
    @Resource
    private SocialMediaBenefitsRepository socialMediaBenefitsRepository;
    @Override
    public SocialMediaBenefits save(SocialMediaBenefits socialMediaBenefits) {
        return socialMediaBenefitsRepository.save(socialMediaBenefits);
    }

    @Override
    public List<SocialMediaBenefits> findAll() {
        return (List<SocialMediaBenefits>)socialMediaBenefitsRepository.findAll();
    }

    @Override
    public SocialMediaBenefits findOne(Long id) {
        return socialMediaBenefitsRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        socialMediaBenefitsRepository.delete(id);
    }

    @Override
    public void delete(SocialMediaBenefits socialMediaBenefits) {

    }
}
