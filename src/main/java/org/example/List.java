package org.example;

import java.util.ArrayList;

public class List {

    ArrayList<Integer> idlist = new ArrayList<>();
    ArrayList<String> contentlist = new ArrayList<>();
    ArrayList<String> authorlist = new ArrayList<>();

    List() {
    }

    public void listup() {
        for (int i = 0; i < idlist.size(); i++) {
            if (contentlist.get(i) != null) {
                System.out.println(idlist.get(i) + " / " + authorlist.get(i) + " / " + contentlist.get(i));
            }
        }
    }

    public void listadd(int id, String content, String author) {
        idlist.add(id);
        contentlist.add(content);
        authorlist.add(author);
    }

    public void listdel(int id) {
        contentlist.set(id - 1, null);
        authorlist.set(id - 1, null);
    }

    public void replace(int id) {


    }

}

