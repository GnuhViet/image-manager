package com.example.webblog.service.impl;

import com.example.webblog.model.FolderModel;
import com.example.webblog.service.IFolderService;


import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FolderService implements IFolderService {

    @Override
    public FolderModel create(FolderModel model) {
        File file = new File(model.getRealFolderPath());
        if (Files.exists(file.toPath())) {
            return null;
        }
        file.mkdirs();
        model.setFolderName(file.getName());
        return model;
    }

    @Override
    public void read(FolderModel model) {
        File file = new File(model.getRealFolderPath());
        File[] items = file.listFiles();
        if (items == null) {
            return;
        }

        model.setFolderName(file.getName());
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
    public void update(FolderModel model) {
    }

    @Override
    public void delete(FolderModel model) {
    }

}
