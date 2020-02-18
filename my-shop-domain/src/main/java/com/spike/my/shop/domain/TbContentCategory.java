package com.spike.my.shop.domain;

import com.spike.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class TbContentCategory extends BaseEntity implements Serializable {
    private Long parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Boolean isParent;
}
