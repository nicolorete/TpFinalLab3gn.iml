package com.company.guiForms;

import com.company.clases.Client;
import com.company.database.DataBase;
import com.company.clases.Admin;
import com.company.clases.Rol;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class FrmUser extends JFrame {
    private JTable table;
    private JTextField txt_name;
    private JTextField txt_lastName;
    private JTextField txt_Dni;
    private JTextField txt_Username;
    private JPasswordField txt_password;
    private JComboBox comboBoxRol;
    private JButton btnUpdate;
    private JButton btnExit;
    private JButton btnAccept;
    private JLabel lblName;
    private JLabel lblDni;
    private JLabel lblUserName;
    private JLabel lblPassword;
    private JLabel lblRol;
    private JPanel JPanel;
    public JPanel jPanelUser;
    private JTextField txt_search;
    private JButton btnModify;
    private JButton btnRemove;
    private boolean actualizar = false; /// always is false, so we can modify the client
    private int rowActualizar = 0;

    public FrmUser(JFrame _frame) {

        comboBoxRol.addItem("ADMIN");
        comboBoxRol.addItem("EMPLEADO");
        comboBoxRol.addItem("CLIENT");
        UserTableModel tableModel = new UserTableModel();
        tableModel.setList(DataBase.getListUser());
        table.setModel(tableModel);

        btnAccept.addActionListener(new ActionListener() {
            Admin admin;

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txt_name.getText();
                String lastName = txt_lastName.getText();
                String dni = txt_Dni.getText();
                String userName = txt_Username.getText();
                String password = String.valueOf(txt_password.getPassword());
                Rol rol = new Rol((String) comboBoxRol.getSelectedItem());

                try {
                    this.admin = new Admin(name, lastName, dni, password, userName, rol);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                //System.out.println(user.toString());
                if (DataBase.saveUser(admin)) {
                    //mostrar un mensaje se guardo correctamente
                    JOptionPane.showMessageDialog(null, "El Usuario se cargo con exito ", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    tableModel.setList(DataBase.getListUser());

                } else {
                    //mostrar un mensaje que hubo un error
                    JOptionPane.showMessageDialog(null, "Vuelva a cargar el cliente", "Mensaje", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmPrincipal open = new FrmPrincipal();
                closeUser();
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _frame.dispose();
            }
        });
        btnModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow(); ///
                if (row == -1) { ///no selection
                    JOptionPane.showMessageDialog(null, "Select a Person ");
                    return;
                }
                ArrayList<Admin> listAdmins = DataBase.getListUser();
                Admin admin= listAdmins.get(row);
                txt_name.setText(admin.getName());
                txt_lastName.setText(admin.getLastName());
                txt_Dni.setText(admin.getDni());
                txt_Username.setText(admin.getUserName());
                txt_password.setText(admin.getPassword());
                comboBoxRol.getSelectedItem();
                btnAccept.setText("UPDATE");
                actualizar = true;
                rowActualizar = row;

            }
        });

        ///remove admin
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();//0
                if (row == -1) { /// si no selecciono ninguna fila muestra select client
                    JOptionPane.showMessageDialog(null, "Select a Person  ");
                    return;
                }
                ArrayList<Admin> admins = DataBase.getListUser();
                Admin admin = admins.get(row);


                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete  " + admin.getUserName(), "Confirm Delete...", JOptionPane.YES_NO_CANCEL_OPTION);

                if (input == 0) {
                   admins.remove(row);
                    DataBase.adminUpdate(admins); /// safe the list without the amdin deleted
                    tableModel.setList(admins);
                }

            }
        });
        ///buscar admin
        txt_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String search = txt_search.getText().toLowerCase();
                ArrayList<Admin> listAdmin = new ArrayList<Admin>();
                for (Admin admin : DataBase.getListUser()) {
                    if (admin.getName().toLowerCase().contains(search) || admin.getLastName().toLowerCase().contains(search) ||
                            admin.getDni().toLowerCase().contains(search)) {
                        listAdmin.add(admin);
                    }
                }
                tableModel.setList(listAdmin);
            }
        });

        txt_name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char validar= e.getKeyChar();
                try
                {
                    if(Character.isDigit(validar)){
                        getToolkit().beep();

                        e.consume();
                        JOptionPane.showMessageDialog(rootPane, "Ingrese solo letras");
                    }
                }catch (Exception ex){
                    ex.getMessage();
                }

            }
        });
        txt_lastName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char validar= e.getKeyChar();
                try
                {
                    if(Character.isDigit(validar)){
                        getToolkit().beep();

                        e.consume();
                        JOptionPane.showMessageDialog(rootPane, "Ingrese solo letras");
                    }
                }catch (Exception ex){
                    ex.getMessage();
                }

            }
        });





        txt_Dni.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                //String text = txt_Dni.getText();
                char validar= e.getKeyChar();
                //Pattern patron = Pattern.compile("[0-9]{7,8}");
                String validar2= txt_Dni.getText();

                ArrayList<Client> listClients = DataBase.getListClient();

                try
                {//                                   //adminite utilizar la barra para borrar
                    if ((validar<'0' || validar>'9') &&  (validar != (char)KeyEvent.VK_BACK_SPACE)  ){
                        getToolkit().beep();/// make a sound
                        e.consume();/// se rehace la teclas pusaldas, ignora el evento del teclado
                        JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros"); //abre una pantalla indicando el error
                    }

                }catch (Exception ex){
                    ex.getMessage();
                }

            }
        });

    }

    public void closeUser() {
        this.setVisible(false); /// show or not a windows, depends of the parameter
        dispose();
    }
}
