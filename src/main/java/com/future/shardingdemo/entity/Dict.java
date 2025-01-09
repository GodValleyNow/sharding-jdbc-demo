package com.future.shardingdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("t_dict")
public class Dict {
    private Long dictId;
    private String status;
    private String value;
}