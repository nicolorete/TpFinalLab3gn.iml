package com.company.guiForms;

import com.company.database.DataBase;
import com.company.clases.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class addTurno extends JFrame {
    public JPanel Turno;
    private JComboBox cmbClientes;
    private JPanel jpanel1;
    private JPanel jpanel2;
    private JComboBox cmbCancha;
    private JButton addCanchaButton;
    private JTextArea txtAreaCancha;
    private JButton btnAceptar;
    private JButton btnViewCanchas;
    private JButton btnAddClient;
    private JPanel pnldate1;
    private JPanel pnldate2;
    private JPanel pnldate;

    public ArrayList<Client> listClients = new ArrayList<Client>();
    public ArrayList<Cancha> listCanchas = new ArrayList<Cancha>();
    public JDateChooser dentrada;
    public JDateChooser dsalida;
    public LocalDeCanchas localDeCanchas;
    public Date fechaEntrada;
    public Date fechaSalida;
    JFrame myFrame;

    public addTurno(JFrame frame) {

        myFrame = frame;
        localDeCanchas = new LocalDeCanchas();

        dentrada = new JDateChooser();
        dsalida = new JDateChooser();
        jpanel2.add(dentrada);
        jpanel1.add(dsalida);

        for (Client cli : DataBase.getListClient()) {
            cmbClientes.addItem(cli);
        }


        addCanchaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmbCancha.getSelectedItem() != null) {
                    Cancha cancha = ((Cancha) cmbCancha.getSelectedItem());
                    listCanchas.add(cancha);
                    txtAreaCancha.append(cancha.toString() + "\n");
                }
            }
        });
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin admin = DataBase.getUserLoggin();

                fechaEntrada = dentrada.getDate();
                if(!validarFecha(dentrada)){
                    JOptionPane.showMessageDialog(null, "No puede ingresar fecha anterior a la actual");
                }
                fechaSalida = dsalida.getDate();
                if(!validarFecha(dsalida)){
                    JOptionPane.showMessageDialog(null, "No puede ingresar fecha anterior a la actual");
                }
                Client client = ((Client) cmbClientes.getSelectedItem());

                Turno turno = new Turno(admin, client, fechaEntrada, fechaSalida, listCanchas, listClients);
                if(validarFecha(dentrada) && validarFecha(dsalida)){
                    DataBase.turnoSave(turno);
                }



            }
        });
        btnViewCanchas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechaEntrada = dentrada.getDate();
                fechaSalida = dsalida.getDate();

                cmbCancha.removeAllItems();
                for (Cancha cancha : localDeCanchas.listCanchaAvailableDates(fechaEntrada, fechaSalida)) {
                    cmbCancha.addItem(cancha);
                }
            }
        });

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
    public boolean validarFecha(JDateChooser checkIn){
        Date date= new Date();
        if(checkIn.equals(date) || checkIn.getDate().after(date)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        DataBase.iniciar();
        JFrame frame = new JFrame("Add Turno");
        frame.setContentPane(new addTurno(frame).Turno);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}


