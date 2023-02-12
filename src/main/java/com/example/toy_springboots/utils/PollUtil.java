package com.example.toy_springboots.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class PollUtil {
    public String getUniqueSeqence(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public List fileUpload(MultipartHttpServletRequest multipartHttpServletRequest, HashMap<String, Object> params) throws IllegalStateException, IOException{
        Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();
        
        String relativePath = "C:\\Develops\\toy_springboots\\src\\main\\resources\\static\\files\\";
        List attachFiles = new ArrayList();
        Map attachFile = null;
        String physicalFileName = getUniqueSeqence();
        String storePath = relativePath + physicalFileName + "\\";
        File newPath = new File(storePath);
        newPath.mkdir();
        while(fileNames.hasNext()){
            String fileName = fileNames.next();
            MultipartFile multipartFile = multipartHttpServletRequest.getFile(fileName);
            String originalFileName = multipartFile.getOriginalFilename();

            String storePathFileName = storePath + originalFileName;
            multipartFile.transferTo(new File(storePathFileName));
            attachFile = new HashMap<>();
            attachFile.put("ATTACHFILE_SEQ", getUniqueSeqence());
            attachFile.put("SOURCE_UNIQUE_SEQ", params.get("USER_UID"));
            attachFile.put("ORGINALFILE_NAME", originalFileName);
            attachFile.put("PHYSICALFILE_NAME", physicalFileName);
            attachFile.put("REGISTER_SEQ", params.get("REGISTER_SEQ"));
            attachFile.put("MODIFIER_SEQ", params.get("MODIFIER_SEQ"));
            attachFiles.add(attachFile);
        }
        return attachFiles;
    }
}
