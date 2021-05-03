package com.converter.pdfConverter;

import com.converter.utils.FileUtils;
import org.jodconverter.OfficeDocumentConverter;
import org.jodconverter.office.DefaultOfficeManagerBuilder;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author glacier
 * @version v1.0.0
 * @Date 2017-08-03  21:17:35
 */
public abstract class AbstractOpenOfficePDFConverter implements PDFConverter {

    private static OfficeManager officeManager;
    private static String OFFICE_HOME = "C:\\Program Files (x86)\\LibreOffice 5";
    private int port[] = {8100};

    public void convert2PDF(String inputFile, String pdfFile) {

        if (inputFile.endsWith(".txt")) {
            String odtFile = FileUtils.getFilePrefix(inputFile) + ".odt";
            if (new File(odtFile).exists()) {
                System.out.println("odt文件已存在！");
                inputFile = odtFile;
            } else {
                try {
                    FileUtils.copyFile(inputFile, odtFile);
                    inputFile = odtFile;
                } catch (FileNotFoundException e) {
                    System.out.println("文档不存在！");
                    e.printStackTrace();
                }
            }
        }

        startService();
        System.out.println("进行文档转换转换:" + inputFile + " --> " + pdfFile);
        OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
        try {
            converter.convert(new File(inputFile), new File(pdfFile));
        } catch (OfficeException e) {
            e.printStackTrace();
        }
        stopService();
        System.out.println();
    }

    public void convert2PDF(String inputFile) {
        String pdfFile = FileUtils.getFilePrefix(inputFile) + ".pdf";
        convert2PDF(inputFile, pdfFile);

    }

    public void startService() {
        if (officeManager != null) {
            return;
        }

        DefaultOfficeManagerBuilder officeManagerBuilder = new DefaultOfficeManagerBuilder();

        officeManagerBuilder.setOfficeHome(getOfficeHome());//设置OpenOffice.org安装目录
        officeManagerBuilder.setPortNumbers(port); //设置转换端口，默认为8100
        officeManagerBuilder.setTaskExecutionTimeout(1000 * 60 * 5L);//设置任务执行超时为5分钟
        officeManagerBuilder.setTaskQueueTimeout(1000 * 60 * 60 * 24L);//设置任务队列超时为24小时


        officeManager = officeManagerBuilder.build();
        try {
            System.out.println("准备启动服务....");
            officeManager.start();    //启动服务
            System.out.println("office转换服务启动成功!");
        } catch (OfficeException e) {
            System.out.println("office转换服务启动失败!详细信息:" + e);
        }
    }

    public void stopService() {
        System.out.println("关闭office转换服务....");
        if (officeManager != null && officeManager.isRunning()) {
            try {
                officeManager.stop();
            } catch (OfficeException e) {
                e.printStackTrace();
            }
        }
        System.out.println("关闭office转换成功!");
    }

    public static OfficeManager getOfficeManager() {
        return officeManager;
    }

    protected int[] getPort() {
        return port;
    }

    protected String getOfficeHome(){
        return "";
    }
}
