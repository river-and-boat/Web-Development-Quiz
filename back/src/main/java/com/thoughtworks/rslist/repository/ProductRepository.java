package com.thoughtworks.rslist.repository;

import com.thoughtworks.rslist.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findAll();
}
