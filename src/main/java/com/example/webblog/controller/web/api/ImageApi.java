package com.example.webblog.controller.web.api;

import com.example.webblog.model.FolderModel;
import com.example.webblog.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

@WebServlet(urlPatterns = {"/image"})
public class ImageApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String filename = req.getParameter("filename");
        File file = null;
        if ("avatar".equals(type)) {
            file = new File("/home/gnuh/Pictures/ProjectFileUpload/WebBlog/UserAvatar", filename);
            resp.setHeader("Content-Type", getServletContext().getMimeType(filename));
            resp.setHeader("Content-Length", String.valueOf(file.length()));
            resp.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
            Files.copy(file.toPath(), resp.getOutputStream());
            return;
        }

        if ("folder".equals(type)) {
            Object obj = req.getSession().getAttribute("UserModel");
            UserModel curr = (UserModel) obj;
            if (obj == null) {
                return; // trang bao loi than thien
            }
            String folderPath = req.getParameter("folderPath");

            FolderModel image = new FolderModel();
            image.setFolderPath(folderPath);
            image.setUserId(curr.getId());

            file = new File(image.getRealFolderPath(), filename);
            resp.setHeader("Content-Type", getServletContext().getMimeType(filename));
            resp.setHeader("Content-Length", String.valueOf(file.length()));
            resp.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
            Files.copy(file.toPath(), resp.getOutputStream());
        }
    }

}
