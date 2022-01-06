package com.bingo.xls.container;

import java.awt.event.MouseEvent;

import javax.swing.*;

import com.bingo.xls.common.ButtonMouseAdapter;
import com.bingo.xls.common.ConstantConfig;
import com.bingo.xls.main.ContainerManage;
import com.bingo.xls.util.ExcelUtil;
import com.bingo.xls.util.OperLog;

public class SelectBtn extends ButtonMouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        int status = ContainerManage.getFileChooser().showOpenDialog(ContainerManage.getjFrame());
        if (status == JFileChooser.APPROVE_OPTION) {
            ExcelUtil.file = ContainerManage.getFileChooser().getSelectedFile();
            ContainerManage.getTextField().setText(ExcelUtil.file.getAbsolutePath());
            ContainerManage.appendTextArea(OperLog.operLog("选择文件：" + ExcelUtil.file.getAbsolutePath()));
        } else {
            ExcelUtil.file = null;
            ContainerManage.getTextField().setText("");
        }
    }

    @Override
    public JButton buildJButton() {
        JButton jButton = new JButton(ConstantConfig.BTN_NAME_SELECT);

        // 设置文字居中
        jButton.setHorizontalTextPosition(SwingConstants.CENTER);

        // 动作事件改到鼠标点击事件中
        jButton.addMouseListener(this);

        return jButton;
    }
}
