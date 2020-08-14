package com.thoughtworks.rslist.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/14 17:28
 * @Description ***
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDomain {
    private Integer id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
}
