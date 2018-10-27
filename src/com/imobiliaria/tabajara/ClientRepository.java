package com.imobiliaria.tabajara;

import java.util.ArrayList;

public class ClientRepository implements Repository{

    private ClientList[] clientList;

    private int index;

    public ClientRepository(int tam) {
        this.clientList = new ClientList[tam];
        this.index = 0;
    }

    /**
     * Procura Item através do número de cadastro
     *
     * @param number
     * @return  >= 0 index do item
     * @return -1 Não encontrou nenhum item
     */
    private int searchIndex(String number) {

        int i = 0;
        for (; i < index; i++) {
            if (this.clientList[i].getNumber().equals(number))
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
    public ClientList[] searchItem(String s) {

        ArrayList<ClientList> itens = new ArrayList<ClientList>();

        for (int i = 0; i < index; i++) {
            if ( this.clientList[i].getNumber().equals(s) || this.clientList[i].getCPF().equals(s) || this.clientList[i].getName().equals(s) )
                itens.add(this.clientList[i]);
        }

        //Converte ArrayList em vetor
        return (ClientList[])itens.toArray(new ClientList[itens.size()]);
    }

    /**
     * Obtém todos os itens cadastrados
     *
     * @return Client[]
     */
    public ClientList[] getItems() {

        ClientList[] itens = new ClientList[index];

        if (index > 0) {

            for (int i = 0; i < index; i++)
                itens[i] = this.clientList[i];

            return itens;
        }

        return null;
    }

    /**
     * Procura o item pelo index
     *
     * @param s
     * @return null - não exite cliente com a conta
     * @return != null - retorna o objeto do cliente encontrado
     */
    @Override
    public ClientList search(String s) {

        ClientList item = null;

        int id = this.searchIndex(s);

        if (id == -1)
            return null;
        else
            item = this.clientList[id];

        return item;
    }

    /**
     * Insere o item
     *
     * @param item
     */
    @Override
    public void add(ClientList item) {

        if (index < this.clientList.length) {

            if (item != null) {

                if (this.search(item.getNumber()) == null)
                    this.clientList[this.index++] = item;
                else
                    throw new IllegalArgumentException("add | item já cadastrado");

            } else
                throw new NullPointerException("add | item inválido");

        }else
            throw new ArrayIndexOutOfBoundsException("add | lista Cheia");

    }

    /**
     * Substitui o objeto do item
     * @param item
     */
    @Override
    public void update(ClientList item) {

        int id = this.searchIndex(item.getNumber());

        if(id != -1 )
            this.clientList[id] = item;
        else
            throw new NullPointerException("update | item inválido");
    }

    @Override
    public ClientList get(int id) {
        return null;
    }

    /**
     * Remove o Item pelo código indice
     * @param number
     * @return true - para cliente removido com sucesso
     * @return false - para cliente não encontrado
     */
    @Override
    public void remove(String number) {

        int id = this.searchIndex(number);

        if (id != -1) {
            this.clientList[id] = clientList[ --index ];
            this.clientList[index] = null;
        }else
            throw new NullPointerException("remove | item inválido");

    }

    private boolean overflow(){
        return true;
    }

    private boolean underflow(){
        return true;
    }

    public boolean exist(String index) {
        int i = this.searchIndex(index);
        return i != -1;
    }

}