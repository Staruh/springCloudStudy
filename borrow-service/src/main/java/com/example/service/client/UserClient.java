package com.example.service.client;

import com.example.entity.DbUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userService")
public interface UserClient {
    @GetMapping("dbUser/{id}")
    public ResponseEntity<DbUser> queryById(@PathVariable("id") Integer id);
}
