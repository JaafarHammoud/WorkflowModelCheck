package com.sysu.workflow.modelcheck;

import java.io.*;

/**
 * User：ThinerZQ
 * Email：thinerzq@gmail.com
 * Date：2017/1/10 11:26
 * Project：WorkflowModelCheck
 * Package：com.sysu.workflow.modelcheck
 */
public class Temp {
    public static void main(String[] args) {
        try {
            File file = new File("E:\\WorkSpace\\Idea\\WorkflowModelCheck\\src\\main\\resources\\1500.txt");
            FileOutputStream china = new FileOutputStream("chinese.txt");
            FileOutputStream english = new FileOutputStream("english.txt");
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), "gbk");//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int i = 0;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if (i % 2 == 0) {
                        english.write(("<s> " + lineTxt + " </s>\n").getBytes("gbk"));
                    } else {
                        china.write((lineTxt + "\n").getBytes("gbk"));
                    }
                    i++;
                }
                read.close();
                china.close();
                english.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }
}
