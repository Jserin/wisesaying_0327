package org.example;

import java.util.HashMap;


public class Rq {
    // 삭제?id=1&id=2 이런 식으로 여러 개 받을 수 있다고 가정
    // 밑은 삭제할 id값을 찾는 메소드
    String[] commandBits = command.split("\\?", 2);
    /* .split(string Rex) / (string regex, int limit)
    구분자를 바탕으로 문자열을 배열로 잘라줌, limit 수 만큼 잘라줌.
    구분자 여러개 = \로 구분
     */
    String actionCode = commandBits[0]; // 삭제

    HashMap<String, String> params = new HashMap<>();
    String[] paramsBits = commandBits[1].split("&");

                for (String paramStr : paramsBits) {
        String[] paramStrBits = paramStr.split("=", 2);
        String key = paramStrBits[0];
        String value = paramStrBits[1];
        // id와 값으로 나누어서 params 해시맵에 저장
        params.put(key, value);
    }

                System.out.println("actionCode : " + actionCode);
                System.out.println("params : " + params);
}
