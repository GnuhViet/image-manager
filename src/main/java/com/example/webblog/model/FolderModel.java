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
        paste
    }

    private String folderNewName;
    private List<String> moveFolders;
    private List<String> copyFolders;
    private String pasteDestination;
    private UpdateType updateType;

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
        if (folderPath == null) {
            folderPath = "home";
        }
        return severPath + folderPath.replace("home", String.valueOf(userId));
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

    public String getPasteDestination() {
        return pasteDestination;
    }

    public void setPasteDestination(String pasteDestination) {
        this.pasteDestination = pasteDestination;
    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(UpdateType updateType) {
        this.updateType = updateType;
    }
}
