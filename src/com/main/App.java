package com.main;
import com.automator.SikuliAutomator;
import com.bll.AutomationManager;
import com.dal.ExcelDataReader;
import com.ui.MainWindow;


public class App {
    public static void main(String[] args) throws Exception {
        ExcelDataReader excelDataReader=new ExcelDataReader();
        AutomationManager automationManager=new AutomationManager(excelDataReader);
        SikuliAutomator sikuliAutomator=new SikuliAutomator();
        MainWindow window=new MainWindow(automationManager,sikuliAutomator);
        window.setVisible(true);
    }
}
