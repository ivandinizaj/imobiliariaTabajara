package com.imobiliaria.tabajara;

public interface Repository {

    void add(Client item);

    void update(Client item);

    Client get(int id);

    Client search(String s);

    void remove(String number);
}
