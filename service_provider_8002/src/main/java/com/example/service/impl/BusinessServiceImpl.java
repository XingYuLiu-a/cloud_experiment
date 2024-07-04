package com.example.service.impl;

import com.example.mapper.BusinessMapper;
import com.example.pojo.Business;
import com.example.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public List<Business> listAll() {
        return businessMapper.listAll();
    }

    @Override
    public Business getById(Integer businessId) {
        return businessMapper.getByBusinessId(businessId);
    }

    @Override
    public void addBusiness(Business business) {
        businessMapper.add(business);
    }

    @Override
    public void updateBusiness(Business business) {
        businessMapper.updateBusiness(business);
    }

    @Override
    public void deleteBusiness(Integer businessId) {
        businessMapper.deleteBusiness(businessId);
    }
}
