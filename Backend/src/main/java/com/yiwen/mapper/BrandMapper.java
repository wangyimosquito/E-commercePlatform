package com.yiwen.mapper;
import com.yiwen.pojo.Brand;
import com.yiwen.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(int id);
    /*
    * three ways to get params
    * */
    List<Brand> selectByCondition(@Param("status")int status,
                                  @Param("companyName")String companyName,
                                  @Param("brandName")String BrandName);

    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);
}
