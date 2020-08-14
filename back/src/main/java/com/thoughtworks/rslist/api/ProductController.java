package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.domain.ProductDomain;
import com.thoughtworks.rslist.exception.exception_type.BadIndexParamException;
import com.thoughtworks.rslist.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/14 14:12
 * @Description ***
 **/
@RestController
@Api(tags = "产品列表")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    @ApiOperation(value = "获取所有产品", notes = "分页获取")
    public ResponseEntity<List<ProductDomain>> getAllProducts()
            throws BadIndexParamException {
        List<ProductDomain> productList = productService.getProductList();
        return ResponseEntity.ok(productList);
    }

    @PostMapping("/product")
    @ApiOperation(value = "添加新产品")
    public ResponseEntity<List<ProductDomain>> addNewProduct(@RequestBody @Valid Optional<ProductDomain> productDomain,
                                                             BindingResult bindingResult)
            throws BadIndexParamException {
        if (bindingResult.hasErrors()) {
            throw new BadIndexParamException("illegal filed");
        }
        ProductDomain savedResult = productService.addNewProduct(productDomain);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("create", savedResult.getId().toString())
                .body(null);
    }
}
