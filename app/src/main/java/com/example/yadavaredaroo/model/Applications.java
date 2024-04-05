package com.example.yadavaredaroo.model;

public class Applications {

    private int id;
    private String title;
    private int version;
    private String download;

    public Applications(int id, String title, int version, String download) {
        this.id = id;
        this.title = title;
        this.version = version;
        this.download = download;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }
}
