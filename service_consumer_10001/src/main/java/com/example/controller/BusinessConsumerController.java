package com.example.controller;

import com.example.pojo.Business;
import com.example.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class BusinessConsumerController {
    public static final String paymentSrv_URL = "http://service-provider";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/business/list")
    public ResultData listAll(){
        return restTemplate.getForObject(paymentSrv_URL+"/business/list",ResultData.class);
    }

    @GetMapping(value = "/consumer/business/{businessId}")
    public ResultData getBusinessById(@PathVariable("businessId") Integer businessId){
        return restTemplate.getForObject(paymentSrv_URL+"/business/"+businessId,ResultData.class,businessId);
    }

    @PostMapping(value = "/consumer/business")
    public ResultData addBusiness(@RequestBody Business business){
        return restTemplate.postForObject(paymentSrv_URL+"/business",business,ResultData.class);
    }

    @PutMapping(value = "/consumer/business")
    public ResultData updateBusiness(@RequestBody Business business){
        return restTemplate.exchange(paymentSrv_URL+"/business", HttpMethod.PUT,new HttpEntity<>(business),ResultData.class).getBody();
    }

    @DeleteMapping(value = "/consumer/business/{businessId}")
    public ResultData deleteBusiness(@PathVariable("businessId") Integer businessId){
        return restTemplate.exchange(paymentSrv_URL+"/business/"+businessId, HttpMethod.DELETE,null,ResultData.class).getBody();

    }
}
