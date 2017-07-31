package zw.co.tndangana.hrtp.repository;

import org.springframework.data.repository.CrudRepository;
import zw.co.tndangana.hrtp.domain.psycho.SurplusProduce;
import zw.co.tndangana.hrtp.domain.psycho.SurplusProduceUsage;

/**
 * Created by tndangana on 7/13/17.
 */
public interface SurplusProduceUsageRepository extends CrudRepository<SurplusProduceUsage,Long> {
}
