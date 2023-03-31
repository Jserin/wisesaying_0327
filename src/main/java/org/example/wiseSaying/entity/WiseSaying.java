package org.example.wiseSaying.entity;

// 인스턴스 변수에 id,명언,작가를 받고 반환하는 역할

public class WiseSaying {
    private long id;
    private String content;
    private String authorName;

    public WiseSaying(long id, String content, String authorName) {
        this.id = id;
        this.content = content;
        this.authorName = authorName;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorName() {
        return authorName;
    }
}
