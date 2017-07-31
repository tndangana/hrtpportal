package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.psycho.AgricPractise;
import zw.co.tndangana.hrtp.repository.AgricPractiseRepsoitory;
import zw.co.tndangana.hrtp.service.AgricPractiseService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/13/17.
 */
@Service
public class AgricPractiseServiceImpl implements AgricPractiseService {
    @Resource
    private AgricPractiseRepsoitory agricPractiseRepsoitory;
    @Override
    public AgricPractise save(AgricPractise agricPractise) {
        return agricPractiseRepsoitory.save(agricPractise);
    }

    @Override
    public List<AgricPractise> findAll() {
        return (List<AgricPractise>) agricPractiseRepsoitory.findAll();
    }

    @Override
    public AgricPractise findOne(Long id) {
        return agricPractiseRepsoitory.findOne(id);
    }

    @Override
    public void delete(Long id) {
     agricPractiseRepsoitory.delete(id);
    }

    @Override
    public void delete(AgricPractise agricPractise) {

    }
}
