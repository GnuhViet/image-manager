package com.example.webblog.service;

import com.example.webblog.model.FolderModel;

public interface IFolderService {
    boolean exist(FolderModel model);
    FolderModel create(FolderModel model);
    void read(FolderModel model);
    String rename(FolderModel model);
    String move(FolderModel model, FolderModel paste);
    String copy(FolderModel model, FolderModel paste);
    void deleteList(FolderModel model);
    void delete(FolderModel model);
}
