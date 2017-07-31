package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.psycho.SurplusProduceUsage;
import zw.co.tndangana.hrtp.repository.SurplusProduceUsageRepository;
import zw.co.tndangana.hrtp.service.SurplusProduceUsageService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/13/17.
 */
@Service
public class SurplusProduceUsageServiceImpl  implements SurplusProduceUsageService {
    @Resource
    private SurplusProduceUsageRepository surplusProduceUsageRepository;
    @Override
    public SurplusProduceUsage save(SurplusProduceUsage surplusProduceUsage) {
        return surplusProduceUsageRepository.save(surplusProduceUsage);
    }

    @Override
    public List<SurplusProduceUsage> findAll() {
        return (List<SurplusProduceUsage>) surplusProduceUsageRepository.findAll();
    }

    @Override
    public SurplusProduceUsage findOne(Long id) {
        return surplusProduceUsageRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
     surplusProduceUsageRepository.delete(id);
    }

    @Override
    public void delete(SurplusProduceUsage surplusProduceUsage) {

    }
}
