package com.imobiliaria.tabajara;

public class List {
    private String number;
    private String name;
    private String cpf;
    private char sex;
    private String birthday;
    private String email;
    private String address;
    private String complement;
    private String city;
    private String uf;
    private String phone;
    private double balance;

    public List(String number, String name, String cpf, char sex, String birthday, String address, String email, String complement,
                  String city, String uf, String phone, double balance) {

        this.number = number;
        this.name = name;
        this.cpf = cpf;
        this.sex = sex;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.uf = uf;
        this.phone = phone;
        this.balance = balance;
    }



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUF() {
        return uf;
    }

    public void setUF(String uf) {
        this.uf = uf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
