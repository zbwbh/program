package com.baseframe.service.impl;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.baseframe.service.UploadPicService;

@Service
public class UploadPicServiceImpl implements UploadPicService {

    public String uploadPic(HttpServletRequest request) {
        // I write this for at least three times.Then I know some detail of it.
        // First:Begin get CommonsMultipartResolver 
        // Then determine if it contains a request
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (!multipartResolver.isMultipart(request)) {
            return null;
        }
        // Second:Through the judge.If it contains a request.
        // You should multipart the requst
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
        Iterator<String> it = multipartRequest.getFileNames();
        while (it.hasNext()) {
            // Third:multipart the File
            // Stepwise analysis//英文翻译逐步分析，我的原意是逐层解析
            MultipartFile myFile = multipartRequest.getFile(it.next());
            System.out.println("在这里");
            System.out.println(myFile);
        }
        return null;
    }

}
