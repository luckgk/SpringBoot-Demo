package com.youhua.production.bean;


public class Mac {

    private Integer id;
    private String mac;

    private String operator;

    private String province;

    public Mac(Integer id,String mac,String operator,String province) {
        this.id = id;
        this.mac = mac;
        this.operator = operator;
        this.province = province;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
