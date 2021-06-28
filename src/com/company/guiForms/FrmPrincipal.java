package com.company.guiForms;

import com.company.clases.Admin;

import javax.swing.*;

import com.company.database.DataBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FrmPrincipal extends JFrame {
    public JPanel frmPrincipal;
    private JButton btnUser;
    private JButton btnCancha;
    private JLabel lblUser;
    private JComboBox comboBox;
    private Object FrnPrincipal;

    public FrmPrincipal() {

        comboBox.addItem("ADMIN");
        comboBox.addItem("CLIENT");
        comboBox.addItem("TURNO");
        comboBox.addItem("CANCHA");
        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    String seleccionado = (String) comboBox.getSelectedItem();
                    if (seleccionado.equals("ADMIN")) {
                        openUser();
                    } else if (seleccionado.equals("CLIENT")) {
                        openClient();
                    } else if (seleccionado.equals("TURNO")) {
                        openTurno();
                    } else {
                        openCancha();
                    }
                }
            }
        });


        Admin admin = DataBase.getUserLoggin(); /// Busco el usuario que se logeo
        lblUser.setText("WELCOME: " + admin.getUserName() + " " + "Puesto: " + admin.getRol().getDescription());

        if (admin.getRol().getDescription().equals("EMPLEADO")) {
            btnUser.setVisible(false);
            btnCancha.setVisible(false);

        }


        /*btnCancha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Cancha");
                frame.setContentPane(new FrmCanchas(frame).getPanel1());
                frame.pack();
                frame.setSize(1200, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });

        btnTurno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent event) {
                System.exit(WIDTH);
            }
        });

        btnClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Client");
                frame.setContentPane(new FrmClient(frame).Client);
                frame.pack();
                //frame.setSize(800,600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        btnUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Users");
                frame.setContentPane(new FrmUser(frame).jPanelUser);
                frame.pack();
                frame.setSize(1000, 700);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });

        btnTurno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("FrmTurno");
                frame.setContentPane(new frmTurno().pnlprincipal);
                frame.pack();
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }*/





        /*String [] listado= {"ADMIN", "CLIENT", "CANCHA", "TURNO"};
        comboBox.setSelectedIndex(0);
        openUser();
        add(comboBox);
        comboBox.setSelectedIndex(1);
        openClient();
        add(comboBox);
        comboBox.setSelectedIndex(2);
        openCancha();
        add(comboBox);
        comboBox.setSelectedIndex(3);
        openTurno();
        add(comboBox);

        cmbCancha.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    String seleccionado = (String) cmbCancha.getSelectedItem();
                    System.out.println(seleccionado);
                }

            }
        });
        cmbStatus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {

                    String seleccionado = (String) cmbStatus.getSelectedItem();
                    if (seleccionado.equals("UnAvailable")) {
                        txtmotivo.setEnabled(true);
                    }
                    System.out.println(seleccionado);
                }

            }
        });

    */
    }







    public void openUser(){
        JFrame frame = new JFrame("Users");
        frame.setContentPane(new FrmUser(frame).jPanelUser);
        frame.pack();
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void openClient(){

            JFrame frame = new JFrame("Client");
            frame.setContentPane(new FrmClient(frame).Client);
            frame.pack();
            //frame.setSize(800,600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);


    }

    public void openCancha(){

        JFrame frame = new JFrame("Cancha");
        frame.setContentPane(new FrmCanchas(frame).getPanel1());
        frame.pack();
        frame.setSize(1200, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

    public void openTurno(){

            JFrame frame = new JFrame("FrmTurno");
            frame.setContentPane(new frmTurno().pnlprincipal);
            frame.pack();
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);



    }



    public void closePrincipalForm() {
        this.setVisible(false);
        this.dispose();
    }

    public void setFrmPrincipal(JPanel frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Principal");
        frame.setContentPane(new FrmPrincipal().frmPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void createUIComponents() {

    }
}