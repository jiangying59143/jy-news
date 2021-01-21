package com.jy.common.model.blog;


import com.jy.common.model.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 踩
 */
@Entity
public class ArticleThumbsDownCount extends BaseEntity<Long> {

    //踩数
    private Long thumbsDownCount;

    public ArticleThumbsDownCount() {

    }

    public ArticleThumbsDownCount(long thumbsDownCount) {
        this.thumbsDownCount = thumbsDownCount;
    }

    public Long getThumbsDownCount() {
        return thumbsDownCount;
    }

    public void setThumbsDownCount(Long thumbsDownCount) {
        this.thumbsDownCount = thumbsDownCount;
    }
}
