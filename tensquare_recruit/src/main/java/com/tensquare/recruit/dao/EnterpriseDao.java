package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Enterprise;

import java.util.List;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface EnterpriseDao extends JpaRepository<Enterprise, String>, JpaSpecificationExecutor<Enterprise> {

    /**
     * 查询热门企业
     * where ishot = ?
     *
     * @param ishot 是否热门，0-非热门， 1-热门
     * @return
     */
    List<Enterprise> findByIshot(String ishot);
}
