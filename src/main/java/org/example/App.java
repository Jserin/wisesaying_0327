package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;


public class App {

    public void run() {
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();


        while (true) {
            System.out.println("명령) ");
            String command = Container.getScanner().nextLine().trim();
            Rq rq = new Rq(command);
            // 입력받은 command를 그대로 Rq에 매개변수로 보내줘야함


            switch (rq.getActionCode()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
                case "수정":
                    wiseSayingController.modify(rq);
                    break;
            }
        }
    }
}
