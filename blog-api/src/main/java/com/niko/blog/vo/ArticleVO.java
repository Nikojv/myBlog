package com.niko.blog.vo;

import lombok.Data;

import java.util.List;

@Data
public class ArticleVO {
    private Long id;
    private String title;
    private String summary;
    private int commentCounts;
    private int viewCounts;
    private int weight;
    private String createDate;
    private String author;

    //private ArticleBodyVO body;
    private List<TagVO> tags;
    //private List<CategoryVO> categories;
}
