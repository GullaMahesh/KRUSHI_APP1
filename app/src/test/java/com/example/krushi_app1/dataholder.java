package com.example.krushi_app1;

public class dataholder
{
    String name,contact,course,pimage;

    public dataholder(String name, String contact, String course, String pimage) {
        this.name = name;
        this.contact = contact;
        this.course = course;
        this.pimage = pimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }
}
