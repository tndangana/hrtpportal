package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.repository.PatientRepository;
import zw.co.tndangana.hrtp.service.PatientService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 6/22/17.
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Resource
    private PatientRepository patientRepository;
    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return (List<Patient>) patientRepository.findAll();
    }

    @Override
    public Patient findOne(Long id) {
        return patientRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
patientRepository.delete(id);
    }

    @Override
    public void delete(Patient patient) {

    }
}
