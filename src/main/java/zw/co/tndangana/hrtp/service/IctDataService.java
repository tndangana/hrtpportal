package zw.co.tndangana.hrtp.service;

import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.domain.ict.IctData;

import java.util.List;

/**
 * Created by tndangana on 7/8/17.
 */
public interface IctDataService  extends GenericService<IctData>{
    public List<IctData> findIctDataByPatient(Patient patient);
}
