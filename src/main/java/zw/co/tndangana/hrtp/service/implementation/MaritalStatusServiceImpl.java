package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.MaritalStatus;
import zw.co.tndangana.hrtp.repository.MaritalStatusRepository;
import zw.co.tndangana.hrtp.service.MaritalStatusService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 6/21/17.
 */
@Service
public class MaritalStatusServiceImpl implements MaritalStatusService {
    @Resource
    private MaritalStatusRepository maritalStatusRepository;
    @Override
    public MaritalStatus save(MaritalStatus maritalStatus) {
        return maritalStatusRepository.save(maritalStatus);
    }

    @Override
    public List<MaritalStatus> findAll() {
        return (List<MaritalStatus>) maritalStatusRepository.findAll();
    }

    @Override
    public MaritalStatus findOne(Long id) {
        return maritalStatusRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
    maritalStatusRepository.delete(id);
    }

    @Override
    public void delete(MaritalStatus maritalStatus) {
     maritalStatusRepository.delete(maritalStatus);
    }
}
