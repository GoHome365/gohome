package com.gohome.data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * created  by jun
 * 2018-01-20 上午 11:56
 **/

/**
 * 社区类
 *
 *
 */
@Entity
@Table(
        name = "community"
)
public class Community   implements Serializable{

    private static final long serialVersionUID = 1L;


    /**
     * 小区ID
     */
    private  String id;

    /**
     * 小区名
     */
    private String name;


    /**
     * 小区所在城市
     */
    private  String  city;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Community{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}