package zw.co.tndangana.hrtp.repository;

import org.springframework.data.repository.CrudRepository;
import zw.co.tndangana.hrtp.domain.Patient;
import zw.co.tndangana.hrtp.domain.nutrition.Nutrition;

import java.util.List;

/**
 * Created by tndangana on 7/13/17.
 */
public interface NutritionRepository extends CrudRepository<Nutrition,Long> {

    List<Nutrition> findNutritionsByPatient(Patient patient);
}
