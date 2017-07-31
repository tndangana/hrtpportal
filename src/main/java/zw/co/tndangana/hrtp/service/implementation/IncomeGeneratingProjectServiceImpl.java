package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.psycho.IncomeGeneratingProject;
import zw.co.tndangana.hrtp.repository.IncomeGeneratingProjectRepository;
import zw.co.tndangana.hrtp.service.IncomeGeneratingProjectService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 7/13/17.
 */
@Service
public class IncomeGeneratingProjectServiceImpl implements IncomeGeneratingProjectService {
    @Resource
    private IncomeGeneratingProjectRepository incomeGeneratingProjectRepository;
    @Override
    public IncomeGeneratingProject save(IncomeGeneratingProject incomeGeneratingProject) {
        return incomeGeneratingProjectRepository.save(incomeGeneratingProject);
    }

    @Override
    public List<IncomeGeneratingProject> findAll() {
        return (List<IncomeGeneratingProject>) incomeGeneratingProjectRepository.findAll();
    }

    @Override
    public IncomeGeneratingProject findOne(Long id) {
        return incomeGeneratingProjectRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
   incomeGeneratingProjectRepository.delete(id);
    }

    @Override
    public void delete(IncomeGeneratingProject incomeGeneratingProject) {

    }
}
