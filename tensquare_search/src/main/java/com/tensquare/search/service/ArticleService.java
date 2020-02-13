package com.tensquare.search.service;

import com.tensquare.search.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.tensquare.search.pojo.Article;

/**
 * 服务层
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;
//    @Autowired
//    private IdWorker idWorker;

    /**
     * 添加到 ElasticSearch 搜索索引库
     *
     * @param article 文章
     */
    public void save(Article article) {
        //article.setId(idWorker.nextId()+"");
        articleDao.save(article);
    }

    /**
     * 根据 key 搜索文章 + 分页
     *
     * @param key  索引库的 id
     * @param page 页码
     * @param size 每页大小
     * @return
     */
    public Page<Article> findByKey(String key, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return articleDao.findByTitleOrContentLike(key, key, pageable);
    }
}
