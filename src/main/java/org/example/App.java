package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner sc;
    public long sayingId = 1;
    String content;
    String author;



    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
        List<SayingList> sayinglist = new ArrayList<>();


        while (true) {
            System.out.println("명령)");
            String command = sc.nextLine().trim();

            if(command.equals("종료")){
                System.out.println("== 종료 ==");
                break;
            } else if (command.equals("등록")) {

                System.out.println("명언 : ");
                content = sc.nextLine().trim();
                System.out.println("작가 : ");
                 author = sc.nextLine().trim();
                System.out.println(this.sayingId + "번 명언이 등록되었습니다.");

                SayingList sayingList = new SayingList(this.sayingId, this.content, this.author);

                this.sayingId++;


            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
            }
        }
    }


}
