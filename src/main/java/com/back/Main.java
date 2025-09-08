package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        while(true){
            System.out.print("명령) ");
            String str = sc.nextLine();
            String saying,author;
            if(str.equals("등록")){
                System.out.print("명언 : ");
                saying = sc.nextLine();
                System.out.print("작가 : ");
                author = sc.nextLine();
            }
            if(str.equals("종료")){
                break;
            }
        }
    }
}
