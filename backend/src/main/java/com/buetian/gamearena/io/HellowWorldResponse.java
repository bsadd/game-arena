package com.buetian.gamearena.io;

public class HellowWorldResponse {

    private final long id;
    private final String content;

    public HellowWorldResponse(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}