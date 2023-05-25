package com.example.controller;

import com.example.entity.DbBook;
import com.example.service.DbBookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DbBook)表控制层
 *
 * @author makejava
 * @since 2023-05-25 12:25:29
 */
@RestController
@RequestMapping("dbBook")
public class DbBookController {
    /**
     * 服务对象
     */
    @Resource
    private DbBookService dbBookService;

    /**
     * 分页查询
     *
     * @param dbBook 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DbBook>> queryByPage(DbBook dbBook, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dbBookService.queryByPage(dbBook, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DbBook> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.dbBookService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dbBook 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DbBook> add(DbBook dbBook) {
        return ResponseEntity.ok(this.dbBookService.insert(dbBook));
    }

    /**
     * 编辑数据
     *
     * @param dbBook 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DbBook> edit(DbBook dbBook) {
        return ResponseEntity.ok(this.dbBookService.update(dbBook));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dbBookService.deleteById(id));
    }

}

