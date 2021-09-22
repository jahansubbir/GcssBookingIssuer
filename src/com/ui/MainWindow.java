package com.ui;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.automator.SikuliAutomator;
import com.bll.AutomationManager;
import com.models.Bl;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class MainWindow extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 4103328779266195566L;
    private AutomationManager automationManager;
    private SikuliAutomator robot;

    public MainWindow(AutomationManager automationManager, SikuliAutomator robot) {
        super();
        this.automationManager = automationManager;
        this.robot = robot;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Booking Issuer (GCSS) 1.0");

        setBounds(500, 700, 600, 200);
        add(getPanel());
        // this.add(getFileNameLabel());
        setVisible(true);

    }

    public JTable getTable() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("BL No");
        table = new JTable(tableModel);
         Point runButtonLocation = runButton.getLocation();
        
        table.setBounds((int) runButtonLocation.getX(), (int) runButtonLocation.getY() + 80, 250,
                this.panel.getHeight() - (int) runButtonLocation.getY() - 20);

        // table.addColumn(tableModel);

        return table;
    }

    public JFileChooser getFileChooser() {
        fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this.panel);
        if (option == JFileChooser.APPROVE_OPTION) {
            String fileName = fileChooser.getSelectedFile().getPath();
            fileTextBox.setText(fileName);
        }
        return fileChooser;
    }

    private void hideThisForm(){
    	this.hide();
    }
    public JButton getRunButton() {
        runButton = new JButton("Run");

        runButton.setBounds(((int) fileTextBox.getLocation().getX()), (int) fileTextBox.getLocation().getY() + 40,
                fileTextBox.getWidth(), 30);
        runButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
            	
                Thread thread=new Thread(new Runnable(){

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                    	hideThisForm();
                        printBl();   
                        JOptionPane.showMessageDialog(null, "Done!");     
                    }
                    
                });
                thread.start();
           
            }
                // table.setModel(model);
            

        });
        return runButton;
    }
    private void printBl(){
        String fileName=fileTextBox.getText();
        LinkedList<Bl> list=automationManager.getBlList(fileName);
        robot.printBls(list);
    }

    public JButton getBrowseButton() {
        browseButton = new JButton("Browse");
        browseButton.setBounds(300, 30, 80, 20);
        browseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                getFileChooser();
            }

        });
        return browseButton;
    }

    public JTextField getFileTextBox() {
        fileTextBox = new JTextField();
        fileTextBox.setBounds(80, 30, 200, 20);
        return fileTextBox;
    }

    public JPanel getPanel() {
        this.panel = new JPanel();
        panel.setBounds(0, 0, 500, 200);
        panel.setLayout(null);

        panel.add(getFileNameLabel());
        panel.add(getFileTextBox());
        panel.add(getBrowseButton());
        // panel.add(getFileChooser());
        panel.add(getRunButton());
        panel.add(getTable());
        return panel;
    }

    public JLabel getFileNameLabel() {
        fileNameLabel = new JLabel();
        fileNameLabel.setBounds(40, 30, 50, 20);
        fileNameLabel.setText("File");
        return fileNameLabel;
    }

    private JLabel fileNameLabel;
    private JTextField fileTextBox;
    private JPanel panel;
    private JButton browseButton, runButton;
    private JFileChooser fileChooser;
    private JTable table;

}
