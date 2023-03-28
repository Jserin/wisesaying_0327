package org.example;

public class SayingList {
    private long id;
    private String content;
    private String author;

    SayingList(long id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getContent(){
        return content;
    }

    public String getAuthor() {
        return author;
    }
}
