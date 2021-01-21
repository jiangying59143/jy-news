package com.jy.common.model.blog;

import com.jy.common.model.base.BaseTO;
import com.jy.common.model.privilege.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class UserSearchHistory extends BaseTO {

    public UserSearchHistory() {
    }

    public UserSearchHistory(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String content;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSearchHistory that = (UserSearchHistory) o;
        return this.id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, content);
    }
}
