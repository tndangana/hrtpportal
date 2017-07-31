package zw.co.tndangana.hrtp.repository;

import org.springframework.data.repository.CrudRepository;
import zw.co.tndangana.hrtp.domain.Patient;

/**
 * Created by tndangana on 6/22/17.
 */
public interface PatientRepository extends CrudRepository<Patient,Long> {


}
