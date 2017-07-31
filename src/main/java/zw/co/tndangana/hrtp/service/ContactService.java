package zw.co.tndangana.hrtp.service;

import zw.co.tndangana.hrtp.domain.Contact;
import zw.co.tndangana.hrtp.domain.Patient;

import java.util.List;

/**
 * Created by tndangana on 7/6/17.
 */
public interface ContactService  extends GenericService<Contact>{

    public List<Contact> findContactsByPatient(Patient patient);
}
