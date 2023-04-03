package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {

    // final 불변성/ 클래스나 변수의 처음 정의된 상태가 변하지 않게 함
    private long lastWiseSayingId;
    private final List<WiseSaying> wiseSayings;

    private WiseSaying findById(int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }

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

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", -1);
        if (id == -1) {
            System.out.println("정수를 입력하세요");
            return;
        }
        // id 값으로 저장된 데이터를 가져옴
        WiseSaying wiseSaying = findById(id);

        //삭제할 데이터가 없을 때
        if (wiseSaying == null) {
            System.out.println("삭제할 명언이 없습니다.");
            return;
        }

        // 삭제 메소드 실행
        wiseSayings.remove(wiseSaying);

        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    public void modify(Rq rq) {
        int id = rq.getIntParam("id", -1);
        if (id == -1) {
            System.out.println("정수를 입력하세요");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.println("수정할 명언이 없습니다.");
            return;
        }

        System.out.printf("기존 명언 : %s\n", wiseSaying.getContent());
        System.out.printf("명언 수정) ");
        String content = Container.getScanner().nextLine().trim();

        System.out.printf("기존 작가 : %s\n", wiseSaying.getAuthorName());
        System.out.printf("작가 수정) ");
        String authorName = Container.getScanner().nextLine().trim();

        wiseSaying.setContent(content);
        wiseSaying.setAuthorName(authorName);


        System.out.println(id + "번 명언이 수정되었습니다.");
    }
}
