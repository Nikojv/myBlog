package com.niko.blog.service;

import com.niko.blog.vo.Result;
import com.niko.blog.vo.params.PageParams;

public interface ArticleService  {
    //find by each page
    Result listArticle(PageParams pageParams);
}
