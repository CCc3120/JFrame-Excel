package com.bingo.xls.container;

import java.awt.event.MouseEvent;

import javax.swing.*;

import com.bingo.xls.common.ButtonMouseAdapter;
import com.bingo.xls.common.ConstantConfig;
import com.bingo.xls.main.ContainerManage;
import com.bingo.xls.util.ExcelUtil;
import com.bingo.xls.util.OperLog;

public class ConfirmBtn extends ButtonMouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        if (ExcelUtil.file == null) {
            ContainerManage.appendTextArea(OperLog.operLog("未选中文件！"));
            return;
        }

        String fileName = ExcelUtil.file.getName();
        String suff = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (!"xls".equals(suff) && !"xlsx".equals(suff)) {
            ContainerManage.appendTextArea(OperLog.operLog("请选择.xls或.xlsx文件！"));
            return;
        }

        String newPrice = ContainerManage.getTextField2().getText().trim();
        if ("".equals(newPrice) || newPrice.length() == 0) {
            ContainerManage.appendTextArea(OperLog.operLog("请填写最新成本值！"));
            return;
        }

        if (!OperLog.checkNumber(newPrice)) {
            ContainerManage.appendTextArea(OperLog.operLog("最新成本请填写数字！"));
            return;
        }

        ExcelUtil.operFile();
        ContainerManage.appendTextArea(OperLog.operLog("处理完成！"));
    }

    @Override
    public JButton buildJButton() {
        JButton jButton = new JButton(ConstantConfig.BTN_NAME_CONFIRM);

        // 设置文字居中
        jButton.setHorizontalTextPosition(SwingConstants.CENTER);

        jButton.addMouseListener(this);

        return jButton;
    }
}
