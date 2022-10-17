package com.example.webblog.controller.web;

import com.example.webblog.model.APIResponseModel.JsonFolder;
import com.example.webblog.model.FolderModel;
import com.example.webblog.model.UserModel;
import com.example.webblog.service.IFolderService;

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
        Object obj = req.getSession().getAttribute("UserModel");
        UserModel curr = (UserModel) obj;
        if (obj == null) {
            return; // trang bao loi than thien
        }

        String folderPath = req.getParameter("folderPath");
        if (!folderPath.startsWith("home")) {
            resp.sendRedirect(req.getContextPath() + "/manage/file?folderPath=home");
            return;
        }

        if (folderPath.endsWith("/")) {
            StringBuilder sb = new StringBuilder(folderPath);
            while (sb.charAt(sb.length()-1) == '/') {
                sb.deleteCharAt(sb.length()-1);
            }
            folderPath = sb.toString();
            resp.sendRedirect(req.getContextPath() + "/manage/file?folderPath=" + folderPath);
            return;
        }

        FolderModel readFolder = new FolderModel();
        readFolder.setFolderPath(folderPath);
        readFolder.setUserId(curr.getId());
        if (!folderService.exist(readFolder)) {
            resp.sendRedirect(req.getContextPath() + "/manage/file?folderPath=home");
            return;
        }
        folderService.read(readFolder);

        req.setAttribute("FolderModel", JsonFolder.of(readFolder));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/page-filemanage.jsp");
        dispatcher.forward(req, resp);
    }
}
