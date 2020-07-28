package com.zjj.vo;

import java.util.List;

/**
 * @author zhijiaju
 * @version 1.0
 * @date 2020/7/29 7:09
 */
public class MenuVo {
    private Integer id;

    private String name;

    private String url;

    private Integer fatherId;

    private List<MenuVo>  childNode;

    @Override
    public String toString() {
        return "MenuVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", fatherId=" + fatherId +
                ", childNode=" + childNode +
                '}';
    }

    public MenuVo() {
    }

    public MenuVo(Integer id, String name, String url, Integer fatherId, List<MenuVo> childNode) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.fatherId = fatherId;
        this.childNode = childNode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public List<MenuVo> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<MenuVo> childNode) {
        this.childNode = childNode;
    }
}
