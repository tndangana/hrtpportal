package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.Contact;
import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.repository.ContactRepository;
import zw.co.tndangana.hrtp.service.ContactService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/6/17.
 */
@Service
public class ContactServiceImpl implements ContactService{
    @Resource
    private ContactRepository contactRepository;
    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> findAll() {
        return (List<Contact>) contactRepository.findAll();
    }

    @Override
    public Contact findOne(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
       contactRepository.delete(id);
    }

    @Override
    public void delete(Contact contact) {

    }

    @Override
    public List<Contact> findContactsByPatient(Patient patient) {
        return contactRepository.findContactsByPatient(patient);
    }
}
