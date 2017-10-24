package com.baseframe.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baseframe.service.PoiService;
import com.baseframe.util.SystemConfigBean;

@Service
public class PoiServiceImpl implements PoiService {

    private static final Logger log = LoggerFactory.getLogger(PoiServiceImpl.class);
    
    @Resource
    private SystemConfigBean systemConfigBean;
    
    /**
     * 下载excel的模板，只是一个样例
     * 
     * 什么是POI
     * poi是Apache的一种流行的API，它允许程序员使用Java程序，修改和显示MS Office文件，
     * 这有Apache软件基金会开发使用Java分布式设计或修改Microsoft Office文件的开源库。它
     * 包含类和方法对用户输入数据或文件到MS Office文档进行解码
     * @return
     * 
     * @see com.baseframe.service.PoiService#downloadExcel()
     * 
     * @author zbw
     * @since 2017年10月24日
     */
    @Override
    public String downloadExcel() {
        /**
         * 从下面的结构可以看出，实际上前面的格式名都是统一的，
         * 唯独后面的单词，用在了如：行、列、表这些不同的内容上，所以
         * 我们操作的主要还是这些行、列、表格、样式什么的
         */
        HSSFWorkbook wb = new HSSFWorkbook();
        
        HSSFSheet sheet = wb.createSheet();
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        String [] titles = {"昵称","职业","阵营","天赋","公会"};
        //如果不确定你给定的集合依据什么获取他的长度，可以先使用创建好的titles数组长度，
        //如果本身使用上传的模板，那么请忽略这种创建方式
        HSSFCell cell = null;
        for (int i = 0; i < titles.length; i++) {//数组是有长度属性的，但是没有length方法
            sheet.setColumnWidth(i, 3500);
            cell = row.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(style);
        }
        //上面创建第一行完事儿了，title的每一列也完事儿了，根据这个基本上你拿出数据应该是可以
        //创建你需要的excel的
        //我现在遇到的问题是如果确定输出路径，涉及到nginx，这里我没有学习过
        //也可能是本身项目当中的文件夹比较复杂，所以容易让新手产生误解吧，我试试
        //总之尽量往简单了写，能看懂最重要
        String excelPath = systemConfigBean.getOrderModelPath();
        String realPath = excelPath + new Random().nextInt(100) + "-记录.xls";
        /**
         * 还有一点，那就是要把文件输出，所以会用到FileOutputStream
         * 但是有一点我不明白，这个路径跟POI没有发生任何联系，这表格怎么出来的呢？
         * 这个问题没有解决
         */
        /**
         * 不过这个问题解决了，就是excelpath实际上就是要存储在本地的文件的具体路径，应该是绝对路径
         * 如果该路径不存在的话，那么使用mkdirs方法向下递归创建一整个文件夹组，比如当前项目的:/mnt/xxxx/order/
         * 不过有一点，这一点在上传图片的时候也遇到了，也就是创建文件夹的问题，这个创建文件夹的的确确是依据项目位置
         * 来创建的，也就是说baseframe在本地磁盘的位置时E盘，所以创建文件夹的时候也默认在E盘创建了，害的我在D盘看了半天
         * 以为是我程序写错了。。
         */
        File file = new File(excelPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(realPath);//执行到这里的时候也确实在本地文件夹当中出现了需要的内容
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        try {
            wb.write(fileOut);
        }
        catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }finally {
            wb = null;
            try {
                fileOut.flush();
                fileOut.close();
            }
            catch (IOException e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        /**
         * 上面的本地文件夹位置问题解决了，剩下的那肯定是nginx的问题了，因为点击按钮执行程序之后发现本地文件夹
         * 下已经确实有excel了，这回不是控制台报错了，而是浏览器报错了，应该是他没办法解析nginx的路径吧
         * nginx.conf配置文件当中server的location里的root是D:/mnt/eauto100-statics;所以他只会去D盘找
         * 而这个root还不是全路径，需要加上realPath截取后半段之后在拼接起来才可以
         * 
         * nginx学学再回来看吧，这里按照原来项目当中写的，但是不对
         */
        String filePath = realPath.substring(realPath.indexOf("/order"));
        filePath = systemConfigBean.getDomain() + filePath;
        return filePath;
    }
    
}
