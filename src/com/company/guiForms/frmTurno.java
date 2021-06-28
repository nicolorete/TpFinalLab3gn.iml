package com.company.guiForms;

import com.company.database.DataBase;
import com.company.clases.Turno;
import com.company.clases.LocalDeCanchas;
import com.company.clases.TurnoStatus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

public class frmTurno extends JFrame {
    public JPanel pnlprincipal;
    private JLabel lblTurno;
    private JButton btnTurno;
    private JButton btnCheckOut;
    private JButton btnCheckin;
    private JButton btnCancel;
    private JTextField txtSearch;
    private JButton searchButton;
    private JTable table;
    LocalDeCanchas localDeCanchas;

    public frmTurno() {
        TurnoTableModel tableModel = new TurnoTableModel();
        tableModel.setList(DataBase.getTurnos());
        table.setModel(tableModel);
        localDeCanchas = new LocalDeCanchas();

        btnTurno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("AddTurno");
                frame.setContentPane(new addTurno(frame).Turno);
                frame.pack();
                frame.setSize(600, 600);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        tableModel.setList(DataBase.getTurnos());
                        table.setModel(tableModel);
                    }
                });
            }
        });
        btnCheckin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Select a Turno ");
                    return;
                }
                ArrayList<Turno> turnos = DataBase.getTurnos();
                Turno book = turnos.get(row);
                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to Check in " + book.getClient(), "Confirm Turno..", JOptionPane.YES_NO_CANCEL_OPTION);

                if (input == 0) {
                    book.setStatus(TurnoStatus.CHECKIN);
                    book.setCheckIn(new Date());
                    DataBase.turnoUpdate(turnos);
                    tableModel.setList(turnos);
                }

            }
        });


        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {     // to detect doble click events
                    JTable target = (JTable) me.getSource();
                    int row = target.getSelectedRow(); // select a row
                    ArrayList<Turno> turnos = DataBase.getTurnos();
                    Turno book = turnos.get(row);
                    JFrame frame = new JFrame("Turnos");
                    frame.setContentPane(new viewTurno(book, frame).pnlView);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }
        });

        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Select a Turno  ");
                    return;
                }
                ArrayList<Turno> turnos = DataBase.getTurnos();
                Turno book = turnos.get(row);
                int input = JOptionPane.showConfirmDialog(null,
                        "Salir? " + book.getClient(), "Confirm Turno...", JOptionPane.YES_NO_CANCEL_OPTION);

                if (input == 0) {
                    book.setStatus(TurnoStatus.CHECKOUT);
                    book.setCheckOut(new Date());
                    DataBase.turnoUpdate(turnos);
                    tableModel.setList(turnos);
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Turno> turnos = localDeCanchas.searchTurno(txtSearch.getText().toString());
                tableModel.setList(turnos);
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Select a Turno");
                    return;
                }
                ArrayList<Turno> turnos = DataBase.getTurnos();
                Turno book = turnos.get(row);
                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to cancel the turno? " + book.getClient(), "Confirm Turno...", JOptionPane.YES_NO_CANCEL_OPTION);

                if (input == 0) {
                    book.setStatus(TurnoStatus.CANCEL);
                    DataBase.turnoUpdate(turnos);
                    tableModel.setList(turnos);
                }
            }
        });
    }

    public static void main(String[] args) {

        DataBase.iniciar();
        JFrame frame = new JFrame("Turno");
        frame.setContentPane(new frmTurno().pnlprincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1200, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
