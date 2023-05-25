package com.example.service.impl;

import com.example.dao.DbBookDao;
import com.example.entity.DbBook;
import com.example.service.DbBookService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (DbBook)表服务实现类
 *
 * @author makejava
 * @since 2023-05-25 12:25:31
 */
@Service("dbBookService")
public class DbBookServiceImpl implements DbBookService {
    @Resource
    private DbBookDao dbBookDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bid 主键
     * @return 实例对象
     */
    @Override
    public DbBook queryById(Integer bid) {
        return this.dbBookDao.queryById(bid);
    }

    /**
     * 分页查询
     *
     * @param dbBook 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DbBook> queryByPage(DbBook dbBook, PageRequest pageRequest) {
        long total = this.dbBookDao.count(dbBook);
        return new PageImpl<>(this.dbBookDao.queryAllByLimit(dbBook, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dbBook 实例对象
     * @return 实例对象
     */
    @Override
    public DbBook insert(DbBook dbBook) {
        this.dbBookDao.insert(dbBook);
        return dbBook;
    }

    /**
     * 修改数据
     *
     * @param dbBook 实例对象
     * @return 实例对象
     */
    @Override
    public DbBook update(DbBook dbBook) {
        this.dbBookDao.update(dbBook);
        return this.queryById(dbBook.getBid());
    }

    /**
     * 通过主键删除数据
     *
     * @param bid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bid) {
        return this.dbBookDao.deleteById(bid) > 0;
    }
}
