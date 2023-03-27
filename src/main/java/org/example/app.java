package org.example;

import java.util.Scanner;

public class app {
    private final Scanner sc;

    public app(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            String command = sc.nextLine();

            if(command.equals("종료")){
                break;
            }
        }
    }
}
