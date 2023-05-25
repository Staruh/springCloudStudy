package com.example.service;

import com.example.entity.DbBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (DbBook)表服务接口
 *
 * @author makejava
 * @since 2023-05-25 12:25:31
 */
public interface DbBookService {

    /**
     * 通过ID查询单条数据
     *
     * @param bid 主键
     * @return 实例对象
     */
    DbBook queryById(Integer bid);

    /**
     * 分页查询
     *
     * @param dbBook 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DbBook> queryByPage(DbBook dbBook, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dbBook 实例对象
     * @return 实例对象
     */
    DbBook insert(DbBook dbBook);

    /**
     * 修改数据
     *
     * @param dbBook 实例对象
     * @return 实例对象
     */
    DbBook update(DbBook dbBook);

    /**
     * 通过主键删除数据
     *
     * @param bid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bid);

}
