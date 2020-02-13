package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 前端控制层
 */
@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 添加到 ElasticSearch 搜索索引库
     *
     * @param article 文章
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article) {
        articleService.save(article);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 根据索引查询文章 + 分页
     *
     * @param key  索引库中的id
     * @param page 页码
     * @param size 每页大小
     * @return
     */
    @RequestMapping(value = "/{key}/{page}/{size}", method = RequestMethod.GET)
    public Result findByKey(@PathVariable String key, @PathVariable int page, @PathVariable int size) {
        Page<Article> pageData = articleService.findByKey(key, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Article>(pageData.getTotalElements(), pageData.getContent()));
    }
}
