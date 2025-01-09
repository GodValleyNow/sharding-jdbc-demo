package com.future.shardingdemo.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.future.shardingdemo.entity.Course;

@Repository
// @MapperScan("com.future.shardingdemo.mapper")
public interface CourseMapper extends BaseMapper<Course> {

}
