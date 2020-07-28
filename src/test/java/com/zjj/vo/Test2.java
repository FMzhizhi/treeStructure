package com.zjj.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zjj.dao.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @author zhijiaju
 * @version 1.0
 * @date 2020/7/29 6:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2 {
    @Autowired
    ProductMapper productMapper;

    @Test
    public void test1(){
        List<Product> list = productMapper.getAll();
        System.out.println(list);
        treeStructure(list);

    }

    private static void treeStructure(List<Product> sqlData) {
        //存储非根节点
        Map<Integer,List<ProductVo>> tempMap=new HashMap<>();

        //存储最终的结果
        List<ProductVo> resultList=new ArrayList<>();
        //遍历数据库查询数据集合,如果父id==-1 代表根节点 添加到最终结果中,否则为非根节点添加到临时节点
        for (Product product : sqlData) {
            ProductVo productVo=new ProductVo(product.getId(),product.getName(),product.getParentId(),new ArrayList<>());
            if(product.getParentId()==0){
                resultList.add(productVo);
            }else{
                if (tempMap.containsKey(product.getParentId())) {
                    tempMap.get(product.getParentId()).add(productVo);
                }else{
                    List<ProductVo> list=new ArrayList<>();
                    list.add(productVo);
                    tempMap.put(product.getParentId(),list);
                }
            }
        }
        //遍历所有的根节点,通过根节点和非根节点集合,找到这个根节点的所有子节点
        for (ProductVo productVoVo : resultList) {
            getChildNode(tempMap, Arrays.asList(productVoVo));
        }

        JSONArray parse = (JSONArray) JSONArray.parse(JSON.toJSONString(resultList));
        System.out.println(parse.toJSONString());
        resultList.forEach(System.out::println);
    }


    public static  void getChildNode(Map<Integer,List<ProductVo>> tempMap,List<ProductVo> fatherNodeList  ){
        for (ProductVo productVoVo : fatherNodeList) {
            if (tempMap.containsKey(productVoVo.getId())) {
                productVoVo.getChildNode().addAll(tempMap.get(productVoVo.getId()));
                getChildNode(tempMap,tempMap.get(productVoVo.getId()));
            }
        }
    }


}
