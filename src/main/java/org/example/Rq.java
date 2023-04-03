package org.example;

import java.util.HashMap;
import java.util.Map;


public class Rq {
    private String actionCode;
    private Map<String, String> params;


    // 삭제?id=1&id=2 이런 식으로 여러 개 받을 수 있다고 가정
    // 밑은 삭제할 id값을 찾는 메소드
    // 삭제뿐만 아니라 수정 목록 찾기 등에서도 사용함

    public Rq(String command) {
        String[] commandBits = command.split("\\?", 2);
        /* .split(string Rex) / (string regex, int limit)
        구분자를 바탕으로 문자열을 배열로 잘라줌, limit 수 만큼 잘라줌.
        구분자 여러개 = \로 구분    ?는 앞에 \\ 필요
        */
        actionCode = commandBits[0]; // [삭제, id=1&id=2] 중에서 [삭제]만 저장

        params = new HashMap<>();

        // ?붙은 명령 아닐 때 반복문 돌기 전에 종료 시킴. ?랑 &가 없는데 밑 로직 들어가면 오류남
        if (commandBits.length == 1) return;

        String[] paramsBits = commandBits[1].split("&"); // [id=1, id=2]

        for (String paramStr : paramsBits) {
            String[] paramStrBits = paramStr.split("=", 2);

            // 안정성을 위해 추가. 없어도 실행됨
            if (paramStrBits.length == 1) continue;

            String key = paramStrBits[0];
            String value = paramStrBits[1];
            // id와 값으로 나누어서 params 해시맵에 저장
            params.put(key, value);
        } // [id, 1]
    }


    public String getActionCode() {
        return actionCode;
    }

    public String getParam(String name) {
        return params.get(name);
    }

    public int getIntParam(String name, int defaultValue) {
        try {
            return Integer.parseInt(getParam(name));
        } catch (NumberFormatException e) {
            System.out.println("숫자 아님 오류 발생");
        }
        return defaultValue;
    }



}
