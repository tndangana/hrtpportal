package zw.co.tndangana.hrtp.service.implementation;

import org.springframework.stereotype.Service;
import zw.co.tndangana.hrtp.domain.Accommodation;
import zw.co.tndangana.hrtp.domain.Accommodation;
import zw.co.tndangana.hrtp.repository.AccommodationRepository;
import zw.co.tndangana.hrtp.repository.AccommodationRepository;
import zw.co.tndangana.hrtp.service.AccommodationService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tndangana on 6/22/17.
 */
@Service
public class AccommodationServiceImpl implements AccommodationService {
    @Resource
    private AccommodationRepository accommodationRepository;
    @Override
    public Accommodation save(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @Override
    public List<Accommodation> findAll() {
        return (List<Accommodation>) accommodationRepository.findAll();
    }

    @Override
    public Accommodation findOne(Long id) {
        return accommodationRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        accommodationRepository.delete(id);
    }

    @Override
    public void delete(Accommodation accommodation) {
        accommodationRepository.delete(accommodation);
    }

    @Override
    public Long count() {
        return accommodationRepository.count();
    }
}
