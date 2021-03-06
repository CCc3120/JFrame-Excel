package com.bingo.xls.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageUtil {

    /**
     * 裁剪PNG图片工具类
     *
     * @param fromFile     源文件
     * @param toFile       裁剪后的文件
     * @param outputWidth  裁剪宽度
     * @param outputHeight 裁剪高度
     * @param proportion   是否是等比缩放
     */
    public static void resizePng(File fromFile, File toFile, int outputWidth, int outputHeight,
            boolean proportion) {
        try {
            BufferedImage bi2 = ImageIO.read(fromFile);
            int newWidth;
            int newHeight;
            
            // 判断是否是等比缩放
            if (proportion) {
                double rate1 = ((double) bi2.getWidth()) / outputWidth;
                double rate2 = ((double) bi2.getHeight()) / outputHeight;
                // 根据缩放比率大的进行缩放控制 > 小 < 大
                double rate = rate1 > rate2 ? rate1 : rate2;
                newWidth = (int) ((bi2.getWidth()) / rate);
                newHeight = (int) ((bi2.getHeight()) / rate);
            } else {
                newWidth = outputWidth; // 输出的图片宽度
                newHeight = outputHeight; // 输出的图片高度
            }
             
            BufferedImage to = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = to.createGraphics();
            to = g2d.getDeviceConfiguration().createCompatibleImage(newWidth, newHeight,
                    Transparency.TRANSLUCENT);
            g2d.dispose();
            g2d = to.createGraphics();
            Image from = bi2.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_AREA_AVERAGING);
            g2d.drawImage(from, 0, 0, null);
            g2d.dispose();
            ImageIO.write(to, "png", toFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
