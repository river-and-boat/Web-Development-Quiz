package com.thoughtworks.rslist.repository;

import com.thoughtworks.rslist.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/14 17:35
 * @Description ***
 **/
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findAll();
}
