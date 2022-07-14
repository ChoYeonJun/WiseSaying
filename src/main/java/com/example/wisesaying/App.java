package com.example.wisesaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    Scanner sc;

    public App() {
        sc = new Scanner(System.in);
    }

    public void run(){
        System.out.println("==명언 SSG ==");

        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        outer:
        while(true){
            System.out.print("명령 ) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);
            switch (rq.getPath()){
                case "등록" :
                    wiseSayingController.Create(rq);
                    break;
                case "목록" :
                    wiseSayingController.Read(rq);
                    break;
                case "수정" :
                    wiseSayingController.Update(rq);
                    break;
                case "삭제" :
                    wiseSayingController.Delete(rq);
                    break;
                case "종료" :
                    break outer;

            }
        }
    }



}
