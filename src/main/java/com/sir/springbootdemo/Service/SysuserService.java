package com.sir.springbootdemo.Service;

import com.github.pagehelper.PageInfo;
import com.sir.springbootdemo.beans.pojo.Sysuser;
import java.util.ArrayList;

public interface SysuserService {

    boolean addSysuser(Sysuser sysuser);

    boolean deleteSysuser(int id);

    boolean updateSysuser(String lname,int id);

    ArrayList<Sysuser> GetList();

    /**
     * @param pageindex 页码
     * @param pagesize 分页容量
     * @return 过滤后的分页查询结果
     */
    ArrayList<Sysuser> SelAllByPage1(int pageindex,int pagesize);

    /**
     * @param pageindex 页码
     * @param pagesize 分页容量
     * @return 过滤后的分页查询结果
     */
    PageInfo<Sysuser> SelAllByPage2(int pageindex,int pagesize);
}
