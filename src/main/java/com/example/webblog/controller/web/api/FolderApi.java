package com.example.webblog.controller.web.api;

import com.example.webblog.model.APIResponseModel.JsonFolder;
import com.example.webblog.model.FolderModel;
import com.example.webblog.model.UserModel;
import com.example.webblog.service.IFolderService;
import com.example.webblog.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-folder"})
public class FolderApi extends HttpServlet {
    @Inject
    private IFolderService folderService;

    private UserModel defaultConfig(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Object obj = req.getSession().getAttribute("UserModel");
        return (UserModel) obj; // thong bao dang nhap
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel curr = defaultConfig(req, resp);
        if (curr == null) {
            return;//
        }

        FolderModel readFolder = HttpUtil.of(req.getReader()).toModel(FolderModel.class);
        readFolder.setUserId(curr.getId());

        folderService.read(readFolder);

        new ObjectMapper().writeValue(resp.getOutputStream(), JsonFolder.of(readFolder));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel curr = defaultConfig(req, resp);
        if (curr == null) {
            return;//
        }

        FolderModel createModel = HttpUtil.of(req.getReader()).toModel(FolderModel.class);
        createModel.setUserId(curr.getId());

        folderService.create(createModel);

        new ObjectMapper().writeValue(resp.getOutputStream(), JsonFolder.of(createModel));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO rename
        UserModel curr = defaultConfig(req, resp);
        if (curr == null) {
            return;//
        }

        FolderModel updateModel = HttpUtil.of(req.getReader()).toModel(FolderModel.class);
        updateModel.setUserId(curr.getId());

        ObjectMapper mapper = new ObjectMapper();
        String updateMsg = null;

        switch (updateModel.getUpdateType()) {
            case copy:
            case move:
                req.getSession().setAttribute("updateModel", updateModel);
                updateMsg = "di chuyen den thu muc muon paste paste";
                break;
            case remove:
                folderService.deleteList(updateModel);
                break;
            case rename:
                updateMsg = folderService.rename(updateModel);
                break;
            case paste: {
                Object obj = req.getSession().getAttribute("updateModel");
                if (obj == null) {
                    break;
                }
                FolderModel oldModel = (FolderModel) obj;
                switch (oldModel.getUpdateType()) {
                    case copy:
                        folderService.copy(oldModel, updateModel);
                        break;
                    case move:
                        folderService.move(oldModel, updateModel);
                        break;
                    default:
                        break;
                }
                req.getSession().removeAttribute("updateModel");
                break;
            }
            default:
                updateMsg = "hanh dong khong hop le";
                break;
        }

        mapper.writeValue(resp.getOutputStream(), updateMsg);
        //TODO bam copy/move thi reload va co button paste
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel curr = defaultConfig(req, resp);
        if (curr == null) {
            return;//
        }

        FolderModel createModel = HttpUtil.of(req.getReader()).toModel(FolderModel.class);
        createModel.setUserId(curr.getId());

        folderService.delete(createModel);

        new ObjectMapper().writeValue(resp.getOutputStream(), JsonFolder.of(createModel));
    }
}
