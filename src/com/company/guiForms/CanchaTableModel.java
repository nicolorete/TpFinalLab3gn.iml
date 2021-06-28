package com.company.guiForms;

import com.company.clases.Cancha;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CanchaTableModel extends AbstractTableModel {

    private List<Cancha> list = new ArrayList<Cancha>();
    private String[] columnNames = {"Cancha Number","Type","Status","Reason"};

    public void setList(List<Cancha> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }


    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getCanchaNumber();

            case 1:
                return list.get(rowIndex).getCanchaType().getDescription();
            case 2:
                if(list.get(rowIndex).getStatus().isAvailable()){
                    return "Available";
                }else{
                    return "Unavailable";
                }
            case 3:
                if(list.get(rowIndex).getStatus().isAvailable()){
                    return "--";
                }else{
                    return list.get(rowIndex).getStatus().getReaseon();
                }
            default:
                return null;
        }
    }



}
