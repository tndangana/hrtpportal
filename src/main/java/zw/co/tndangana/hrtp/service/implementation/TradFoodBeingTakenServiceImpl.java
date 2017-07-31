package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.nutrition.TradFoodBeingTaken;
import zw.co.tndangana.hrtp.repository.TradFoodBeingTakenRepository;
import zw.co.tndangana.hrtp.service.TradFoodBeingTakenService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/15/17.
 */
@Service
public class TradFoodBeingTakenServiceImpl  implements TradFoodBeingTakenService{
    @Resource
    private TradFoodBeingTakenRepository tradFoodBeingTakenRepository;

    @Override
    public TradFoodBeingTaken save(TradFoodBeingTaken tradFoodBeingTaken) {
        return tradFoodBeingTakenRepository.save(tradFoodBeingTaken);
    }

    @Override
    public List<TradFoodBeingTaken> findAll() {
        return (List<TradFoodBeingTaken>) tradFoodBeingTakenRepository.findAll();
    }

    @Override
    public TradFoodBeingTaken findOne(Long id) {
        return tradFoodBeingTakenRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
  tradFoodBeingTakenRepository.findOne(id);
    }

    @Override
    public void delete(TradFoodBeingTaken tradFoodBeingTaken) {

    }
}
