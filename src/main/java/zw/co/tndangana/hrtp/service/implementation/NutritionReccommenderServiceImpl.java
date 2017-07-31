package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.nutrition.NutritionReccommender;
import zw.co.tndangana.hrtp.repository.NutritionReccommenderRepository;
import zw.co.tndangana.hrtp.service.NutritionReccommenderService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/15/17.
 */
@Service
public class NutritionReccommenderServiceImpl implements NutritionReccommenderService {
    @Resource
    private NutritionReccommenderRepository nutritionReccommenderRepository;

    @Override
    public NutritionReccommender save(NutritionReccommender nutritionReccommender) {
        return nutritionReccommenderRepository.save(nutritionReccommender);
    }

    @Override
    public List<NutritionReccommender> findAll() {
        return (List<NutritionReccommender>) nutritionReccommenderRepository.findAll();
    }

    @Override
    public NutritionReccommender findOne(Long id) {
        return nutritionReccommenderRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
  nutritionReccommenderRepository.delete(id);
    }

    @Override
    public void delete(NutritionReccommender nutritionReccommender) {

    }
}
