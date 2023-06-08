package com.example.service.impl;

import com.example.entity.DbUser;
import com.example.dao.DbUserDao;
import com.example.service.DbUserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (DbUser)表服务实现类
 *
 * @author makejava
 * @since 2023-05-25 12:09:18
 */
@Service("dbUserService")
public class DbUserServiceImpl implements DbUserService {
    @Resource
    private DbUserDao dbUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    @Override
    public DbUser queryById(Integer uid) {
        System.out.println("ok");
        return this.dbUserDao.queryById(uid);
    }

    /**
     * 分页查询
     *
     * @param dbUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DbUser> queryByPage(DbUser dbUser, PageRequest pageRequest) {
        long total = this.dbUserDao.count(dbUser);
        return new PageImpl<>(this.dbUserDao.queryAllByLimit(dbUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dbUser 实例对象
     * @return 实例对象
     */
    @Override
    public DbUser insert(DbUser dbUser) {
        this.dbUserDao.insert(dbUser);
        return dbUser;
    }

    /**
     * 修改数据
     *
     * @param dbUser 实例对象
     * @return 实例对象
     */
    @Override
    public DbUser update(DbUser dbUser) {
        this.dbUserDao.update(dbUser);
        return this.queryById(dbUser.getUid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uid) {
        return this.dbUserDao.deleteById(uid) > 0;
    }
}
