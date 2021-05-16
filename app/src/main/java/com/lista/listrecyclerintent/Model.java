package com.lista.listrecyclerintent;

public class Model {

    public Model() {
    }

    private String count;
    private String link;

    public Model(String count, String link) {
        this.count = count;
        this.link = link;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
