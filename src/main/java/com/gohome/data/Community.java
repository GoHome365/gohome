package com.gohome.data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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



    //名称、价格、小区、租房方式（整租或者合租）、户型（几室几厅）、介绍、更新时间

    /**
     * ID
     */
    private  String id;


    /**
     * 小区
     */
    private String name;

    /*
    *价格
     */

    private BigDecimal price;
    /**
     * 地址
     */

    private String adress;


    /**
     * 租房方式（整租或者合租）
     */
    private String  leaseType;

    /**
     * 户型
     */

    private String houseType;

    /**
     * 介绍
     */

    private  String remark;

    /**
     * 更新时间
     */

    private Date updateDate;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(String leaseType) {
        this.leaseType = leaseType;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
                ", price=" + price +
                ", adress='" + adress + '\'' +
                ", leaseType='" + leaseType + '\'' +
                ", houseType='" + houseType + '\'' +
                ", remark='" + remark + '\'' +
                ", updateDate=" + updateDate +
                ", city='" + city + '\'' +
                '}';
    }
}
