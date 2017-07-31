package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.Title;
import zw.co.tndangana.hrtp.repository.TitleRepository;
import zw.co.tndangana.hrtp.service.TitleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 6/21/17.
 */
@Service
public class TitleServiceImpl implements TitleService {
    @Resource
    private TitleRepository titleRepository;
    @Override
    public Title save(Title title) {
        return titleRepository.save(title);
    }

    @Override
    public List<Title> findAll() {
        return (List<Title>) titleRepository.findAll();
    }

    @Override
    public Title findOne(Long id) {
        return titleRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
     titleRepository.delete(id);
    }

    @Override
    public void delete(Title title) {

    }
}
