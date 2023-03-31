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

            if (command.equals("종료") == true) {
                systemController.exit();
                break;
            } else if (command.equals("등록") == true) {

                wiseSayingController.write();

            } else if (command.equals("목록")) {

                wiseSayingController.list();

            } else if (command.startsWith("삭제")) {
                // 삭제로 시작하는 지 확인
                // Rq에 삭제 명령을 해석하는 역할 부여 여기는 실행만 함

                Rq rq = new Rq(command);
                // 입력받은 command를 그대로 Rq에 매개변수로 보내줘야함
                System.out.println();

                wiseSayingController.remove();
            }
        }
    }
}
