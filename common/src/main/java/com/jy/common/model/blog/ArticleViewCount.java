package com.jy.common.model.blog;



import com.jy.common.model.base.BaseEntity;

import javax.persistence.Entity;

/**
 * 阅读量
 */
@Entity
public class ArticleViewCount extends BaseEntity<Long> {

    public ArticleViewCount() {
    }

    public ArticleViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

     //阅读量
    private Long viewCount;

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }
}
