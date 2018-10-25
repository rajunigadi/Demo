package com.raju.demo.mvp.model;

public class EmptyItem implements ListItem {

    private String header;
    private String header2;

    public EmptyItem() {
    }

    public EmptyItem(String header) {
        this.header = header;
    }

    public EmptyItem(String header, String header2) {
        this.header = header;
        this.header2 = header2;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeader2() {
        return header2;
    }

    public void setHeader2(String header2) {
        this.header2 = header2;
    }
}
