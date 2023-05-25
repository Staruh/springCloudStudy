package com.example.dao;

import com.example.entity.DbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (DbUser)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-25 12:09:18
 */
public interface DbUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    DbUser queryById(Integer uid);

    /**
     * 查询指定行数据
     *
     * @param dbUser 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DbUser> queryAllByLimit(DbUser dbUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dbUser 查询条件
     * @return 总行数
     */
    long count(DbUser dbUser);

    /**
     * 新增数据
     *
     * @param dbUser 实例对象
     * @return 影响行数
     */
    int insert(DbUser dbUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DbUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DbUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DbUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DbUser> entities);

    /**
     * 修改数据
     *
     * @param dbUser 实例对象
     * @return 影响行数
     */
    int update(DbUser dbUser);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 影响行数
     */
    int deleteById(Integer uid);

}

