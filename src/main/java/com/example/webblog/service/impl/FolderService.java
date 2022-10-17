package com.example.webblog.service.impl;

import com.example.webblog.model.FolderModel;
import com.example.webblog.service.IFolderService;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FolderService implements IFolderService {

    @Override
    public boolean exist(FolderModel model) {
        File folder = new File(model.getRealFolderPath());
        return Files.exists(folder.toPath());
    }

    @Override
    public FolderModel create(FolderModel model) {
        File folder = new File(model.getRealFolderPath());
        if (Files.exists(folder.toPath())) {
            return null;
        }
        folder.mkdirs();
        model.setFolderName(folder.getName());
        return model;
    }

    @Override
    public void read(FolderModel model) {
        File folder = new File(model.getRealFolderPath());
        File[] items =  folder.listFiles();
        if (items == null) {
            return;
        }

        model.setFolderName( folder.getName());
        List<String> childFolder = new ArrayList<>();
        List<String> images = new ArrayList<>();

        for (File item : items) {
            String name = item.getName();
            if (item.isDirectory()) {
                childFolder.add(name);
                continue;
            }
            if (item.isFile()) {
                images.add(name);
            }
        }

        model.setChildFolders(childFolder);
        model.setImages(images);
    }

    @Override
    public String update(FolderModel model) {
        File folder = new File(model.getRealFolderPath());

        if (model.getUpdateType() == FolderModel.UpdateType.rename) {
            File oldFolderName = new File(folder.toPath() + "/" + model.getFolderName());
            File newFolderName = new File(folder.toPath() + "/" + model.getFolderNewName());
            if (Files.exists(newFolderName.toPath())) {
                return "folder da ton tai"; //new folder name is exits
            }

            if (oldFolderName.renameTo(newFolderName)) {
                return "rename thanh cong"; //success
            }
            return "rename that bai"; //fail
        }

        return null;
    }

    @Override
    public void delete(FolderModel model) {
        File folder = new File(model.getRealFolderPath());
        if (!Files.exists(folder.toPath())) {
            return;
        }
        try {
            FileUtils.deleteDirectory(folder);
        } catch (IOException ignored) {
        }
    }

}
