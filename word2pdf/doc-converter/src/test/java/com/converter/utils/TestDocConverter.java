package com.converter.utils;

import com.converter.pdfConverter.AbstractOpenOfficePDFConverter;
import com.converter.pdfConverter.LibreOfficePDFConverter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class TestDocConverter {

    private static final int max = 1;
    private static final String dir = "D:\\works";
    private static final String fileName = "test";
    private static final String docx = ".docx";
    private static final String xlsx = ".xls";
    private static final String pptx = ".ppt";
    private static final String pdf = ".pdf";

    public static void main(String[] args) {
        copyFile();

        List<Future<String>> list = new ArrayList<>();
        final AbstractOpenOfficePDFConverter officePDFConverter = new LibreOfficePDFConverter();
        officePDFConverter.startService();
        ExecutorService executorService = Executors.newFixedThreadPool(max);
        final Random random = new Random();
        for (int i = 0; i < max; i++) {
            int finalI = i;
            Future<String> future = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {

                    System.out.println("线程：\t" + finalI + "\t开始");
                    Thread.sleep(5000);
                    File src = new File(dir, fileName + "_" + finalI + docx);
                    File des = new File(dir, fileName + "_" + finalI + pdf);
                    officePDFConverter.convert2PDF(src.getPath(), des.getPath());
                    System.out.println("线程：\t" + finalI + "\t结束");

                    return String.valueOf(random.nextInt(1000)) + "_" + finalI;
                }
            });
            list.add(future);
        }
        executorService.shutdown();
        for (int i = 0; i <list.size() ; i++) {
            try {
                System.out.println(list.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println("###############线程池关闭");
                officePDFConverter.stopService();
                break;
            }
            System.out.println("线程池未关闭");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copyFile() {
        // 复制文件
        File src = null;
        File des = null;
        for (int i = 0; i < max; i++) {
            try {
                src = new File(dir, fileName + docx);
                des = new File(dir, fileName + "_" + i + docx);
                FileUtils.deleteQuietly(des);
                FileUtils.copyFile(src, des);

//                src = new File(dir, fileName + xlsx);
//                des = new File(dir, fileName + "_" + i + xlsx);
//                FileUtils.deleteQuietly(des);
//                FileUtils.copyFile(src, des);
//
//                src = new File(dir, fileName + pptx);
//                des = new File(dir, fileName + "_" + i + pptx);
//                FileUtils.deleteQuietly(des);
//                FileUtils.copyFile(src, des);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
