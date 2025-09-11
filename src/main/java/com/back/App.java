package com.back;

import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    WiseSaying[] wiseSayings = new WiseSaying[100];
    int lastIndex=0;
    int lastNo=0;

    public  void run(){


        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            String str = sc.nextLine();

            if(str.equals("등록")){
                actionWrite();
            }
            else if(str.equals("목록")){
                actionList();
            }
            else if (str.contains("삭제")){
                int id = Integer.parseInt(str.split("=")[1]);
                actionDelete(id);
            }else if (str.equals("종료")){
                break;
            }
        }
    }

    public void actionDelete(int id) {
        delete(id);
        System.out.println("1번 명언이 삭제되었습니다.");
    }

    public void delete(int id) {
        int deleteIndex = -1;

        for(int i=0;i<lastIndex;i++){
            if(wiseSayings[i].id == id){
                deleteIndex = i;
            }
        }

        for(int i=deleteIndex;i<lastIndex;i++){
            wiseSayings[i] = wiseSayings[i+1];
        }

        lastIndex--;
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        WiseSaying[] wiseSayings = findListDesc();

        for(WiseSaying wiseSaying : wiseSayings){
            System.out.println("%d / %s / %s".formatted(wiseSaying.id,wiseSaying.saying,wiseSaying.author));
        }

    }

    public WiseSaying[] findListDesc(){

        WiseSaying[] result = new WiseSaying[lastIndex];
        int resultIndex = 0;

        for(int i = lastIndex-1;i>=0;i--){
            result[resultIndex] = wiseSayings[i];
            resultIndex++;
        }
        return result;
    }

    public void actionWrite() {

        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = write(saying,author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.id));
    }

    public WiseSaying write(String saying,String author){
        lastNo++;
        WiseSaying wiseSaying =  new WiseSaying(lastNo,saying,author);
        wiseSayings[lastIndex++]=wiseSaying;
        return wiseSaying;
    }
}
