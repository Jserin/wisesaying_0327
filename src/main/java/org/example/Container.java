package org.example;

import java.util.Scanner;

// 스캐너를 전부 관리하는 클래스
public class Container {
    private static Scanner sc;

    // 스캐너 시작,입력 값 받음
    public static void init() {
        sc = new Scanner(System.in);
    }

    // 스캐너 닫음
    public static void close() {
        sc.close();
    }

    // 스캐너 값 반환
    public static Scanner getScanner() {
        return sc;
    }
}
