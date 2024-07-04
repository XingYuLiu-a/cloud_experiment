package com.example.apis;

import com.example.pojo.Business;
import com.example.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "service-provider")
public interface BusinessApis {
    @GetMapping(value = "/business/list")
    List<Business> listAll();

    @GetMapping(value = "/business/{businessId}")
    Business getBusinessById(@PathVariable("businessId") Integer businessId);

    @PostMapping("/business")
    void addBusiness(@RequestBody Business business);

    @PutMapping("/business")
    void updateBusiness(@RequestBody Business business);

    @DeleteMapping("/business/{businessId}")
    void deleteBusiness(@PathVariable("businessId") Integer businessId);

    @GetMapping(value = "/business/get/info")
    String myPort();
}
