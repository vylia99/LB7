package my;

import java.io.Serializable;

public class  Patient implements Serializable {
    private int id;
    private String surname;
    private String name;
    private String fatherName;
    private String address;
    private String phone;
    private int numberMedCart;
    private String diagnosis;


    public Patient() {
        this(0, " ", " ", " ", " ", " ", 0, " ");
    }

    public Patient(int id, String surname, String name, String fatherName, String address, String phone, int numberMedCart, String diagnosis) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.address = address;
        this.phone = phone;
        this.numberMedCart = numberMedCart;
        this.diagnosis = diagnosis;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return this.fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNumberMedCart() {
        return this.numberMedCart;
    }

    public void setNumberMedCart(int numberMedCart) {
        this.numberMedCart = numberMedCart;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String toString() {
        return "Patient{" +
                "id=" + this.id + ", " +
                "surname='" + this.surname + "', " +
                "name='" + this.name + "', " +
                "fatherName='" + this.fatherName + "', " +
                "address='" + this.address + "', " +
                "phone=" + this.phone + ", " +
                "numberMedCart=" + this.numberMedCart + "," +
                " diagnosis='" + this.diagnosis + "'}\n";
    }
    public String createString(){
        return this.id + "|" + this.surname + "|" + this.name + "|" + this.fatherName + "|" +
                this.address + "|" + this.phone + "|" + this.numberMedCart + "|" + this.diagnosis + "\n";
    }


}
