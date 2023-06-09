package com.example.dao;

import com.example.entity.DbBorrow;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (DbBorrow)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-25 13:02:27
 */
public interface DbBorrowDao {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 用户id
     * @return 实例对象
     */
    List<DbBorrow> queryById(Integer uid);

    /**
     * 查询指定行数据
     *
     * @param dbBorrow 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DbBorrow> queryAllByLimit(DbBorrow dbBorrow, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dbBorrow 查询条件
     * @return 总行数
     */
    long count(DbBorrow dbBorrow);

    /**
     * 新增数据
     *
     * @param dbBorrow 实例对象
     * @return 影响行数
     */
    int insert(DbBorrow dbBorrow);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DbBorrow> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DbBorrow> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DbBorrow> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DbBorrow> entities);

    /**
     * 修改数据
     *
     * @param dbBorrow 实例对象
     * @return 影响行数
     */
    int update(DbBorrow dbBorrow);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

