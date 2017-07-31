package zw.co.tndangana.hrtp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import zw.co.tndangana.hrtp.domain.Address;
import zw.co.tndangana.hrtp.domain.Patient;

import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */
public interface AddressRepository extends CrudRepository<Address,Long>{

    public List<Address> findAddressesByPatient(Patient patient);

    public List<Address> findAddressesByPatientId(Long patinetId);


}
