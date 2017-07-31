package zw.co.tndangana.hrtp.repository;

import org.springframework.data.repository.CrudRepository;
import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.domain.psycho.PsychoSocial;

import java.util.List;

/**
 * Created by tndangana on 7/13/17.
 */
public interface PsychoSocialRepository extends CrudRepository<PsychoSocial,Long> {

    List<PsychoSocial> findPsychoSocialsByPatient(Patient patient);
}
