package com.example.mapper;

import com.example.pojo.Business;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BusinessMapper {
    @Select("select * from business ")
    List<Business> listAll();
    @Select("select * from business where businessId=#{businessId}")
    Business getByBusinessId(Integer businessId);

    @Insert("insert into business" +
            "(businessName, businessAddress, businessExplain, businessImg, orderTypeId, starPrice, deliveryPrice, remarks)" +
            "values " +
            "(#{businessName}, #{businessAddress}, #{businessExplain},#{businessImg},#{orderTypeId},#{starPrice},#{deliveryPrice},#{remarks})")
    void add(Business business);

    @Delete("delete from business where businessId = #{businessId}")
    void deleteBusiness(Integer businessId);

    void updateBusiness(Business business);
}
