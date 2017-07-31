package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.ict.ServiceProvider;
import zw.co.tndangana.hrtp.repository.ServiceProviderRepository;
import zw.co.tndangana.hrtp.service.ServiceProviderService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/11/17.
 */
@Service
public class ServiceProviderServiceImpl implements ServiceProviderService{
    @Resource
    private ServiceProviderRepository serviceProviderRepository;
    @Override
    public ServiceProvider save(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    @Override
    public List<ServiceProvider> findAll() {
        return ( List<ServiceProvider>) serviceProviderRepository.findAll();
    }

    @Override
    public ServiceProvider findOne(Long id) {
        return serviceProviderRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
  serviceProviderRepository.delete(id);
    }

    @Override
    public void delete(ServiceProvider serviceProvider) {

    }
}
