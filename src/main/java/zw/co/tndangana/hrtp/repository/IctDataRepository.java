package zw.co.tndangana.hrtp.repository;

import org.springframework.data.repository.CrudRepository;
import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.domain.ict.IctData;

import java.util.List;

/**
 * Created by tndangana on 7/8/17.
 */
public interface IctDataRepository extends CrudRepository<IctData,Long> {

    public List<IctData> findIctDataByPatient(Patient patient);
}
