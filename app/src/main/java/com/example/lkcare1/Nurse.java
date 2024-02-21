package com.example.lkcare1;

public class Nurse {
    private String name;
    private String CIN;
    private String phone;

    public Nurse() {
        // Constructeur par défaut requis pour Firebase
    }

    public Nurse(String name, String CIN, String phone) {
        this.name = name;
        this.CIN = CIN;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getCIN() {
        return CIN;
    }

    public String getPhone() {
        return phone;
    }
}

