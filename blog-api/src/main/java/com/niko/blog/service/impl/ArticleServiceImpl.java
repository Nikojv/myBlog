package com.niko.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niko.blog.dao.mapper.ArticleMapper;
import com.niko.blog.dao.pojo.Article;
import com.niko.blog.service.ArticleService;
import com.niko.blog.service.SysUserService;
import com.niko.blog.service.TagService;
import com.niko.blog.vo.ArticleVO;
import com.niko.blog.vo.Result;
import com.niko.blog.vo.params.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private TagService tagService;

    private List<ArticleVO> copyList(List<Article> records,boolean isTag, boolean isAuthor) {
        List<ArticleVO> articleVOList = new ArrayList<>();
        for(Article record: records){
            articleVOList.add(copy(record,isTag,isAuthor));
        }
        return articleVOList;
    }

    private ArticleVO copy(Article article, boolean isTag, boolean isAuthor){
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article,articleVO);

        articleVO.setCreateDate(new DateTime(article.getCreateDate().toString("yyyy-MM-dd HH:mm")));
        if (isTag){
            Long articleId = article.getId();
            articleVO.setTags(tagService.findTagsByArticleId(articleId));
        }
        if (isAuthor){
            Long authorId = article.getAuthorId();
            articleVO.setAuthor(sysUserService.findUserById(authorId).getNickname());
        }
        return articleVO;
    }

    @Override
    public Result listArticle(PageParams pageParams) {
        /**
         * 1.分页查询 article数据库表
         */
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //是否置顶进行排序
        queryWrapper.orderByDesc(Article::getWeight,Article::getCreateDate);
        Page<Article> page1 = articleMapper.selectPage(page,queryWrapper);
        List<Article> records = articlePage.getRecords();
        List<ArticleVO> articleVOList = copyList(records,true,true);
        return Result.success();
    }
}
