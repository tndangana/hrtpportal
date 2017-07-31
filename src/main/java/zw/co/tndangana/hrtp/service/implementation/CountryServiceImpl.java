package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.Country;
import zw.co.tndangana.hrtp.repository.CountryRepository;
import zw.co.tndangana.hrtp.service.CountryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/6/17.
 */
@Service
public class CountryServiceImpl implements CountryService {
    @Resource
    private CountryRepository countryRepository;
    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> findAll() {
        return (List<Country>) countryRepository.findAll();
    }

    @Override
    public Country findOne(Long id) {
        return countryRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
     countryRepository.delete(id);
    }

    @Override
    public void delete(Country country) {

    }
}
