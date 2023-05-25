package com.example.dao;

import com.example.entity.DbBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (DbBook)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-25 12:35:29
 */
public interface DbBookDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bid 主键
     * @return 实例对象
     */
    DbBook queryById(Integer bid);

    /**
     * 查询指定行数据
     *
     * @param dbBook 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DbBook> queryAllByLimit(DbBook dbBook, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dbBook 查询条件
     * @return 总行数
     */
    long count(DbBook dbBook);

    /**
     * 新增数据
     *
     * @param dbBook 实例对象
     * @return 影响行数
     */
    int insert(DbBook dbBook);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DbBook> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DbBook> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DbBook> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DbBook> entities);

    /**
     * 修改数据
     *
     * @param dbBook 实例对象
     * @return 影响行数
     */
    int update(DbBook dbBook);

    /**
     * 通过主键删除数据
     *
     * @param bid 主键
     * @return 影响行数
     */
    int deleteById(Integer bid);

}

