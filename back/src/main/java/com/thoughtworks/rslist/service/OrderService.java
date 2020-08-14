package com.thoughtworks.rslist.service;

import com.thoughtworks.rslist.domain.OrderDomain;
import com.thoughtworks.rslist.entity.OrderEntity;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.entity.ProductOrder;
import com.thoughtworks.rslist.exception.exception_type.BadIndexParamException;
import com.thoughtworks.rslist.repository.OrderRepository;
import com.thoughtworks.rslist.repository.ProductOrderRepository;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/14 17:31
 * @Description ***
 **/
@Service
public class OrderService {

    private static final Integer orderId = 1;
    private static final String orderName = "测试订单";

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final ProductOrderRepository productOrderRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository,
                        ProductOrderRepository productOrderRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.productOrderRepository = productOrderRepository;
    }

    public ProductOrder AddOrder(Integer productId) throws BadIndexParamException {
        Integer orderId = 0;
        if (orderRepository.count() > 0) {
            orderId = orderRepository.findAll().get(0).getId();
        } else {
            OrderEntity newOrder = OrderEntity.builder()
                    .id(orderId)
                    .createTime(LocalDateTime.now())
                    .modifyTime(LocalDateTime.now())
                    .name(orderName).build();
            orderRepository.save(newOrder);

            if (newOrder != null) {
                orderId = newOrder.getId();
            }
            throw new BadIndexParamException("error in create order");
        }

        // 查询商品
        Optional<ProductEntity> productEntity = productRepository.findById(productId);
        if (productEntity.isPresent()) {
            ProductOrder productOrder = ProductOrder.builder()
                    .orderId(orderId).productId(productEntity.get().getId()).build();
            ProductOrder savedOrder = productOrderRepository.save(productOrder);

            return savedOrder;
        }
        throw new BadIndexParamException("error in create order");
    }
}
