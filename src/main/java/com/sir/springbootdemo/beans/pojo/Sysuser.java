package com.sir.springbootdemo.beans.pojo;

import lombok.Data;

@Data
public class Sysuser {
    private int id;
    private String lname;
    private String lpass;
    private String rname;
    private String birthday;
    private String phone;
    private String address;
}
