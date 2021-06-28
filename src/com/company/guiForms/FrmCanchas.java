package com.company.guiForms;

import com.company.database.DataBase;
import com.company.clases.Cancha;
import com.company.clases.CanchaTipo;
import com.company.clases.StatusCancha;
import com.company.clases.LocalDeCanchas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FrmCanchas extends JFrame {
    private JPanel panel1;
    private JTextField txt_CanchaNumber;
    private JLabel lblCanchaNumber;
    private JLabel lblCanchaType;
    private JLabel lblEstate;
    private JPanel pnlDataCancha;
    private JPanel pnlListCancha;
    private JTable table;
    private JButton acceptButton;
    private JButton btnCancel;
    private JButton btnExit;
    private JComboBox cmbCancha;
    private JComboBox cmbStatus;
    private JLabel lblmotivo;
    private JTextField txtmotivo;
    private JButton btnListar;
    private JComboBox cmbListar;

    private JFrame frame;

    public FrmCanchas(JFrame frame) {

        LocalDeCanchas localDeCanchas = new LocalDeCanchas();
        this.frame = frame;
        cmbCancha.addItem("Papi");
        cmbCancha.addItem("Paddel");
        cmbCancha.addItem("Tenis");
        cmbStatus.addItem("Available");
        cmbStatus.addItem("UnAvailable");
        cmbListar.addItem("All");


        txtmotivo.setEnabled(false);
        CanchaTableModel tableModel = new CanchaTableModel();
        tableModel.setList(DataBase.getListCancha());
        table.setModel(tableModel);

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

        acceptButton.addActionListener(new ActionListener() {
            Cancha cancha;

            @Override
            public void actionPerformed(ActionEvent e) {



                int canchaNumber = Integer.parseInt(txt_CanchaNumber.getText());

                CanchaTipo type = new CanchaTipo((String) cmbCancha.getSelectedItem());


                CanchaTipo typeCancha = new CanchaTipo((String) cmbCancha.getSelectedItem());
                StatusCancha status;
                if (cmbStatus.getSelectedItem().equals("Available")) {
                    status = new StatusCancha(true, "--");
                } else {
                    status = new StatusCancha(false, txtmotivo.getText().toString());
                }


                cancha = new Cancha(canchaNumber, typeCancha, status);


                if (DataBase.canchaSave(cancha)) {

                    JOptionPane.showMessageDialog(null, "Load Succesfuly", "Message", JOptionPane.INFORMATION_MESSAGE);
                    tableModel.setList(DataBase.getListCancha());

                } else {

                    JOptionPane.showMessageDialog(null, "Error loading", "Message", JOptionPane.WARNING_MESSAGE);

                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionado = (String) cmbListar.getSelectedItem();
                if (seleccionado.equals("Available")) {

                    tableModel.setList(localDeCanchas.listCanchaAvailable());
                } else if (seleccionado.equals("UnAvailable")) {
                    tableModel.setList(localDeCanchas.listCanchaUnAvailable());
                } else {
                    tableModel.setList(DataBase.getListCancha());
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
    private boolean Validar(int fila, int columna){
        String valor;
        if(table.getValueAt(fila, columna)== null){
            System.out.println("Error, el valor es nulo");
            return  false;
        }else{
            valor= (String) table.getValueAt(fila,columna);
            System.out.println("El valor no es nulo");
            return true;
        }
    }

    public static void main(String[] args) {


       JFrame frame = new JFrame("Cancha");
        frame.setContentPane(new FrmCanchas(frame).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
