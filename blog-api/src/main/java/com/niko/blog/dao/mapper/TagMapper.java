package com.niko.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.niko.blog.dao.pojo.Tag;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 根据articleid查询标签列表
     * @param articleId
     * @return
     */
    List<Tag> findTagsByArticleId(Long articleId);
}
