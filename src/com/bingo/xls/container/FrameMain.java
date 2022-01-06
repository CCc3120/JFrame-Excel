package com.bingo.xls.container;

import java.awt.*;

import javax.swing.*;

import com.bingo.xls.common.ConstantConfig;
import com.bingo.xls.common.JFrameAdapter;

public class FrameMain extends JFrameAdapter {

    @Override
    public JFrame buildJFrame() {
        initUI();

        JFrame jFrame = new JFrame(ConstantConfig.FRAME_TITLE);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // 设置左上角图标
        jFrame.setIconImage(toolkit.getImage(ConstantConfig.ICON_PATH));
        // 显示在屏幕中央
        jFrame.setLocationRelativeTo(null);
        // 窗口大小不可变
        jFrame.setResizable(false);
        // 关闭按钮
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置可见
        jFrame.setVisible(true);
        return jFrame;
    }

    private void initUI() {
        try {
            // 设置当前系统默认风格
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("OptionPane.minimumSize", new Dimension(320, 108));
        } catch (ClassNotFoundException
                | UnsupportedLookAndFeelException
                | InstantiationException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
