package com.baseframe.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.baseframe.service.UploadPicService;
import com.baseframe.util.SystemConfigBean;

/**
 * this service is only a class for training upload picture
 * If anytime you want to exercise, you can delete which you had write,anyone of them
 * 
 * @author koala
 * @since 2017年9月4日
 */
@Service
public class UploadPicServiceImpl implements UploadPicService {

    @Resource
    private SystemConfigBean systemConfigBean;
    
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
            if (null != myFile) {
                String fileName = myFile.getOriginalFilename();
                if(fileName.trim() != "") {
                    String suffix = fileName.substring(fileName.indexOf("."));
                    String newFile = newName(suffix);
                    String filePath = systemConfigBean.getImgPath() + newFile;
                    String localPath = systemConfigBean.getImgPath();
                    File local = new File(localPath);//生产文件夹的路径，不包含图片
                    File f = new File(filePath);
                    try {
                        if (!local.exists()){
                            local.mkdirs();
                        }
                        myFile.transferTo(f);//图片保存的真实路径，包含图片
                        return filePath;
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    private static String newName(String suffix) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        Random r = new Random();
        int next = r.nextInt(100);
        return newDate + next + suffix;
    }
    
    public static void main(String[] args) {
//        String suffix = ".jpg";
//        System.out.println(newName(suffix));
    }
    
    //该方法比较清晰，建议保留
    public String uploadPic2(HttpServletRequest request) {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (!multipartResolver.isMultipart(request)) {
            return null;
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
        Iterator<String>it = multipartRequest.getFileNames();
        while (it.hasNext()) {
            MultipartFile myFile = multipartRequest.getFile(it.next());
            if (null != myFile) {
                String file = myFile.getOriginalFilename();
                if (file.trim()!="") {
                    String suffix = file.substring(file.lastIndexOf("."));
                    String newName = newName(suffix);//file name
                    String path = systemConfigBean.getImgPath() + newName;
                    File local = new File(systemConfigBean.getImgPath());
                    File f = new File(path);
                    try {
                        // 判断不存在创建的时候排除图片，保留文件夹
                        // 虽然按照指定的方式创建了，但是在路径上并没有指明磁盘，他是如何找到的？？莫非是项目工作空间默认？？暂且这么理解吧
                        if (!local.exists()) {
                            local.mkdirs();
                        }
                        myFile.transferTo(f);//保存文件到真实路径包含图片
                        return path;
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public String uploadPic3(HttpServletRequest request) {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (!multipartResolver.isMultipart(request)) {
            return null;
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
        Iterator<String> it = multipartRequest.getFileNames();
        while (it.hasNext()) {
            MultipartFile requestFile = multipartRequest.getFile(it.next());
            if (requestFile != null) {
                String fileName = requestFile.getOriginalFilename();
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                String newName = newName(suffix);
                String path = systemConfigBean.getImgPath() + newName;
                File local = new File(systemConfigBean.getImgPath());
                File f = new File(path);
                try {
                    if (!local.exists()) {
                        local.mkdirs();
                    }
                    requestFile.transferTo(f);
                    return path;
                }
                catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }
        return null;
    }

    public String uploadPic4(HttpServletRequest request) {
        //没有什么东西是一蹴而就的
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (!multipartResolver.isMultipart(request)) {
            return null;
        }
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Iterator<String> it = multipartHttpServletRequest.getFileNames();
        while (it.hasNext()) {
            MultipartFile requestFile = multipartHttpServletRequest.getFile(it.next());
            if (null != requestFile) {
                String fileName = requestFile.getOriginalFilename();
                if (!fileName.isEmpty()) {
                    String suffix = fileName.substring(fileName.lastIndexOf("."));
                    String newName = newName(suffix);
                    String path = systemConfigBean.getImgPath()+newName;
                    File local = new File(systemConfigBean.getImgPath());
                    File f = new File(path);
                    try {
                        if (!local.exists()) {
                            local.mkdirs();
                        }
                        requestFile.transferTo(f);
                        return path;
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public String uploadPic5(HttpServletRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
}
