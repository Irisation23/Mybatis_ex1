package com.nhnacademy.edu.jdbc1.mybatis.mapper;

import com.nhnacademy.edu.jdbc1.mybatis.Students;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
    @Select("SELECT * FROM JdbcStudents WHERE id = #{id}")
    Students selectStudent(int id);
}