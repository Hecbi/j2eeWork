package team1.model;

import java.io.Serializable;

public class Comment implements Serializable {
    private String commontId;
    private String articleId;
    private String nickname;
    private String email;
    private String value;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getCommontId() {
        return commontId;
    }

    public void setCommontId(String commontId) {
        this.commontId = commontId;
    }
}

