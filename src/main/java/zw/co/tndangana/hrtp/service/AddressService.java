package zw.co.tndangana.hrtp.service;

import zw.co.tndangana.hrtp.domain.Address;
import zw.co.tndangana.hrtp.domain.Patient;

import java.util.List;

/**
 * Created by tndangana on 7/5/17.
 */
public interface AddressService extends GenericService<Address> {

    public List<Address> findAddressesByPatient(Patient patient);
}
