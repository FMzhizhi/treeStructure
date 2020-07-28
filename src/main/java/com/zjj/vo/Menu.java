package com.zjj.vo;

/**
 * @author zhijiaju
 * @version 1.0
 * @date 2020/7/29 7:08
 */
public class Menu {
    private Integer id;

    private String name;

    private String url;

    private Integer fatherId;


    public Menu(Integer id, String name, String url, Integer fatherId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.fatherId = fatherId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", fatherId=" + fatherId +
                '}';
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
}
