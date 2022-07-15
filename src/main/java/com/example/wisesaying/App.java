package com.example.wisesaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    Scanner sc;
    WiseSayingController wiseSayingController;

    public App() {
        sc = new Scanner(System.in);
        wiseSayingController = new WiseSayingController(sc);
    }

    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingController = new WiseSayingController(sc);
    }

    public void run() {
        outer:
        while (true) {
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);
            System.out.println("명령 ) ");

            switch (rq.getPath()) {
                case "등록":
                    wiseSayingController.create(rq);
                    break;
                case "목록":
                    wiseSayingController.read(rq);
                    break;
                case "수정":
                    wiseSayingController.update(rq);
//                    System.out.println("수정");
                    break;
                case "삭제":
                    wiseSayingController.delete(rq);
                    break;
                case "종료":
                    break outer;
            }
        }

    }



}

