package com.sir.springbootdemo.Controller;

import com.github.pagehelper.PageInfo;
import com.sir.springbootdemo.ResultVo.Result;
import com.sir.springbootdemo.Service.SysuserService;
import com.sir.springbootdemo.beans.pojo.Sysuser;
import com.sir.springbootdemo.config.FileConfig1;
import com.sir.springbootdemo.config.FileConfig2;
import com.sir.springbootdemo.config.TestConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
@Api(tags = "用户模块")
public class SysuserController {
    @Autowired
    private FileConfig1 fileconfig1;
    @Autowired
    private FileConfig2 fileconfig2;
    @Autowired
    private TestConfig testConfig;
    @Autowired
    private SysuserService sysuserService;

    @GetMapping("/Testconfig")
    @ApiOperation(value = "测试方法1")
    public Result do1() {
        return new Result("不猜", "你猜", testConfig);
    }

    @GetMapping("/upload1")
    @ApiOperation(value = "测试方法2")
    public Result do2() {
        return new Result("路径", "配置1", fileconfig1);
    }

    @GetMapping("/upload2")
    @ApiOperation(value = "测试方法3")
    public Result do3() {
        return new Result("路径", "配置2", fileconfig2);
    }

    @GetMapping("/insert")
    @ApiOperation(value = "新增方法")
    public Result do4(Sysuser sysuser) {
        if (sysuserService.addSysuser(sysuser)) {
            return new Result("新增成功!");
        }else{
            return new Result("新增失败!");
        }
    }


    @PostMapping("/delete")
    @ApiOperation(value = "删除方法")
    public Result do5(int id){
        if (sysuserService.deleteSysuser(id)) {
            return new Result("删除成功!");
        }else{
            return new Result("删除失败!");
        }
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改方法")
    public Result do6(String lname,int id){
        if (sysuserService.updateSysuser(lname,id)) {
            return new Result("修改用户名成功!");
        }else{
            return new Result("修改用户名失败!");
        }
    }

    @GetMapping("/selete")
    @ApiOperation(value = "查询方法")
    public ArrayList<Sysuser> do7(){
        return sysuserService.GetList();
    }

    @GetMapping("/getall1")
    @ApiOperation(value = "分页查询1")
    public ArrayList<Sysuser> do8(int pageindex,int pagesize){
        return sysuserService.SelAllByPage1(pageindex,pagesize);
    }

    @GetMapping("/getall2")
    @ApiOperation(value = "分页查询2")
    public PageInfo<Sysuser>do9(int pageindex, int pagesize){
        return sysuserService.SelAllByPage2(pageindex,pagesize);
    }
}
