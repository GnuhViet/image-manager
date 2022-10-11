package com.example.webblog.utils;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

public class ImageUtil {

    public static String saveUserImage(Long id, String base64Image) {
        char ex = base64Image.charAt(0);
        String extension;
        switch (ex) {
            case '/':
                extension = "jpg";
                break;
            case 'i':
                extension = "png";
                break;
            default:
                return null;
        }

        String fileName = id + "Avatar." + extension;
        File file = new File("/home/gnuh/Pictures/ProjectFileUpload/WebBlog/UserAvatar/" + fileName);
        OutputStream outputStream;
        ImageOutputStream ioStream = null;

        try {
            outputStream = Files.newOutputStream(file.toPath());
            ioStream = ImageIO.createImageOutputStream(outputStream);
            ImageIO.write(toImage(base64Image), extension, ioStream);
        } catch (IOException e) {
            return null;
        } finally {
            try {
                ioStream.flush();
                ioStream.close();
            } catch (IOException | NullPointerException ignore) {
            }
        }
        return file.getName();
    }

    private static BufferedImage toImage(String base64Image) throws IOException {
        byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
        return ImageIO.read(new ByteArrayInputStream(imageBytes));
    }
}
