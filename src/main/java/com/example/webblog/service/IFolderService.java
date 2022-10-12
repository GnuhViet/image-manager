package com.example.webblog.service;

import com.example.webblog.model.FolderModel;

public interface IFolderService {
    FolderModel create(FolderModel model);
    void read(FolderModel model);
    void update(FolderModel model);
    void delete(FolderModel model);
}
