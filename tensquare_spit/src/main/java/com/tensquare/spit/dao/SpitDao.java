package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 数据库操作层
 * 使用的是 MongoDB
 */
public interface SpitDao extends MongoRepository<Spit, String> {

    /**
     * 通过上级 id 查询 + 分页
     *
     * @param parentid 上级id
     * @param pageable 分页
     * @return
     */
    public Page<Spit> findByParentid(String parentid, Pageable pageable);

}
