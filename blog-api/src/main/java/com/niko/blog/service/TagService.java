package com.niko.blog.service;

import com.niko.blog.vo.TagVO;

import java.util.List;

public interface TagService {
    List<TagVO> findTagsByArticleId(Long articleId){

    }

}
