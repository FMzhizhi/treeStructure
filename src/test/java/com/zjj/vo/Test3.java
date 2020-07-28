package com.zjj.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.*;

/**
 * @author zhijiaju
 * @version 1.0
 * @date 2020/7/29 7:10
 */
public class Test3 {
    public static void main(String[] args) {

        List<Menu> sqlData=new ArrayList<>();
        sqlData.add(new Menu(1,"1","xxx",-1));
        sqlData.add(new Menu(2,"1-1","xxx",1));
        sqlData.add(new Menu(3,"1-1-1","xxx",2));
        sqlData.add(new Menu(4,"2","xxx",-1));
        sqlData.add(new Menu(5,"2-1","xxx",4));
        sqlData.add(new Menu(6,"1-2","xxx",1));
        treeStructure(sqlData);

    }

    private static void treeStructure(List<Menu> sqlData) {
        //存储非根节点
        Map<Integer,List<MenuVo>> tempMap=new HashMap<>();

        //存储最终的结果
        List<MenuVo> resultList=new ArrayList<>();
        //遍历数据库查询数据集合,如果父id==-1 代表根节点 添加到最终结果中,否则为非根节点添加到临时节点
        for (Menu menu : sqlData) {
            MenuVo menuVo=new MenuVo(menu.getId(),menu.getName(),menu.getUrl(),menu.getFatherId(),new ArrayList<>());
            if(menu.getFatherId()==-1){
                resultList.add(menuVo);
            }else{
                if (tempMap.containsKey(menu.getFatherId())) {
                    tempMap.get(menu.getFatherId()).add(menuVo);
                }else{
                    List<MenuVo> list=new ArrayList<>();
                    list.add(menuVo);
                    tempMap.put(menu.getFatherId(),list);
                }
            }
        }
        //遍历所有的根节点,通过根节点和非根节点集合,找到这个根节点的所有子节点
        for (MenuVo menuVo : resultList) {
            getChildNode(tempMap, Arrays.asList(menuVo));
        }

        resultList.forEach(System.out::println);
    }


    public static  void getChildNode(Map<Integer,List<MenuVo>> tempMap,List<MenuVo> fatherNodeList  ){
        for (MenuVo menuVo : fatherNodeList) {
            if (tempMap.containsKey(menuVo.getId())) {
                menuVo.getChildNode().addAll(tempMap.get(menuVo.getId()));
                getChildNode(tempMap,tempMap.get(menuVo.getId()));
            }
        }
    }

}
