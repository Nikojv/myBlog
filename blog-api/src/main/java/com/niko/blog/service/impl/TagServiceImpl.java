package com.niko.blog.service.impl;

import com.niko.blog.dao.mapper.TagMapper;
import com.niko.blog.dao.pojo.Tag;
import com.niko.blog.service.TagService;
import com.niko.blog.vo.TagVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    public TagVO copy(Tag tag){
        TagVO tagVO = new TagVO();
        BeanUtils.copyProperties(tag,tagVO);
        return tagVO;
    }
    public List<TagVO> copyList(List<Tag> tagList){
        List<TagVO> tagVOList = new ArrayList<>();
        for(Tag tag: tagList){
            tagVOList.add(copy(tag));
        }
        return tagVOList;
    }

    @Override
    public List<TagVO> findTagsByArticleId(Long articleId){
        List<Tag> tags = tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }

}
