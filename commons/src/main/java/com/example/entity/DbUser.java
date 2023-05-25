package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (DbUser)实体类
 *
 * @author makejava
 * @since 2023-05-25 12:09:18
 */
@Data
public class DbUser implements Serializable {
    private static final long serialVersionUID = -35383039670043510L;
    
    private Integer uid;
    
    private String name;
    
    private String sex;
    
    private Integer age;

}

