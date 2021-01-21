package com.jy.common.model.blog;



import com.jy.common.model.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 点赞
 */

@Entity
public class ArticleThumbsUpCount extends BaseEntity<Long> {

    //赞数
    private Long thumbsUpCount;

    public ArticleThumbsUpCount() {

    }

    public ArticleThumbsUpCount(Long thumbsUpCount) {
        this.thumbsUpCount = thumbsUpCount;
    }

    public Long getThumbsUpCount() {
        return thumbsUpCount;
    }

    public void setThumbsUpCount(Long thumbsUpCount) {
        this.thumbsUpCount = thumbsUpCount;
    }
}
