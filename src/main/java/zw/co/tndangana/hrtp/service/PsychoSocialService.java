package zw.co.tndangana.hrtp.service;

import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.domain.psycho.PsychoSocial;

import java.util.List;

/**
 * Created by tndangana on 7/13/17.
 */
public interface PsychoSocialService extends GenericService<PsychoSocial> {
    List<PsychoSocial> findPsychoSocialsByPatient(Patient patient);

}
