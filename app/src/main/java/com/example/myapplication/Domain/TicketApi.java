package com.example.myapplication.Domain;

public class TicketApi {

    private String id;
    private String edition;
    private String nom;


    public  TicketApi(String id, String edition, String nom){
        this.id=id;
        this.edition=edition;
        this.nom=nom;
    }

    public String getId(){
        return this.id;
    }

    public  String getEdition(){
        return this.edition;
    }

    public  String getNom(){
        return this.nom;
    }

    public String toString(){
        return "id:"+id+" edition:"+edition+" nom:"+nom;
    }

}
