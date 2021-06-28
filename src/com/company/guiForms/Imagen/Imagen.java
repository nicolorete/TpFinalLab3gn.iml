package com.company.guiForms.Imagen;

import javax.swing.*;
import java.awt.*;

public class Imagen extends JPanel {

    private Image imagen; /// create a objetc type Image

    public void paint(Graphics g)
    {
        imagen= new ImageIcon(getClass().getResource("/Imagen/Imagen.png")).getImage();
        g.drawImage(imagen, 0, 0 , getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
