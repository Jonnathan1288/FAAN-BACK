package com.proyecto.faan.service.generic;

import com.proyecto.faan.repository.generic.GenericRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;



import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class GenericServiceImpl<T,ID extends Serializable> implements GenericService<T, ID> {

    public abstract GenericRepository<T, ID> getDao();

    @Override
    public List<T> findByAll() {
        List<T> list = new ArrayList<>();
        getDao().findAll().forEach(obj -> list.add(obj));
        return list;
    }

    @Override
    public Page<T> findByAll(Pageable pageable) {
        Page<T> list = getDao().findAll(pageable);
        return list;
    }

    @Override
    public Page<T> findByAll(Pageable pageable, String columnName, String value) {
        Specification<T> specification = createSpecification(columnName, value);
        return getDao().findAll(specification, pageable);
    }

    private Specification<T> createSpecification(String columnName, String value) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (columnName != null && value != null) {
                    return criteriaBuilder.like(criteriaBuilder.lower(root.get(columnName)), "%" + value.toLowerCase() + "%");
                } else {
                    // Si no se proporciona un atributo y un valor, retornamos un predicado verdadero
                    return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
                }
            }
        };
    }

    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        Optional<T> optionaE = getDao().findById(id);
        if(optionaE.isPresent()){
            T entityUpdate = optionaE.get();
            entityUpdate = getDao().save(entity);
            return getDao().save(entityUpdate);
        }
        return null;
    }

    @Override
    public T findById(ID id) {
        Optional<T> obj = getDao().findById(id);
        if(obj.isPresent()){
            return obj.get();
        }
        return null;
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

}
