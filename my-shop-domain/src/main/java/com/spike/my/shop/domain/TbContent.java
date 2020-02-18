package com.spike.my.shop.domain;

import com.spike.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class TbContent extends BaseEntity implements Serializable {
    private Long categoryId;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;
}
