package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class List {
    Scanner listsc = new Scanner(System.in);
    private String content;
    private String author;

    ArrayList<Integer> idlist = new ArrayList<>();
    ArrayList<String> contentlist = new ArrayList<>();
    ArrayList<String> authorlist = new ArrayList<>();


    public void listup() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = idlist.size(); i > 0; i--) {
            if (contentlist.get(i - 1) != null) {
                System.out.println(idlist.get(i - 1) + " / " + authorlist.get(i - 1) + " / " + contentlist.get(i - 1));
            }
        }
    }

    public void listadd(int id) {

        System.out.println("명언 : ");
        this.content = listsc.nextLine().trim();
        System.out.println("작가 : ");
        this.author = listsc.nextLine().trim();
        System.out.println(id + "번 명언이 등록되었습니다.");

        idlist.add(id);
        contentlist.add(this.content);
        authorlist.add(this.author);

    }

    public void listdel(int id) {

        if (contentlist.get(id - 1) == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        } else {
            contentlist.set(id - 1, null);
            authorlist.set(id - 1, null);
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }
    }

    public void listreplace(int id) {

        System.out.println("명언(기존) : " + contentlist.get(id - 1));
        System.out.println("명언 : ");
        this.content = listsc.nextLine().trim();
        contentlist.set(id - 1, this.content);

        System.out.println("작가(기존) : " + authorlist.get(id - 1));
        System.out.println("작가 : ");
        this.author = listsc.nextLine().trim();
        authorlist.set(id - 1, this.author);

        System.out.println(id + "번 명언이 수정되었습니다.");

    }


}

