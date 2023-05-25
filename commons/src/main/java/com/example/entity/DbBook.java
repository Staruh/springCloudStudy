package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (DbBook)实体类
 *
 * @author makejava
 * @since 2023-05-25 12:35:59
 */
@Data
public class DbBook implements Serializable {
    private static final long serialVersionUID = 144507365885737666L;
    
    private Integer bid;
    
    private String title;
    
    private String describle;

}

