package com.back.domain.wiseSaying;

import com.back.domain.wiseSaying.controller.SystemController;
import com.back.domain.wiseSaying.controller.WiseSayingController;
import com.back.global.AppContext;
import com.back.global.Rq;

import java.util.Scanner;

public class App {
    private final Scanner sc = AppContext.sc;
    private final SystemController systemController = AppContext.systemController;
    private final WiseSayingController wiseSayingController = AppContext.wiseSayingController;

    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine();

            Rq rq = new Rq(command);
            String actionName = rq.getActionName();
            if (actionName.equals("등록")) {
                wiseSayingController.actionWrite();

            } else if (actionName.equals("목록")) {
                wiseSayingController.actionList();

            } else if (actionName.startsWith("삭제")) {
                wiseSayingController.actionDelete(rq);

            } else if (actionName.startsWith("수정")) {
                wiseSayingController.actionModify(rq);

            } else if (actionName.equals("종료")) {
                systemController.exit();
                break;
            }
        }
    }



}