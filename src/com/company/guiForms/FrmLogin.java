package com.company.guiForms;
import com.company.database.DataBase;
import com.company.clases.Admin;
import com.company.guiForms.Imagen.Imagen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class FrmLogin extends JFrame {
    private JLabel lblPassword;
    private JLabel lblUser;
    private JTextField txt_User;
    //private JTextField txt_Password;
    private JPasswordField txt_Password;
    private JButton btnLogin;
    public JPanel panelControl;
    private JComboBox comboUsers;
    private JCheckBox showPasswordCheckBox;
    public boolean estado;
    JFrame frame;


    public FrmLogin(JFrame _frame) {

        //JPasswordField txt_Password= new JPasswordField();
        this.frame=_frame;

        for (Admin u : DataBase.getListUser()) {
            comboUsers.addItem(u.getUserName());

        }

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password= new String(txt_Password.getPassword()); // convertimos a un string Jpaswword
                //String password = txt_Password.getText();

                if (validar(password) == true) {
                    openPrincipal();
                    closeInit();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta ", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    //closeInit();
                }
            }
        });

        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JPasswordField txt_Password= new JPasswordField();
                if(showPasswordCheckBox.isSelected()){

                    txt_Password.setEchoChar((char) 0);
                }else
                {
                    txt_Password.setEchoChar('*');
                }
            }
        });
    }



    public void openPrincipal() {


        Imagen imagen= new Imagen();
        JFrame frame = new JFrame("Principal");
        this.setContentPane(imagen);
        frame.setContentPane(new FrmPrincipal().frmPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void closeInit() {
        frame.dispose();
    }

    private void txt_Users(String listClient) {
    }

    public boolean validar(String pass) {
        ArrayList<Admin> listAdmin = DataBase.getListUser();
        for (Admin admin1 : listAdmin) {
            if (comboUsers.getSelectedItem() == admin1.getUserName() && pass.equals(admin1.getPassword())) {
                DataBase.setUserLoggin(admin1);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        DataBase.iniciar(); /// lee todos los datos guardados en el json
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new FrmLogin(frame).panelControl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(350,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
