package com.example.controller;

import com.example.entity.DbUser;
import com.example.service.DbUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DbUser)表控制层
 *
 * @author makejava
 * @since 2023-05-25 12:09:18
 */
@RestController
@RequestMapping("dbUser")
public class DbUserController {
    /**
     * 服务对象
     */
    @Resource
    private DbUserService dbUserService;

    /**
     * 分页查询
     *
     * @param dbUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DbUser>> queryByPage(DbUser dbUser, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dbUserService.queryByPage(dbUser, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DbUser> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.dbUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dbUser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DbUser> add(DbUser dbUser) {
        return ResponseEntity.ok(this.dbUserService.insert(dbUser));
    }

    /**
     * 编辑数据
     *
     * @param dbUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DbUser> edit(DbUser dbUser) {
        return ResponseEntity.ok(this.dbUserService.update(dbUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dbUserService.deleteById(id));
    }

}

