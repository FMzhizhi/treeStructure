package com.zjj.vo;


import lombok.Data;

import java.util.List;

/**
 * @author zhijiaju
 * @version 1.0
 * @date 2020/7/28 22:34
 */
@Data
public class ProductVo {

    private Integer id;

    private String cName;

    private Integer parentId;

    private List<ProductVo> childNode;

    public ProductVo(Integer id, String name, Integer parentId, List<ProductVo> childNode) {
        this.id = id;
        this.cName = name;
        this.parentId = parentId;
        this.childNode = childNode;
    }
}
