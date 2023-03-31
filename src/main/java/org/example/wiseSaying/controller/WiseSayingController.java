package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.Scanner;

public class WiseSayingController {

    // final 불변성/ 클래스나 변수의 처음 정의된 상태가 변하지 않게 함
    private long lastWiseSayingId;
    private final ArrayList<WiseSaying> wiseSayings;

    public WiseSayingController() {
        // 클래스 선언 시 자동 실행 매개변수 필수
        lastWiseSayingId = 0;
        wiseSayings = new ArrayList<>();
    }


    public void write() {
        long id = lastWiseSayingId + 1;

        System.out.println("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.println("작가 :");
        String authorName = Container.getScanner().nextLine().trim();

        WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
        wiseSayings.add(wiseSaying);

        System.out.println(id + "번 명언이 등록되었습니다.");
        lastWiseSayingId = id;
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            // wiseSaying 은 객체, 변수

            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthorName(), wiseSaying.getContent());
        }
    }

    public void remove() {
    }
}
