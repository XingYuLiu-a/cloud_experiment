package com.example.controller;

import com.example.pojo.Business;
import com.example.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business")
@RefreshScope  //开启动态刷新
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @GetMapping(value = "/list")
    public List<Business> listAll(){
        return businessService.listAll();
    }

    @GetMapping(value = "/{businessId}")
    public Business getBusinessById(@PathVariable("businessId") Integer businessId){
        return businessService.getById(businessId);
    }
    @PostMapping("")
    public void addBusiness(@RequestBody Business business){
        businessService.addBusiness(business);
    }
    @PutMapping("")
    public void updateBusiness(@RequestBody Business business){
        businessService.updateBusiness(business);
    }
    @DeleteMapping("/{businessId}")
    public void deleteBusiness(@PathVariable("businessId") Integer businessId){
        businessService.deleteBusiness(businessId);
    }

    @Value("${server.port}")
    private String port;
    @GetMapping(value = "/get/info")
    public String getInfoByConsul(){
        return "port"+port;
    }
}
