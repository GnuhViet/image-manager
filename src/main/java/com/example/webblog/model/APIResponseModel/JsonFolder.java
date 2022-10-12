package com.example.webblog.model.APIResponseModel;

import com.example.webblog.model.FolderModel;

import java.util.List;

public class JsonFolder {
    private final String folderName;
    private final String folderPath;
    private final List<String> childFolders; // luu ten cua child folder
    private final List<String> images; // luu ten cua item trong folder

    private JsonFolder(FolderModel model) {
        folderName = model.getFolderName();
        folderPath = model.getFolderPath();
        childFolders = model.getChildFolders();
        images = model.getImages();
    }

    public static JsonFolder of(FolderModel model) {
        return new JsonFolder(model);
    }

    public String getFolderName() {
        return folderName;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public List<String> getChildFolders() {
        return childFolders;
    }

    public List<String> getImages() {
        return images;
    }
}
