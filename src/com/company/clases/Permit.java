package com.company.clases;

import java.io.Serializable;

public class Permit implements Serializable {
    private String description;

    public Permit(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Permit{" +
                "description='" + description + '\'' +
                '}';
    }
}
