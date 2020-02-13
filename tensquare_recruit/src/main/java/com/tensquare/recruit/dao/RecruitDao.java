package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface RecruitDao extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {

    /**
     * 根据创建时间倒叙查询前 6 条推荐职位
     * where state=? order by createime
     *
     * @param state
     * @return
     */
    List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);

    /**
     * 根据创建时间倒叙查询前 6 条推荐职位
     * where state!=? order by createime
     *
     * @param state
     * @return
     */
    List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);
}
