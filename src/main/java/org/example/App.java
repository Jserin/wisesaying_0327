package org.example;

import java.util.Scanner;

public class App {
    Scanner sc;
    private int id = 0;
    private String content;
    private String author;
    List alist = new List();

    App(Scanner sc) {
        this.sc = sc;
    }

    void Run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.println("명령) ");
            String command = sc.nextLine();

            if (command.equals("종료") == true) {
                System.out.println("종료합니다.");
                break;
            } else if (command.equals("등록") == true) {
                id++;

                System.out.println("명언 : ");
                this.content = sc.nextLine().trim();
                System.out.println("작가 : ");
                this.author = sc.nextLine().trim();
                System.out.println(id + "번 명언이 등록되었습니다.");

                alist.listadd(id, this.content, this.author);

            } else if (command.equals("목록") == true) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                alist.listup();
            } else if (command.contains("삭제?") == true) {
                int delid = Integer.parseInt(String.valueOf(command.charAt(6)));

                if (alist.contentlist.get(delid - 1) == null) {
                    System.out.println(delid + "번 명언은 존재하지 않습니다.");
                } else {
                    alist.listdel(delid);
                    System.out.println(delid + "번 명언이 삭제되었습니다.");
                }
            } else if (command.contains("수정?") == true) {
                int repid = Integer.parseInt(String.valueOf(command.charAt(6)));

                alist.replace(repid);

                System.out.println("명언(기존) : " + alist.contentlist.get(repid - 1));
                System.out.println("명언 : ");
                this.content = sc.nextLine().trim();
                alist.contentlist.set(repid - 1, this.content);

                System.out.println("작가(기존) : " + alist.authorlist.get(repid - 1));
                System.out.println("작가 : ");
                this.author = sc.nextLine().trim();
                alist.authorlist.set(repid - 1, this.author);


            }


        }
    }
}
