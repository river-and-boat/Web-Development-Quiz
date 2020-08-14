package com.thoughtworks.rslist.tool;

import com.thoughtworks.rslist.domain.ProductDomain;
import com.thoughtworks.rslist.entity.ProductEntity;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/6 12:36
 * @Description ***
 **/
public class ConvertTool {

    public static ProductDomain convertProductEntityToProductDomain(ProductEntity productEntity) {
        return ProductDomain.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .avator(productEntity.getAvator())
                .unit(productEntity.getUnit()).build();
    }

    public static ProductEntity convertProductDomainToProductEntity(ProductDomain productDomain) {
        return ProductEntity.builder()
                .id(productDomain.getId())
                .name(productDomain.getName())
                .price(productDomain.getPrice())
                .avator(productDomain.getAvator())
                .unit(productDomain.getUnit()).build();
    }
}
