package com.example.suspension.database;

public class DataModel {

    private int id;
    private int forkRebound;
    private int forkCompression;
    private int shockRebound;
    private int shockLowCompression;
    private int shockHighCompression;
    private String settingName;

    public DataModel(int id, int forkRebound, int forkCompression, int shockRebound, int shockLowCompression, int shockHighCompression, String settingName) {
        this.id = id;
        this.forkRebound = forkRebound;
        this.forkCompression = forkCompression;
        this.shockRebound = shockRebound;
        this.shockLowCompression = shockLowCompression;
        this.shockHighCompression = shockHighCompression;
        this.settingName = settingName;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "id=" + id +
                ", forkRebound=" + forkRebound +
                ", forkCompression=" + forkCompression +
                ", shockRebound=" + shockRebound +
                ", shockLowCompression=" + shockLowCompression +
                ", shockHighCompression=" + shockHighCompression +
                ", settingName='" + settingName + '\'' +
                '}';
    }

    public DataModel(){}

    public int getId() {
        return id;
    }

    public int getForkRebound() {
        return forkRebound;
    }

    public int getForkCompression() {
        return forkCompression;
    }

    public int getShockRebound() {
        return shockRebound;
    }

    public int getShockLowCompression() {
        return shockLowCompression;
    }

    public int getShockHighCompression() {
        return shockHighCompression;
    }

    public String getSettingName() {
        return settingName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setForkRebound(int forkRebound) {
        this.forkRebound = forkRebound;
    }

    public void setForkCompression(int forkCompression) {
        this.forkCompression = forkCompression;
    }

    public void setShockRebound(int shockRebound) {
        this.shockRebound = shockRebound;
    }

    public void setShockLowCompression(int shockLowCompression) {
        this.shockLowCompression = shockLowCompression;
    }

    public void setShockHighCompression(int shockHighCompression) {
        this.shockHighCompression = shockHighCompression;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }


}
