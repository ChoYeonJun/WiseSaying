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

            switch (cmd){
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
                case "종료" :
                    break outer;

            }
        }
    }
}
