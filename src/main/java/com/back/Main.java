package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String saying,author;
        int count=0;
        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.print("명령) ");
            String str = sc.nextLine();

            if(str.equals("등록")){
                System.out.print("명언 : ");
                saying = sc.nextLine();
                System.out.print("작가 : ");
                author = sc.nextLine();
                count++;
                System.out.println("%d번 명언이 등록되었습니다.".formatted(count));
            }
            if(str.equals("종료")){
                break;
            }
        }
    }
}
