package com.sir.springbootdemo.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sir.springbootdemo.Dao.SysuserDao;
import com.sir.springbootdemo.beans.pojo.Sysuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class SysuserServiceImpl implements SysuserService {
    @Autowired
    private SysuserDao sysuserDao;

    @Override
    public boolean addSysuser(Sysuser sysuser) {

        return sysuserDao.addSysuser(sysuser)>0?true:false;
    }

    @Override
    public boolean deleteSysuser(int id) {
        return sysuserDao.deleteSysuser(id)>0?true:false;

    }

    @Override
    public boolean updateSysuser(String lname,int id) {
        return sysuserDao.updateSysuser(lname,id)>0?true:false;
    }

    @Override
    public ArrayList<Sysuser> GetList() {
        return sysuserDao.GetList();
    }

    @Override
    public ArrayList<Sysuser> SelAllByPage1(int pageindex, int pagesize) {
        //设置分页参数,第一个表示页码,第二个表示页码容量
        PageHelper.startPage(pageindex,pagesize);
        //调dao层方法,但是底层已经过滤
        ArrayList<Sysuser> data=sysuserDao.GetList();
        return data;
    }

    @Override
    public PageInfo<Sysuser> SelAllByPage2(int pageindex, int pagesize) {
        //设置分页参数,第一个表示页码,第二个表示页码容量
        PageHelper.startPage(pageindex,pagesize);
        //调用查询
        PageInfo<Sysuser> pageInfo=new PageInfo<Sysuser>(sysuserDao.GetList());
        //得到查询数据
        pageInfo.getList();

        return pageInfo;
    }
}
