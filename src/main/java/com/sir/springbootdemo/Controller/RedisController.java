package com.sir.springbootdemo.Controller;

import com.sir.springbootdemo.ResultVo.Result;
import com.sir.springbootdemo.constants.Constants;
import com.sir.springbootdemo.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test",produces = "text/html;charset=utf-8")
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SMSUtils smsUtils;

    /**
     *
     * @param phone 传入电话号码
     * @return 发送验证码结果
     */
    @PostMapping("/sms")
    public String sendSMS(String phone){
        if (phone==null){
            return JsonUtils.toJsonString(ResultUtils.returnFail("手机号码不能为空!"));
        }
        //产生redis的key值
        String key="20210308"+ Constants.Connnector.COLON+phone;
        //产生对应的value值
        String value=redisUtils.getValue(key);
        if (value!=null){
            return JsonUtils.toJsonString(ResultUtils.returnFail("上一个验证码未到期!"));
        }
        //产生随机码
        String randomValue= MathUtils.random();
        //将产生的key和value放入radis,有效时间为120秒
        redisUtils.putValue(key,randomValue,Constants.Duration.MINUTE_INT*2);
        //发送短信
        boolean note= smsUtils.sendTencentSMS(phone,randomValue,"2");

        if (note){
            return JsonUtils.toJsonString(ResultUtils.returnSuccess("验证码发送成功!"));
        }
        return JsonUtils.toJsonString(ResultUtils.returnFail());
    }

    @PostMapping("/add1")
    public Result do1(String k,String v){
        String key="test:20210308"+k;
        redisUtils.putValue(key,v);
        return ResultUtils.returnSuccess("新增成功1!");
    }

    @PostMapping("/add2")
    public Result<String> do2(String k,String v){
        redisUtils.putValue(k,v, Constants.Duration.MINUTE_INT*3);
        return ResultUtils.returnSuccess("新增成功2!");
    }

    @DeleteMapping("/del")
    public Result do3(String k){
        redisUtils.delete(k);
        return ResultUtils.returnSuccess("删除成功!");
    }

    /**
     *
     * @param要修改值的key的时间
     * @return
     */
    @PutMapping("/update")
    public Result do4(String k){
        redisUtils.expire(k,Constants.Duration.HALF_HOUR_INT);
        return ResultUtils.returnSuccess("修改成功!");
    }

    @GetMapping("/get")
    public Result do5(String k){
        return ResultUtils.returnSuccess(redisUtils.get(k).toString());
    }

}
