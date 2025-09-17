package com.back;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {

    private Scanner sc = new Scanner(System.in);
    private int lastId = 0;
    private List<WiseSaying> wiseSayings = new ArrayList<>();//List를 사용한 이유는 상속관계에서 후손들을 사용 할 수 있기때문.
    HashMap<String,String> paramMap = new HashMap<>();

    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();

            if (command.equals("등록")) {
                actionWrite();

            } else if (command.equals("목록")) {
                actionList();

            } else if (command.startsWith("삭제")) {
                setParams(command);
                actionDelete();

            } else if (command.startsWith("수정")) {
                setParams(command);
                actionModify();

            } else if (command.equals("종료")) {
                break;
            }
        }
    }

    private void setParams(String command) {
        String[] commandBits = command.split("\\?");

        String actionName = commandBits[0];
        String queryString = "";

        if(commandBits.length > 1){
            queryString = commandBits[1];
        }

        String[] queryStringBits = queryString.split("&");
        for(String param : queryStringBits){
            String[] paramBits = param.split("=");
            String key = paramBits[0];
            String value = null;

            if(paramBits.length < 1){
                continue;
            }

            value = paramBits[1];
            paramMap.put(key, value);
        }
    }

    private String getParam(String key){
        return  paramMap.get(key);
    }

    private void actionModify() {

        String idStr = getParam("id");
        int id = Integer.parseInt(idStr);

        WiseSaying wiseSaying  = findByIdOrNull(id);

        if(wiseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }


        System.out.println("명언(기존) : %s".formatted(wiseSaying.getSaying()));
        System.out.print("명언 : ");
        String newSaying = sc.nextLine();
        System.out.println("작가(기존) : %s".formatted(wiseSaying.getAuthor()));
        System.out.print("작가 : ");
        String newAuthor = sc.nextLine();

        modify(wiseSaying, newSaying, newAuthor);
    }

    private void modify(WiseSaying modifyTargetWiseSaying, String newSaying, String newAuthor) {
        modifyTargetWiseSaying.setSaying(newSaying);
        modifyTargetWiseSaying.setAuthor(newAuthor);
    }

    private void actionDelete() {

        String idStr = getParam("id");
        int id = Integer.parseInt(idStr);

        boolean result = delete(id);

        if (result) {
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
        } else {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
        }
    }

    private WiseSaying findByIdOrNull(int id) {
        return wiseSayings.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private int findIndexById(int id) {
        return IntStream.range(0,wiseSayings.size())
                .filter(i -> wiseSayings.get(i).getId() == id)
                .findFirst()
                .orElse(-1);

    }

    private boolean delete(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayings = findListDesc();

        for (WiseSaying wiseSaying : wiseSayings) {
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getSaying(), wiseSaying.getAuthor()));
        }
    }

    private List<WiseSaying> findListDesc() {
        return wiseSayings.reversed();
    }

    private void actionWrite() {
        System.out.print("명언 : ");
        String saying = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = write(saying, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    private WiseSaying write(String saying, String author) {

        lastId++;
        WiseSaying wiseSaying = new WiseSaying(lastId, saying, author);
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }
}