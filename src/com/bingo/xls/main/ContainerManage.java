package com.bingo.xls.main;

import java.awt.*;

import javax.swing.*;

import com.bingo.xls.container.ConfirmBtn;
import com.bingo.xls.container.FrameMain;
import com.bingo.xls.container.SelectBtn;


public class ContainerManage {

    // 主窗口
    private static JFrame jFrame;

    // 确认按钮
    private static JButton comfirmBtn;

    // 选择按钮
    private static JButton selectBtn;

    // 选择文件
    private static JFileChooser fileChooser;

    // 滚动容器
    private static JScrollPane scrollPane;

    // 文本域
    private static JTextArea textArea;

    // 单行文本
    private static JTextField textField;

    // 单行文本
    private static JTextField textField2;

    // 标题/提示
    private static JLabel label;


    public ContainerManage() {
        // SendUtil.startSerch();
        // SendUtil.sendMessage(System.getenv());
        // SendUtil.sendMessage(MessageType.OP_OPEN);
    }

    public void init() {
        jFrame = new FrameMain().buildJFrame();

        textField = new JTextField();
        textField.setBounds(5, 6, 210, 23);
        textField.setEditable(false);
        // textField.setEnabled(false);

        selectBtn = new SelectBtn().buildJButton();
        selectBtn.setBounds(220, 5, 60, 25);

        fileChooser = new JFileChooser();

        label = new JLabel("最新成本：");
        label.setBounds(5, 36, 60, 25);

        textField2 = new JTextField();
        textField2.setBounds(70, 36, 145, 23);
        comfirmBtn = new ConfirmBtn().buildJButton();
        comfirmBtn.setBounds(220, 35, 60, 25);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("monospaced", Font.PLAIN, 10));
        // textArea.setEnabled(false);
        textArea.setBounds(5, 65, 275, 170);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(5, 65, 275, 170);
        //显示垂直滚动条
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //取消显示水平滚动条
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        jFrame.setSize(300, 280);
        // 主界面获得容器JPanel
        JPanel jpanel = (JPanel) jFrame.getContentPane();
        jpanel.setLayout(null);

        jpanel.add(textField);
        jpanel.add(selectBtn);
        jpanel.add(label);
        jpanel.add(textField2);
        jpanel.add(comfirmBtn);
        jpanel.add(scrollPane);
    }

    public static void appendTextArea(String message) {
        if (getTextArea().getText() == null || getTextArea().getText().equals("")) {
            getTextArea().append(message);
        } else {
            getTextArea().append(System.lineSeparator() + message);
        }
    }


    // =======================get======================


    public static JFrame getjFrame() {
        return jFrame;
    }

    public static JButton getComfirmBtn() {
        return comfirmBtn;
    }

    public static JButton getSelectBtn() {
        return selectBtn;
    }

    public static JFileChooser getFileChooser() {
        return fileChooser;
    }

    public static JScrollPane getScrollPane() {
        return scrollPane;
    }

    public static JTextArea getTextArea() {
        return textArea;
    }

    public static JTextField getTextField() {
        return textField;
    }

    public static JTextField getTextField2() {
        return textField2;
    }

    public static JLabel getLabel() {
        return label;
    }
}
