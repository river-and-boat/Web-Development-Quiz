package com.thoughtworks.rslist.service;

import com.thoughtworks.rslist.domain.ProductDomain;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.exception.exception_type.BadIndexParamException;
import com.thoughtworks.rslist.repository.ProductRepository;
import com.thoughtworks.rslist.tool.ConvertTool;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/14 13:53
 * @Description ***
 **/
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDomain> getProductList()
            throws BadIndexParamException {
        List<ProductEntity> productEntities = productRepository
                .findAll();
            if (productEntities != null) {
                return productEntities.stream()
                        .map(v -> ConvertTool.convertProductEntityToProductDomain(v))
                        .collect(Collectors.toList());
            }
        return null;
    }

    public ProductDomain addNewProduct(Optional<ProductDomain> productDomain)
            throws BadIndexParamException {
        if (productDomain.isPresent()) {
            ProductEntity productEntity = ConvertTool
                    .convertProductDomainToProductEntity(productDomain.get());
            ProductEntity savedEntity = productRepository.save(productEntity);
            if (savedEntity != null) {
                return ConvertTool.convertProductEntityToProductDomain(savedEntity);
            }
        }
        throw new BadIndexParamException("Can not add a product");
    }
}
