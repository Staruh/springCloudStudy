package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class borrowDetail {
    DbUser user;
    List<DbBook> bookList;
}
