package com.example.webblog.service.impl;

import com.example.webblog.model.FolderModel;
import com.example.webblog.service.IFolderService;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
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
    public String rename(FolderModel model) {
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
    public String move(FolderModel model, FolderModel paste) {
        return copy(model, paste, true);
    }

    @Override
    public String copy(FolderModel model, FolderModel paste) {
        return copy(model, paste, false);
    }

    @Override
    public void deleteList(FolderModel model) {
        List<File> childList = new ArrayList<>();
        String childLocation = model.getRealFolderPath();
        for (String child : model.getRemoveFolders()) { //model.getRealPathOf(childLocation) + "/" +
            childList.add(new File(childLocation + "/" + child));
        }
        for (File file : childList) {
            try {
                FileUtils.deleteDirectory(file);
            } catch (IOException ignored) {
            }
        }
    }

    private String copy(FolderModel model, FolderModel paste, boolean isMove) {
        List<File> childList = new ArrayList<>();
        String childLocation = model.getRealFolderPath();
        File pasteLocation = new File(paste.getRealFolderPath());

        if (isMove) {
            for (String child : model.getMoveFolders()) { //model.getRealPathOf(childLocation) + "/" +
                childList.add(new File(childLocation + "/" + child));
            }
        } else {
            for (String child : model.getCopyFolders()) { //model.getRealPathOf(childLocation) + "/" +
                childList.add(new File(childLocation + "/" + child));
            }
        }

        for (File file : childList) {
            try {
                Path original = Paths.get(file.toURI());
                Path newPath = Paths.get(pasteLocation.toURI());
                FileUtils.copyDirectoryToDirectory(file, pasteLocation);
                if (isMove){
                    FileUtils.deleteDirectory(file);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
