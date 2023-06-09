package com.example.service.client;

import com.example.entity.DbBook;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("bookService")
public interface BookClient {
    @GetMapping("dbBook/{id}")
    public ResponseEntity<DbBook> queryById(@PathVariable("id") Integer id);
}
