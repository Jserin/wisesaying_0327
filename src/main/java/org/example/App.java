package org.example;

import java.util.Scanner;

public class App {
    Scanner sc;
    private int id = 0;

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
                alist.listadd(id);

            } else if (command.equals("목록") == true) {

                alist.listup();

            } else if (command.contains("삭제?") == true) {

                int delid = Integer.parseInt(String.valueOf(command.charAt(6)));
                alist.listdel(delid);

            } else if (command.contains("수정?") == true) {

                int repid = Integer.parseInt(String.valueOf(command.charAt(6)));
                alist.listreplace(repid);
            }
        }
    }
}
