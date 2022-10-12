package com.example.webblog.controller.web;

import com.example.webblog.model.APIResponseModel.JsonFolder;
import com.example.webblog.model.FolderModel;
import com.example.webblog.model.UserModel;
import com.example.webblog.service.IFolderService;
import com.example.webblog.utils.FormUtil;
import com.example.webblog.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/manage/file"})
public class FolderController extends HttpServlet {
    @Inject
    private IFolderService folderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/page-filemanage.jsp");

        Object obj = req.getSession().getAttribute("UserModel");
        UserModel curr = (UserModel) obj;
        if (obj == null) {
            return; // trang bao loi than thien
        }

        FolderModel readFolder = new FolderModel();
        readFolder.setFolderPath(req.getParameter("folderPath"));
        readFolder.setUserId(curr.getId());
        folderService.read(readFolder);
        req.setAttribute("FolderModel", JsonFolder.of(readFolder));

        dispatcher.forward(req, resp);
    }
}
