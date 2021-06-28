package com.company.guiForms;

import com.company.clases.Turno;
import com.company.clases.Cancha;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class viewTurno extends JFrame {
    public JPanel pnlView;
    private JTextField txtUser;
    private JTextArea txtClients;
    private JLabel txtStatus1;
    private JLabel Client;
    private JTextField txtStartDate;
    private JLabel txtEndDate1;
    private JTextField txtCheckin;
    private JTextField txtCheckout;
    private JTextField txtnClients;
    private JTextArea txtCancha;
    private JTextField txtClient;
    private JTextField txtEndDate;
    private JButton btnAceptar;
    private JTextField txtStatus;
    private JLabel Cancha;

    public viewTurno(Turno turno, JFrame frame) {

        txtUser.setText(turno.getUser().getUserName() + " " + turno.getUser().getRol().getDescription());
        txtClient.setText(turno.getClient().name());
        txtStatus.setText(turno.getStatus().toString());
        txtStartDate.setText(turno.getStartDate().toString());
        txtEndDate.setText(turno.getEndDate().toString());
        if (turno.getCheckIn() != null) {
            txtCheckin.setText(turno.getCheckIn().toString());
        } else {
            txtCheckin.setText("NOT CHECKING");
        }
        if (turno.getCheckOut() != null) {
            txtCheckout.setText(turno.getCheckOut().toString());
        } else {
            txtCheckout.setText("NOT CHECKOUT");
        }

        for (Cancha cancha : turno.getCanchaList()) {
            txtCancha.append(cancha.toString() + " ");
        }



        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
