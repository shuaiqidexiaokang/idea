package com.lzk.controller;

import com.lzk.dto.PageBean;
import com.lzk.model.Article;
import com.lzk.model.CreateTimeCount;
import com.lzk.model.Type;
import com.lzk.service.ArticleService;
import com.lzk.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lzk on 2018/2/11 15:44
 * Description:
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private final int pageSize = 5;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String list(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                       @RequestParam(name = "typeId", required = false) Integer typeId,
                       @RequestParam(name = "createTime", required = false) String createTime, Model model) {
        int total;
        List<Article> articles;
        if(typeId != null && !typeId.equals("")){
            total = articleService.queryCountByTypeId(typeId);
            articles = articleService.queryArticlesByTypeId(typeId, (pageNo - 1) * pageSize, pageSize);
            model.addAttribute("typeId", typeId);
        }else if(createTime!=null&& !createTime.equals("")){
            total = articleService.queryCountByCreateTime(createTime);
            articles = articleService.queryArticlesByCreateTime(createTime, (pageNo - 1) * pageSize, pageSize);
            model.addAttribute("createTime", createTime);
        }else{
            total = articleService.queryCount();
            articles = articleService.queryArticles((pageNo - 1) * pageSize, pageSize);
        }
        PageBean page = new PageBean(pageNo, pageSize, total);
        List<Article> hotBlog = articleService.queryHotArticles();
        List<Article> newBlog = articleService.queryNewArticles();
        List<Type> types = typeService.queryAll();
        List<CreateTimeCount> dates = articleService.queryDates();
        model.addAttribute("articles", articles);
        model.addAttribute("page", page);
        model.addAttribute("hotBlog", hotBlog);
        model.addAttribute("newBlog", newBlog);
        model.addAttribute("types", types);
        model.addAttribute("dates", dates);
        return "index";
    }

    @RequestMapping(value = "/{blogId}/details", method = RequestMethod.GET)
    public String details(@PathVariable("blogId") Integer blogId, Model model) {
        Article article = articleService.queryById(blogId);
        List<Article> hotBlog = articleService.queryHotArticles();
        List<Article> newBlog = articleService.queryNewArticles();
        List<Type> types = typeService.queryAll();
        model.addAttribute("article", article);
        model.addAttribute("hotBlog", hotBlog);
        model.addAttribute("newBlog", newBlog);
        model.addAttribute("types", types);
        return "details";
    }
}
