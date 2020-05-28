package com.zhumenghci.springboot.online;

import com.zhumenghci.springboot.deo.VideoMapper;
import com.zhumenghci.springboot.domain.Video;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionDemo {

    public static void main(String[] args) throws IOException {

        String resouce = "config/mybatis-config.xml";

        InputStream inputStream =  Resources.getResourceAsStream(resouce);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try(SqlSession sqlSession = sqlSessionFactory.openSession()){

            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);

            Video video = videoMapper.selectById(1);

            System.out.println(video.toString());




        }

    }




}
