package com.nhnacademy.edu.jdbc1.mybatis;

import com.nhnacademy.edu.jdbc1.mybatis.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "com/nhnacademy/edu/jdbc1/mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);



        try (SqlSession session = sqlSessionFactory.openSession()) {
            Students student = session.selectOne("com.nhnacademy.edu.jdbc1.mybatis.StudentMapper.selectStudent", 1);
            System.out.println(student);

            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Students mapperStudent = mapper.selectStudent(2);
            System.out.println(mapperStudent);
        }

    }

}
