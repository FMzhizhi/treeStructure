package com.zjj.dao;

import com.zjj.vo.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhijiaju
 * @version 1.0
 * @date 2020/7/29 0:03
 */
public interface ProductMapper {
    @Select("select * from product")
    List<Product> getAll();
}
