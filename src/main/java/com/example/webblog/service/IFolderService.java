package com.example.webblog.service;

import com.example.webblog.model.FolderModel;

public interface IFolderService {
    boolean exist(FolderModel model);
    FolderModel create(FolderModel model);
    void read(FolderModel model);
    String update(FolderModel model);
    void delete(FolderModel model);
}
