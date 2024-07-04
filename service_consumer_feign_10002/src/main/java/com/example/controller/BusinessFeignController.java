package com.example.controller;

import com.example.apis.BusinessApis;
import com.example.pojo.Business;
import com.example.resp.ResultData;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/feign/business")
public class BusinessFeignController {
    @Resource
    private BusinessApis businessApis;

    @GetMapping("/list")
//    @CircuitBreaker(name = "service-provider",fallbackMethod = "myFallbackMethod")
    public ResultData listAll(){
        List<Business> businessList = businessApis.listAll();
        return ResultData.success(businessList);
    }
//    public String myFallbackMethod(Throwable t){
//        return "myFallbackMethod,系统繁忙，请稍后再试";
//    }

    @GetMapping("/{businessId}")
//    @Bulkhead(name = "service-provider",fallbackMethod = "myBulkheadPoolFallback",type = Bulkhead.Type.THREADPOOL)
    public ResultData getBusinessById(@PathVariable("businessId") Integer businessId){
        Business business = businessApis.getBusinessById(businessId);
        return ResultData.success(business);
    }

//    public CompletableFuture<String> myBulkheadPoolFallback(Integer id, Throwable t){
//        return CompletableFuture.supplyAsync(()->"myBulkheadPoolFallback,隔板超出最大数量限制，系统繁忙，请稍后再试");
//    }


    @PostMapping("")
//    @Bulkhead(name = "service-provider",fallbackMethod = "myRateLimitFallback")
    public ResultData addBusiness(@RequestBody Business business){
        businessApis.addBusiness(business);
        return ResultData.success(null);
    }
//    public String myRateLimitFallback(Throwable t){
//        System.out.println("您被限流了，禁止访问");
//        return "您被限流了，禁止访问";
//    }

    @PutMapping("")
    public ResultData updateBusiness(@RequestBody Business business){
        businessApis.updateBusiness(business);
        return ResultData.success(null);
    }

    @DeleteMapping("/businessId")
    public ResultData deleteBusiness(@PathVariable("businessId") Integer businessId){
        businessApis.deleteBusiness(businessId);
        return ResultData.success(null);
    }

    @GetMapping("/myPort")
    public String myPort(){
        return businessApis.myPort();
    }
}
