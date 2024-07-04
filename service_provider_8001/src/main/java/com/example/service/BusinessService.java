package com.example.service;

import com.example.pojo.Business;

import java.util.List;

public interface BusinessService {
    List<Business> listAll();
    Business getById(Integer businessId);
    void addBusiness(Business business);
    void updateBusiness(Business business);
    void deleteBusiness(Integer businessId);
 }
