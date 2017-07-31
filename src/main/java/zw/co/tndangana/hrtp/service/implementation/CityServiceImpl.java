package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.City;
import zw.co.tndangana.hrtp.repository.CityReposity;
import zw.co.tndangana.hrtp.service.CityService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/6/17.
 */
@Service
public class CityServiceImpl implements CityService {
    @Resource
    private CityReposity cityReposity;
    @Override
    public City save(City city) {
        return cityReposity.save(city);
    }

    @Override
    public List<City> findAll() {
        return (List<City>) cityReposity.findAll();
    }

    @Override
    public City findOne(Long id) {
        return cityReposity.findOne(id);
    }

    @Override
    public void delete(Long id) {
 cityReposity.delete(id);
    }

    @Override
    public void delete(City city) {

    }
}
