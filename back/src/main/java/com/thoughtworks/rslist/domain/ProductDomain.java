package com.thoughtworks.rslist.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/14 14:05
 * @Description ***
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDomain {
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private String unit;

    @NotNull
    private String avator;
}
