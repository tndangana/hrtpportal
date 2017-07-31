package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.Address;
import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.repository.AddressRepository;
import zw.co.tndangana.hrtp.service.AddressService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return (List<Address>)addressRepository.findAll();
    }

    @Override
    public Address findOne(Long id) {
        return addressRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
   addressRepository.delete(id);
    }

    @Override
    public void delete(Address address) {
    }
    @Override
    public List<Address> findAddressesByPatient(Patient patient) {
        return addressRepository.findAddressesByPatient(patient);
    }
}
