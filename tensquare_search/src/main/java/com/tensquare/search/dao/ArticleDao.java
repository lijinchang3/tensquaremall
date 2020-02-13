package com.tensquare.search.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.tensquare.search.pojo.Article;

/**
 * ElasticSearch 索引库操作层
 */
public interface ArticleDao extends ElasticsearchRepository<Article, String> {

    /**
     * 索引库中查询标题或内容 + 分页
     *
     * @param title    文章标题
     * @param content  文章内容
     * @param pageable 分页
     * @return
     */
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
