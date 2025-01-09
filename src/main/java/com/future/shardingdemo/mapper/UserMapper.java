package com.future.shardingdemo.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.future.shardingdemo.entity.User;


@Repository
public interface UserMapper extends BaseMapper<User> {
}