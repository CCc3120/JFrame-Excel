package com.bingo.xls.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.bingo.xls.main.ContainerManage;

public class ExcelUtil {

    public static File file;

    private static long end_ = 1;

    public static void operFile() {
        FileOutputStream fos = null;

        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
            DataEntityList entityList = readDataEntitys(workbook);

            writeData(entityList, workbook);

            String newName = file.getName().substring(0, file.getName().indexOf(".")) + "-处理后" +
                    file.getName().substring(file.getName().lastIndexOf("."));

            String fileName = getNewFileName(newName);

            String filePath = file.getAbsolutePath().replace(file.getName(), fileName);

            File newFile = new File(filePath);

            fos = new FileOutputStream(newFile);

            workbook.write(fos);

            ContainerManage.appendTextArea(OperLog.operLog("新文件名：" + fileName));
        } catch (IOException e) {
            ContainerManage.appendTextArea(OperLog.operLog("处理文件出错了┭┮﹏┭┮"));
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private static String getNewFileName(String fileName) {
        String filePath = file.getAbsolutePath().replace(file.getName(), fileName);
        File newFile = new File(filePath);
        if (newFile.exists()) {
            String newName = file.getName().substring(0, file.getName().indexOf(".")) + "-处理后" +
                    "（" + end_ + "）" + file.getName().substring(file.getName().lastIndexOf("."));

            end_++;
            return getNewFileName(newName);
        } else {
            end_ = 1;
            return fileName;
        }
    }

    private static void writeData(DataEntityList entityList, HSSFWorkbook workbook) {
        entityList.initData();

        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        HSSFSheet sheet = workbook.getSheetAt(0);
        int end_row = sheet.getLastRowNum();
        HSSFRow row = sheet.createRow(end_row + 2);

        HSSFCell cell0 = row.createCell(0);
        cell0.setCellStyle(cellStyle);

        HSSFCell cell1 = row.createCell(1);
        cell1.setCellStyle(cellStyle);

        HSSFCell cell2 = row.createCell(2);
        cell2.setCellStyle(cellStyle);
        cell2.setCellValue(entityList.getFdBuyTotalMoney());

        HSSFCell cell3 = row.createCell(3);
        cell3.setCellStyle(cellStyle);

        HSSFCell cell4 = row.createCell(4);
        cell4.setCellStyle(cellStyle);

        HSSFCell cell5 = row.createCell(5);
        cell5.setCellStyle(cellStyle);
        cell5.setCellValue(entityList.getFdSellTotalMoney());

        HSSFCell cell6 = row.createCell(6);
        cell6.setCellStyle(cellStyle);
        cell6.setCellValue(entityList.getFdNewPrice());

        HSSFCell cell7 = row.createCell(7);
        cell7.setCellStyle(cellStyle);
        cell7.setCellValue(entityList.getFdHaveNum());

        HSSFCell cell8 = row.createCell(8);
        cell8.setCellStyle(cellStyle);
        cell8.setCellValue(entityList.getFdMoney());

        HSSFCell cell9 = row.createCell(9);
        cell9.setCellStyle(cellStyle);
        cell9.setCellValue(entityList.getFdProfit());

    }

    private static DataEntityList readDataEntitys(HSSFWorkbook workbook) {
        HSSFSheet sheet = workbook.getSheetAt(0);
        int begin_row = 1;
        int end_row = sheet.getLastRowNum();
        int begin_col = 0;
        int end_col = 4;

        DataEntityList entityList = new DataEntityList();
        for (int i = begin_row; i <= end_row; i++) {
            HSSFRow row = sheet.getRow(i);
            DataEntity buy = new DataEntity();
            DataEntity sell = new DataEntity();
            for (int j = begin_col; j <= end_col; j++) {
                HSSFCell cell = row.getCell(j);
                if (cell == null) {
                    continue;
                }
                String value = cell.toString().trim();
                if (value == null || "".equals(value) || value.length() == 0) {
                    continue;
                }
                switch (j) {
                    case 0:
                        buy.setFdPrice(Double.parseDouble(value));
                        break;
                    case 1:
                        buy.setFdNum(Double.valueOf(value).longValue());
                        break;
                    case 3:
                        sell.setFdPrice(Double.parseDouble(value));
                        break;
                    case 4:
                        sell.setFdNum(Double.valueOf(value).longValue());
                        break;
                    default:
                        break;
                }
            }
            entityList.getFdBuys().add(buy);
            entityList.getFdSells().add(sell);
        }
        return entityList;
    }
}
