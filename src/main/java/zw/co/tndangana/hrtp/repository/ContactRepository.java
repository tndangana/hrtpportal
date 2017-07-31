package zw.co.tndangana.hrtp.repository;

import org.springframework.data.repository.CrudRepository;
import zw.co.tndangana.hrtp.domain.Contact;
import zw.co.tndangana.hrtp.domain.Patient;

import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */
public interface ContactRepository extends CrudRepository<Contact,Long> {

    public List<Contact> findContactsByPatient(Patient patient);
}
