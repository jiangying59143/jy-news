package com.jy.common.utils;

import io.swagger.annotations.*;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    public static final String UPLOAD_FILE_VIDEO = "video";

    public static final String UPLOAD_FILE_IMAGE = "image";

    public static boolean uploadVerificationCodeImage(byte[] b, String baseFolderPath, String type, String newFileName){
        try {
            File file = new File(baseFolderPath +  type + "/"  + newFileName);
            org.apache.commons.io.FileUtils.writeByteArrayToFile(file
                    , b);
        }catch(Exception e){
            log.error(newFileName + "file upload error", e);
            return false;
        }
        return true;
    }

    public static boolean singleFileUpload(MultipartFile file, String baseFolderPath, String type, Long userId, String newFileName){
        String fileName = file.getOriginalFilename();
        File userFile = new File(baseFolderPath + type + File.separator + userId);
        if(BooleanUtils.and(new boolean[]{userId !=null, !userFile.exists()}) ){
            userFile.mkdirs();
        }
        try {
            byte[] bytes = file.getBytes();
            org.apache.commons.io.FileUtils.writeByteArrayToFile(
                    new File(baseFolderPath + (StringUtils.isEmpty(type) ? "":type + File.separator)
                            + (userId == null ? "" : userId + File.separator)
                            + (StringUtils.isEmpty(newFileName)?fileName:newFileName)), bytes);
        }catch(Exception e){
            log.error(fileName + "file upload error", e);
            return false;
        }
        return true;
    }

    public static void deleteArticleTempFolder(String baseFolderPath, String type, Long userId, String fileName){
        File file = new File(baseFolderPath + type + File.separator
                + (userId == null ? "":userId + File.separator)
                + fileName );
        if(file.exists()){
            file.delete();
        }
    }

}
