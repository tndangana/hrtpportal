package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.domain.ict.IctData;
import zw.co.tndangana.hrtp.repository.IctDataRepository;
import zw.co.tndangana.hrtp.service.IctDataService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/8/17.
 */
@Service
public class IctDataServiceImpl implements IctDataService {
    @Resource
    private IctDataRepository ictDataRepository;
    @Override
    public IctData save(IctData ictData) {
        return ictDataRepository.save(ictData);
    }

    @Override
    public List<IctData> findAll() {
        return (List<IctData>) ictDataRepository.findAll();
    }

    @Override
    public IctData findOne(Long id) {
        return ictDataRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
     ictDataRepository.delete(id);
    }

    @Override
    public void delete(IctData ictData) {

    }

    @Override
    public List<IctData> findIctDataByPatient(Patient patient) {
        return ictDataRepository.findIctDataByPatient(patient);
    }
}
