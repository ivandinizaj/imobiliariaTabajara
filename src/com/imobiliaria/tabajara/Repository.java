package com.imobiliaria.tabajara;

public interface Repository {

    void add(ClientList item);

    void update(ClientList item);

    ClientList get(int id);

    ClientList search(String s);

    void remove(String number);
}
