package com.models;

public class Bl {
    private String blNo;
    private String status;

    public Bl(String blNo) {
        super();
        this.blNo=blNo;
    }
    public String getBlNo() {
        return blNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    
}


