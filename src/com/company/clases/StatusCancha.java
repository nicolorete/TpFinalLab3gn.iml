package com.company.clases;

public class StatusCancha {

    private boolean available;
    private String reason;

    public StatusCancha(boolean available, String reaseon) { /// PUT A REASON
        this.available = available;
        this.reason = reaseon;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getReaseon() {
        return reason;
    }

    public void setReaseon(String reaseon) {
        this.reason = reaseon;
    }
}
