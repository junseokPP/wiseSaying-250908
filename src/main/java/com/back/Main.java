package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String saying,author;
        WiseSaying[] wiseSaying = new WiseSaying[100];
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
                wiseSaying[count] = new WiseSaying(count,saying,author);
                System.out.println("%d번 명언이 등록되었습니다.".formatted(count)); //4단계인데,,이미 해버림
            }
            else if(str.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int i=count;i>0;i--){
                    System.out.println("%d / %s / %s".formatted(wiseSaying[i].id,wiseSaying[i].saying,wiseSaying[i].author));
                }
            }
            else if (str.equals("종료")){
                break;
            }
        }
    }
}
