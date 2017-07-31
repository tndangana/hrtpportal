package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.nutrition.Nutrition;
import zw.co.tndangana.hrtp.repository.NutritionRepository;
import zw.co.tndangana.hrtp.service.NutritionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/13/17.
 */
@Service
public class NutrionServiceImpl implements NutritionService {
    @Resource
    private NutritionRepository nutritionRepository;
    @Override
    public Nutrition save(Nutrition nutrition) {
        return nutritionRepository.save(nutrition);
    }

    @Override
    public List<Nutrition> findAll() {
        return (List<Nutrition>) nutritionRepository.findAll();
    }

    @Override
    public Nutrition findOne(Long id) {
        return nutritionRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
nutritionRepository.delete(id);
    }

    @Override
    public void delete(Nutrition nutrition) {

    }
}
