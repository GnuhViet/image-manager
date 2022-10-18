package com.example.webblog.model;

import java.util.List;

public class FolderModel {
    private static final String severPath = "/home/gnuh/Pictures/ProjectFileUpload/WebBlog/UserFolder/";

    private Long userId;
    private String folderName;
    private String folderPath;
    private List<String> childFolders; // luu ten cua child folder
    private List<String> images; // luu ten cua item trong folder

    public enum UpdateType{
        rename,
        move,
        copy,
        remove,
        paste
    }

    private String folderNewName;
    private List<String> moveFolders;
    private List<String> copyFolders;
    private List<String> removeFolders;
    private UpdateType updateType;

    public String getRealPathOf(String folderPath) {
        if (folderPath == null) {
            folderPath = "home";
        }
        if ("home".equals(folderPath)) {
            return severPath + folderPath.replace("home", String.valueOf(userId));
        }
        // home/asdfa/home/zcvzxc
        StringBuilder sb = new StringBuilder(folderPath);
        while (sb.charAt(0) != '/') {
            sb.deleteCharAt(0);
        }
        sb.insert(0, userId);
        return severPath + sb;
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
        return getRealPathOf(this.folderPath);
    }

    public String getFolderNewName() {
        return folderNewName;
    }

    public void setFolderNewName(String folderNewName) {
        this.folderNewName = folderNewName;
    }

    public List<String> getMoveFolders() {
        return moveFolders;
    }

    public void setMoveFolders(List<String> moveFolders) {
        this.moveFolders = moveFolders;
    }

    public List<String> getCopyFolders() {
        return copyFolders;
    }

    public void setCopyFolders(List<String> copyFolders) {
        this.copyFolders = copyFolders;
    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(UpdateType updateType) {
        this.updateType = updateType;
    }

    public List<String> getRemoveFolders() {
        return removeFolders;
    }

    public void setRemoveFolders(List<String> removeFolders) {
        this.removeFolders = removeFolders;
    }
}
