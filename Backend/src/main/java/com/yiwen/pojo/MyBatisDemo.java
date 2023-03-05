package com.yiwen.pojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {
    public static void main(String[] args) throws IOException{
        //1. get mybatis xml file and get the SQLsessionFactory
        String resource = "mybatis.config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get SqlSession instance to run the query
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. run query using the namespace and iof the maper xml file
        List<User> users = sqlSession.selectList("test.selectAll");
        System.out.println(users);

        //4. release the resources
        sqlSession.close();
    }

}
