package com.example.krushi_app1;

public class model {
    String address, email, eqcompany, eqname, eqowner, eqrent, phone, pimage, status;

    public model() {
    }

    public model(String address, String email, String eqcompany, String eqname, String eqowner, String eqrent, String phone, String pimage, String status) {
        this.address = address;
        this.email = email;
        this.eqcompany = eqcompany;
        this.eqname = eqname;
        this.eqowner = eqowner;
        this.eqrent = eqrent;
        this.phone = phone;
        this.pimage = pimage;
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEqcompany() {
        return eqcompany;
    }

    public void setEqcompany(String eqcompany) {
        this.eqcompany = eqcompany;
    }

    public String getEqname() {
        return eqname;
    }

    public void setEqname(String eqname) {
        this.eqname = eqname;
    }

    public String getEqowner() {
        return eqowner;
    }

    public void setEqowner(String eqowner) {
        this.eqowner = eqowner;
    }

    public String getEqrent() {
        return eqrent;
    }

    public void setEqrent(String eqrent) {
        this.eqrent = eqrent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
