package com.example.service.impl;

import com.example.entity.DbBook;
import com.example.entity.DbBorrow;
import com.example.dao.DbBorrowDao;
import com.example.entity.DbUser;
import com.example.entity.borrowDetail;
import com.example.service.DbBorrowService;
import com.example.service.client.BookClient;
import com.example.service.client.UserClient;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (DbBorrow)表服务实现类
 *
 * @author makejava
 * @since 2023-05-25 13:02:27
 */
@Service("dbBorrowService")
public class DbBorrowServiceImpl implements DbBorrowService {
    @Resource
    private DbBorrowDao dbBorrowDao;

    @Resource
    RestTemplate restTemplate;

    @Resource
    UserClient userClient;

    @Resource
    BookClient bookClient;

    @Override
    public borrowDetail getBorrowDetailById(Integer uid) {
        List<DbBorrow> dbBorrowList = dbBorrowDao.queryById(uid);
        List<Integer> bidList = new ArrayList<>();
        for(DbBorrow dbBorrow : dbBorrowList){
            bidList.add(dbBorrow.getBid());
        }
        DbUser dbUser = userClient.queryById(uid).getBody();
        List<DbBook> books = new ArrayList<>();
        bidList.forEach(bid -> {
            DbBook book = bookClient.queryById(bid).getBody();
            books.add(book);
        });
        return new borrowDetail(dbUser,books);
    }

    @Override
    public DbBorrow queryById(Integer id) {
        return null;
    }

    /**
     * 分页查询
     *
     * @param dbBorrow 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DbBorrow> queryByPage(DbBorrow dbBorrow, PageRequest pageRequest) {
        long total = this.dbBorrowDao.count(dbBorrow);
        return new PageImpl<>(this.dbBorrowDao.queryAllByLimit(dbBorrow, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dbBorrow 实例对象
     * @return 实例对象
     */
    @Override
    public DbBorrow insert(DbBorrow dbBorrow) {
        this.dbBorrowDao.insert(dbBorrow);
        return dbBorrow;
    }

    /**
     * 修改数据
     *
     * @param dbBorrow 实例对象
     * @return 实例对象
     */
    @Override
    public DbBorrow update(DbBorrow dbBorrow) {
        this.dbBorrowDao.update(dbBorrow);
        return this.queryById(dbBorrow.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dbBorrowDao.deleteById(id) > 0;
    }
}
