package com.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (DbBorrow)实体类
 *
 * @author makejava
 * @since 2023-05-25 13:02:27
 */
@Data
public class DbBorrow implements Serializable {
    private static final long serialVersionUID = -47332843520245473L;
    
    private Integer id;
    
    private Integer uid;
    
    private Integer bid;
}

