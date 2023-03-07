package com.yiwen.mapper;
import com.yiwen.pojo.Brand;
import com.yiwen.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /*
    * return all brands
    * */
    List<Brand> selectAll();

    /*
    * return with certain ID
    * */
    Brand selectById(int id);

    /*
    * Dynamic query using three params
    * */
    List<Brand> selectByCondition(@Param("status")int status,
                                  @Param("companyName")String companyName,
                                  @Param("brandName")String BrandName);

    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    /*
    * add a new brand to the database
    * */
    void add(Brand brand);

    /*
    * alter the field of each record
    * */
    void update(Brand brand);

    /*
    * delete one record by its ID
    * */
    void deleteById(int id);

    /*
    * batach delete
    * */
    void deleteByIds(@Param("ids") int[] ids);

}
