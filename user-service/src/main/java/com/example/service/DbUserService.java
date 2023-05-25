package com.example.service;

import com.example.entity.DbUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (DbUser)表服务接口
 *
 * @author makejava
 * @since 2023-05-25 12:09:18
 */
public interface DbUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    DbUser queryById(Integer uid);

    /**
     * 分页查询
     *
     * @param dbUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DbUser> queryByPage(DbUser dbUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dbUser 实例对象
     * @return 实例对象
     */
    DbUser insert(DbUser dbUser);

    /**
     * 修改数据
     *
     * @param dbUser 实例对象
     * @return 实例对象
     */
    DbUser update(DbUser dbUser);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uid);

}
