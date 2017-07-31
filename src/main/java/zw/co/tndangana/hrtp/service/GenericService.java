package zw.co.tndangana.hrtp.service;

import java.util.List;
import java.util.Optional;

/**
 * Created by tndangana on 6/9/17.
 */
public interface GenericService <T> {

    public T save(T t);
    public List<T> findAll();
    public T findOne(Long id);
    void delete(Long id);
    void delete(T t);

}
