package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.ict.MobileOperatingSystem;
import zw.co.tndangana.hrtp.repository.MobileOperatingSystemRepository;
import zw.co.tndangana.hrtp.service.MobileOperatingSystemService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */
@Service
public class MobileOperatingSystemServiceImpl implements MobileOperatingSystemService {

    @Resource
    private MobileOperatingSystemRepository mobileOperatingSystemRepository;

    @Override
    public MobileOperatingSystem save(MobileOperatingSystem mobileOperatingSystem) {
        return mobileOperatingSystemRepository.save(mobileOperatingSystem);
    }

    @Override
    public List<MobileOperatingSystem> findAll() {
        return (List<MobileOperatingSystem>)mobileOperatingSystemRepository.findAll();
    }

    @Override
    public MobileOperatingSystem findOne(Long id) {
        return mobileOperatingSystemRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
  mobileOperatingSystemRepository.delete(id);
    }

    @Override
    public void delete(MobileOperatingSystem mobileOperatingSystem) {

    }
}
