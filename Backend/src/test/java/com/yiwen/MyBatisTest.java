package com.yiwen;

import com.yiwen.mapper.BrandMapper;
import com.yiwen.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSeletAll() throws IOException{
        //1. get sqlsessionfactory
        String resource = "mybatis.config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlsession instance
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. execute
        List<Brand> res =  brandMapper.selectAll();
        System.out.println(res);
        //5. release resource
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException{
        //0. get id variable
        int id = 1;

        //1. get sqlsessionfactory
        String resource = "mybatis.config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlsession instance
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. execute
        Brand res =  brandMapper.selectById(id);
        System.out.println(res);
        //5. release resource
        sqlSession.close();
    }

    @Test
    public void testSelectByCondiation() throws IOException{
        //0. solution 1 get id variable
        int status = 0;
        String companyName = "Apple";
        String brandName = "Apple";

        //blur search need to be processed in code
        companyName = '%' +companyName + '%';
        brandName = '%' + brandName + '%';

        // Solution 2 Or we can pass the Brand objec
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompany_name(companyName);
//        brand.setStatus(status);

        //Solution 3 we can pass a hashmap
        Map m = new HashMap();
        m.put("status", status);
        m.put("brandName", brandName); //notice that this should be aligned to
        //the mapped column name, instead of the original column name.
        m.put("companyName", companyName);

        //1. get sqlsessionfactory
        String resource = "mybatis.config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlsession instance
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. execute
        List<Brand> res =  brandMapper.selectByCondition(status, companyName, brandName);
        List<Brand> res2 = brandMapper.selectByCondition(brand);
        List<Brand> res3 = brandMapper.selectByCondition(m);
        System.out.println(res);
        System.out.println(res2);
        System.out.println(res3);
        //5. release resource
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException{
        //0. get id variable
        String companyName = "Unif";
        String brandName = "Unif Inc.";
        String description = "fashion brand";
        int ordered = 1000;
        int status = 1;

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompany_name(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1. get sqlsessionfactory
        String resource = "mybatis.config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlsession instance
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);
        System.out.println(brand.getId());

        //if doesn't set the auto commit to true
        //needs to manually commit
        //sqlSession.commit();

        //5. release resource
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException{
        //0. get id variable
        String companyName = "Unif";
        String brandName = "Unif Inc.";
        String description = "fashion brand";
        int ordered = 1000;
        int status = 1;

        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompany_name(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription("quick sold fashion company");
        brand.setOrdered(4000);
        brand.setId(7);

        //1. get sqlsessionfactory
        String resource = "mybatis.config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlsession instance
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.update(brand);
        Brand res = brandMapper.selectById(brand.getId());
        System.out.println(res);
        //if doesn't set the auto commit to true
        //needs to manually commit
        //sqlSession.commit();

        //5. release resource
        sqlSession.close();
    }


    @Test
    public void testDeleteByID() throws IOException{
        //0. get id variable
        int id = 8;

        //1. get sqlsessionfactory
        String resource = "mybatis.config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlsession instance
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(8);

        //if doesn't set the auto commit to true
        //needs to manually commit
        sqlSession.commit();

        //5. release resource
        sqlSession.close();
    }

    @Test
    public void testDeleteByIDs() throws IOException{
        //0. get id variable
        int[] ids = new int[]{8,9};

        //1. get sqlsessionfactory
        String resource = "mybatis.config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get sqlsession instance
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteByIds(ids);

        //if doesn't set the auto commit to true
        //needs to manually commit
        sqlSession.commit();

        //5. release resource
        sqlSession.close();
    }
}
