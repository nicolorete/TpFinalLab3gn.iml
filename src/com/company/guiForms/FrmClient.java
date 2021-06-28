package com.company.guiForms;

import com.company.clases.Admin;
import com.company.clases.Validaciones;
import com.company.database.DataBase;
import com.company.clases.Client;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrmClient extends JFrame {
    public JPanel Client;
    private JLabel lblName;
    private JTextField txt_Name;
    private JLabel lblLastName;
    private JTextField txt_LastName;
    private JLabel lblDni;
    private JTextField txt_Dni;
    private JTextField txt_Phone;
    private JLabel lblPhone;
    private JTextField txt_Address;
    private JLabel lblAddress;
    private JTextField txt_Email;
    private JLabel lblEmail;
    private JButton btnAccept;
    private JButton btnSearch;
    private JButton btnModify;
    private JButton btnRemove;
    private JButton btnExit;
    private JTextField txt_search;
    private JTable table;
    private JButton btnActulizar;
    private boolean actualizar = false; /// always is false, so we can modify the client
    private int rowActualizar = 0;

    public FrmClient(JFrame frame) {

        ClientTableModel tableModel = new ClientTableModel();
        tableModel.setList(DataBase.getListClient());
        table.setModel(tableModel);

        btnAccept.addActionListener(new ActionListener() {
            Client client;

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txt_Name.getText();
                String lastName = txt_LastName.getText();
                String dni = txt_Dni.getText();
                String phone = txt_Phone.getText();
                String email = txt_Email.getText();
                String address = txt_Address.getText();
                this.client = new Client(name, lastName, dni, phone, email, address);
                //// como esta en false va directamente al else
                if (actualizar) { /// cliente esta en false entonces sale boton aceptar

                    ArrayList<Client> listClients = DataBase.getListClient();
                    Client client = listClients.get(rowActualizar);
                    client.setName(name);
                    client.setLastName(lastName);
                    client.setDni(dni);
                    client.setPhone(phone);
                    client.setEmail(email);
                    client.setAdress(address);
                    DataBase.clientUpdate(listClients);
                    tableModel.setList(listClients);
                    btnAccept.setText("ACCEPT");
                    actualizar = false;
                } else {

                    if (DataBase.clientSave(client)) {
                        JOptionPane.showMessageDialog(null, "Client load successful ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                        tableModel.setList(DataBase.getListClient());

                    } else {

                        JOptionPane.showMessageDialog(null, "Load again the client", "Mensaje", JOptionPane.WARNING_MESSAGE);

                    }
                }
                //// dejar caja de texto en blanco desp del ciclo para que la barra quede vacia
                txt_Name.setText("");
                txt_LastName.setText("");
                txt_Dni.setText("");
                txt_Phone.setText("");
                txt_Email.setText("");
                txt_Address.setText("");
            }
        });

        /// Cuando apreto boton MODIFY ME ACTUALIZA LA BANDERA entonces se que voy a modificiar
        /// seteo los datos del cliente
        btnModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow(); /// obtengo el indice la fila seleccionada
                if (row == -1) { ///  no hay ninguna seleccionada
                    JOptionPane.showMessageDialog(null, "Select a Client ");
                    return;
                }
                ArrayList<Client> listClients = DataBase.getListClient();
                Client client = listClients.get(row);
                txt_Name.setText(client.getName());
                txt_LastName.setText(client.getLastName());
                txt_Dni.setText(client.getDni());
                txt_Phone.setText(client.getPhone());
                txt_Email.setText(client.getEmail());
                txt_Address.setText(client.getAdress());
                btnAccept.setText("UPDATE");
                actualizar = true;
                rowActualizar = row; /// necesito saber q indice del objeto que se actualizo

            }
        });

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();//0
                if (row == -1) { /// si no selecciono ninguna fila muestra select client
                    JOptionPane.showMessageDialog(null, "Select a client  ");
                    return;
                }
                ArrayList<Client> clients = DataBase.getListClient();
                Client client = clients.get(row);


                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete  " + client.name(), "Confirm Delete...", JOptionPane.YES_NO_CANCEL_OPTION);

                if (input == 0) {
                    clients.remove(row);
                    DataBase.clientUpdate(clients); /// vuelvo a guardar la lista de clientes sin el q se borro
                    tableModel.setList(clients);
                }

            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        txt_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String search = txt_search.getText().toLowerCase();

                ArrayList<Client> listClients = new ArrayList<Client>();
                for (Client client : DataBase.getListClient()) {
                    if (client.getName().toLowerCase().contains(search) || client.getLastName().toLowerCase().contains(search) ||
                            client.getDni().toLowerCase().contains(search)) {
                        listClients.add(client); /// si da true añado la lista de clientes
                    }
                }
                tableModel.setList(listClients);
            }
        });
        txt_Name.addKeyListener(new KeyAdapter() {
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
        txt_LastName.addKeyListener(new KeyAdapter() {
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
                    if ((validar<'0' || validar>'9') &&  (validar != (char)KeyEvent.VK_BACK_SPACE) && validarDni(validar2) ){
                        getToolkit().beep();/// make a sound
                        e.consume();/// se rehace la teclas pusaldas, ignora el evento del teclado
                        JOptionPane.showMessageDialog(rootPane, "Ingrese solo numeros"); //abre una pantalla indicando el error
                    }

                }catch (Exception ex){
                    ex.getMessage();
                }

            }
        });


        txt_Dni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                ArrayList<Client> listClients = DataBase.getListClient();
                super.focusGained(e);
                if(listClients.contains(txt_Dni.getText())){
                    JOptionPane.showMessageDialog(null, "The client is in the system");
                }
            }

        });


        txt_Phone.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char validar= e.getKeyChar();
                //Pattern patron = Pattern.compile("[0-9]{7,8}");
                String validar2= txt_Dni.getText();

                ArrayList<Client> listClients = DataBase.getListClient();

                try
                {//                                   //adminite utilizar la barra para borrar
                    if ((validar<'0' || validar>'9') &&  (validar != (char)KeyEvent.VK_BACK_SPACE)){
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

    public boolean validarDni(String dni) {
        ArrayList<Client> listClient = DataBase.getListClient();
        for (Client cli : listClient) {
            if (dni.equals(cli.getDni())){
                return true;
            }
        }
        return false;
    }

    public boolean verificarExisteDni(String dni){
        if(DataBase.getListClient().equals(dni)){
            System.out.println("Client is in the sytem");
            return false;
        }
        return true;
    }

    public boolean verificar(String dato){
        if(dato.length() >= 7 || dato.length() <=8){
            //dato.matches("[0-9][7,8]"); /// se puede ingresasr datos del 0 al 9 y minimo 7 u 8 numeros

            return true;
        }
        return false;

    }

    public void closeClient() {
        this.setVisible(false);
        dispose();
    }

    public JPanel getPnlClient() {
        return Client;
    }

    public void setPnlClient(JPanel pnlClient) {
        this.Client = pnlClient;
    }

}
