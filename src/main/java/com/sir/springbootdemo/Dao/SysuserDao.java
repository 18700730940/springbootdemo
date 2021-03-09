package com.sir.springbootdemo.Dao;

import com.sir.springbootdemo.beans.pojo.Sysuser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("SysuserDao")
public interface SysuserDao {

    @Insert("INSERT INTO SYSUSER(LNAME,LPASS,RNAME,BIRTHDAY,PHONE,ADDRESS)\n" +
            "        VALUES(#{lname},#{lpass},#{rname},#{birthday},#{phone},#{address})")
    int addSysuser(Sysuser sysuser);

    @Delete("delete from sysuser where id=#{id}")
    int deleteSysuser(int id);

    @Update("UPDATE sysuser SET `lname`=#{lname} WHERE id=#{id}")
    int updateSysuser(String lname,int id);

    @Select("select * from Sysuser")
    ArrayList<Sysuser> GetList();

}
