package com.imobiliaria.tabajara;

import java.util.ArrayList;

public class Repository {

    private List[] clients;

    private int indice;

    public Repository(int tam) {
        clients = new List[tam];
        indice = 0;
    }

    /**
     * Procura Cliente através
     *
     * @param number
     * @return -1 Não encontrou nenhum cliente return >0
     */
    private int searchIndice(String number) {

        for (int i = 0; i < indice; i++) {
            if (this.clients[i].getNumber().equals(number))
                return i;
        }

        return -1;

    }

    /**
     * Procura pelos clientes através do número da conta, CPF ou Nome
     *
     * @param s termo a ser buscado
     * @return Array de Clients encontrados
     */
    public List[] searchClient(String s) {

        ArrayList<List> clients = new ArrayList<List>();

        for (int i = 0; i < indice; i++) {
            if ( this.clients[i].getNumber().equals(s) || this.clients[i].getCPF().equals(s)
                    || this.clients[i].getName().equals(s) )
                clients.add(this.clients[i]);
        }

        //Converte ArrayList em vetor
        return (List[])clients.toArray(new List[clients.size()]);
    }

    /**
     * Obtém todos os clientes cadastrados
     *
     * @return Client[]
     */
    public List[] getClients() {

        List[] clients = new List[indice];

        if (indice > 0) {

            for (int i = 0; i < indice; i++)
                clients[i] = this.clients[i];

            return clients;
        }

        return null;
    }

    /**
     * Procura o cliente pelo número da conta
     *
     * @param s
     * @return null - não exite cliente com a conta
     * @return != null - retorna o objeto do cliente encontrado
     */
    public List search(String s) {
        List c = null;
        int i = this.searchIndice(s);
        if (i == -1)
            return null;
        else
            c = this.clients[i];

        return c;
    }

    /**
     * Insere o cliente
     *
     * @param c
     * @return >0 Inserido com sucesso
     * @return -1 Conta inválida
     * @return -2 Repositório Cheio
     */
    public int insert(List c) {

        if (indice < this.clients.length) {

            if (c != null) {
                if (this.search(c.getNumber()) == null) {
                    this.clients[indice] = c;
                    return indice++;
                }
            } else
                return -1; // conta inválida

        }
        return -2; // repositório cheio
    }

    /**
     * Substitui o objeto cliente
     * @param c
     * @return
     */
    public boolean update(List c) {
        int i = this.searchIndice(c.getNumber());

        if (i != -1) {
            this.clients[i] = c;
            return true;
        }

        return false;
    }

    /**
     * Remove o Cliente pelo número da conta
     * @param number
     * @return true - para cliente removido com sucesso
     * @return false - para cliente não encontrado
     */
    public boolean remove(String number) {

        int i = this.searchIndice(number);

        if (i != -1) {
            indice = indice - 1;
            this.clients[i] = clients[indice];
            this.clients[indice] = null;
            return true;
        }

        return false;
    }


    public boolean exist(String numero) {
        int i = this.searchIndice(numero);
        return i != -1;
    }

}