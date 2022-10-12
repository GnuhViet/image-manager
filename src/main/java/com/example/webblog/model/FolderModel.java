package com.example.webblog.model;

import java.util.ArrayList;
import java.util.List;

public class FolderModel {
    private static final String severPath = "/home/gnuh/Pictures/ProjectFileUpload/WebBlog/UserFolder/";

    private Long userId;
    private String folderName;
    private String folderPath;
    private List<String> childFolders; // luu ten cua child folder
    private List<String> images; // luu ten cua item trong folder

    public FolderModel() {
        childFolders = new ArrayList<>();
        images = new ArrayList<>();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public List<String> getChildFolders() {
        return childFolders;
    }

    public void setChildFolders(List<String> childFolders) {
        this.childFolders = childFolders;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getRealFolderPath() {
        return severPath + folderPath.replace("home", String.valueOf(userId));
    }
}
