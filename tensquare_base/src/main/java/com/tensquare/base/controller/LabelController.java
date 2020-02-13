package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 叔公 on 2019-02-24.
 * 标签前端控制层
 */
@RestController
@RequestMapping("/label")
@CrossOrigin //微服务之间的跨域调用
@RefreshScope //可以获取到git中的配置文件的自定义的配置的更改，所以开发时建议写上该注解
public class LabelController {

    /**
     * 自动注入标签业务逻辑类的对象
     */
    @Autowired
    private LabelService labelService;

    /**
     * 查询全部列表
     * <p>
     * 请求URL: 127.0.0.1:9001/label
     *
     * @return 返回查询结果
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", labelService.findAll());
    }

    /**
     * 根据id查询标签
     * <p>
     * 请求URL: 127.0.0.1:9001/label/1099598432688992256
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String id) {
        return new Result(true, StatusCode.OK, "查询成功", labelService.findById(id));
    }

    /**
     * 添加标签
     * <p>
     * 请求URL: 127.0.0.1:9001/label
     *
     * @param label
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        labelService.save(label);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    /**
     * 修改标签
     * <p>
     * 请求URL: 127.0.0.1:9001/label/1099598432688992256
     *
     * @param labelId 标签id
     * @param label   标签实体
     * @return
     */
    @RequestMapping(value = "{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId, @RequestBody Label label) {
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    /**
     * 根据id删除标签
     * <p>
     * 请求URL: 127.0.0.1:9001/label/1099598432688992256
     *
     * @param labelId 标签id
     * @return
     */
    @RequestMapping(value = "{labelId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelId) {
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 带条件的查询
     * <p>
     * 请求URL：127.0.0.1:9001/label/search
     *
     * @param label 页面传递的 label
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Label label) {
        List<Label> list = labelService.findSearch(label);
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    /**
     * 分页查询
     * <p>
     * 请求URL: http://localhost:9001/label/search/1/1
     *
     * @param page 页码
     * @param size 页大小
     * @param label
     * @return
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@PathVariable int page, @PathVariable int size, @RequestBody Label label) {
        Page<Label> pageData = labelService.pageQuery(page, size, label);
        return new Result(true, StatusCode.OK, "查询成功",
                new PageResult<Label>(pageData.getTotalElements(), pageData.getContent()));
    }
}
