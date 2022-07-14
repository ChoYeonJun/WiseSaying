package com.example.wisesaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public void run(){
        System.out.println("==명언 SSG ==");

        Scanner sc = new Scanner(System.in);
        List<WiseSaying> wiseSayings = new ArrayList<>();
        int wiseSayingLastId = 0;


        outer:
        while(true){
            System.out.print("명령 ) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);
            switch (rq.getPath()){
                case "등록" :
                    System.out.print("명언 : ");
                    String content = sc.nextLine().trim();

                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();
                    int id = ++wiseSayingLastId;

                    WiseSaying wiseSaying = new WiseSaying(id, content, author);
                    wiseSayings.add(wiseSaying);

                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;

                case "목록" :
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------");
                    for(int i = wiseSayings.size() -1 ; i >= 0; i-- )
                        System.out.printf("%d / %s / %s\n", wiseSayings.get(i).id, wiseSayings.get(i).content, wiseSayings.get(i).author);
                    break;

                case "삭제" :
                    int paramId = rq.getIntParam("id", 0);

                    if(paramId == 0){
                        System.out.println("id를 입력해주세요.");
                        continue ;
                    }


                    WiseSaying wiseSaying_ = null;

                    for(WiseSaying wiseSaying__ : wiseSayings){
                        if(wiseSaying__.id == paramId)
                            wiseSaying_ = wiseSaying__;
                    }

                    if(wiseSaying_ == null){
                        System.out.printf("%d 명언은 존재하지 않습니다.", paramId);
                        continue ;
                    }

                    wiseSayings.remove(wiseSaying_);

                    System.out.printf("%d 명언이 삭제 되었습니다.", paramId);
                    break;
                case "종료" :
                    break outer;

            }
        }
    }
}
