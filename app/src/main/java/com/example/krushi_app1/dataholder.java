package com.example.krushi_app1;

public class dataholder
{



    String eqname,eqcompany,eqowner,eqrent,address,phone,email,status,pimage;

    public dataholder(String eqname, String eqcompany, String eqowner, String eqrent, String address, String phone, String email, String status, String pimage) {

        this.eqname = eqname;
        this.eqcompany = eqcompany;
        this.eqowner = eqowner;
        this.eqrent = eqrent;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.pimage = pimage;
    }

    public String getEqname() {
        return eqname;
    }

    public void setEqname(String eqname) {
        this.eqname = eqname;
    }

    public String getEqcompany() {
        return eqcompany;
    }

    public void setEqcompany(String eqcompany) {
        this.eqcompany = eqcompany;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }
}
