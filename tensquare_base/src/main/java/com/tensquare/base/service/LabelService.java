package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 叔公 on 2019-02-24.
 * 标签业务逻辑类
 */
@Service
@Transactional // 事务控制
public class LabelService {
    /**
     * 自动注入 LabelDao 的动态代理实现类对象
     */
    @Autowired
    private LabelDao labelDao;

    /**
     * 自动注入 idWorker 对象
     */
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     *
     * @return 返回查询的结果集合
     */
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    /**
     * 根据 id 查询标签
     *
     * @param id 标签的id
     * @return 返回查询的标签
     */
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    /**
     * 增加标签
     *
     * @param label 传入的要增加的标签
     */
    public void save(Label label) {
        //设置id
        label.setId(idWorker.nextId() + "");
        //保存
        labelDao.save(label);
    }

    /**
     * 更新标签
     *
     * @param label 传入的要更新的标签
     */
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     * 根据id删除标签
     *
     * @param id 标签的id
     */
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    /**
     * 根据条件查询标签
     *
     * @param label 传递的标签
     * @return
     */
    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             * 带条件的擦查询
             * @param root 根对象，也就是要把条件封装到那个对象中。 where 类名=label.getid
             * @param query 封装的都是查询关键字，比如 group by, order by 等等
             * @param cb 用来封装条件对象的，如果直接返回 null，表示不需要任何条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //new 一个list存放所有的查询条件
                List<Predicate> list = new ArrayList<>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    // where labelname like "%张三%"
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                if (label.getState() != null && !"".equals(label.getState())) {
                    // state = "1"
                    Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }
                //new一个数组作为最终的返回条件
                Predicate[] parr = new Predicate[list.size()];
                //把集合中的属性复制到数组中
                parr = list.toArray(parr);
                return cb.and(parr); // where labelname like "%张三%" and state = "1"
            }
        });
    }

    /**
     * 分页查询
     *
     * @param page  页码
     * @param size  页大小
     * @param label
     * @return
     */
    public Page<Label> pageQuery(int page, int size, Label label) {
        //封装了一个分页对象，在springdatajpa中想要实现分页，直接传一个分页对象即可
        Pageable pageable = PageRequest.of(page - 1, size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             * 带条件的擦查询
             * @param root 根对象，也就是要把条件封装到那个对象中。 where 类名=label.getid
             * @param query 封装的都是查询关键字，比如 group by, order by 等等
             * @param cb 用来封装条件对象的，如果直接返回 null，表示不需要任何条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                if (label.getState() != null && !"".equals(label.getState())) {
                    Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }
                Predicate[] parr = new Predicate[list.size()];
                //把集合中的属性复制到数组中
                parr = list.toArray(parr);
                return cb.and(parr);
            }
        }, pageable);
    }
}
