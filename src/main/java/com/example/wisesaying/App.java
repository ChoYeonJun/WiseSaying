package com.example.wisesaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    Scanner sc;
    int lastId;
    List<WiseSaying> wiseSayings;

    public App() {
        sc = new Scanner(System.in);
        lastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public App(Scanner sc) {
        this.sc = sc;
        lastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void run() {
        outer:
        while (true) {
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);
            System.out.println("명령 ) ");
            int id;
            WiseSaying wiseSaying;
            switch (rq.getPath()) {
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine();

                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();

                    lastId++;
                    wiseSayings.add(new WiseSaying(lastId, content, author));

                    System.out.printf("%d번 명언 등록이 완료되었습니다.", lastId);
//                    System.out.println("등록");
                    break;
                case "목록":
                    System.out.println("번호 / 명언 / 작가");
                    System.out.println("----------------");
                    for (int i = 0; i < wiseSayings.size(); i++)
                        System.out.printf("%d / %s / %s\n", wiseSayings.get(i).id, wiseSayings.get(i).content, wiseSayings.get(i).author);

//                    System.out.println("목록");
                    break;
                case "수정":
                    id = rq.getIntParam("id", 0);
                    if (id == 0) {
                        System.out.println("id를 입력해주세요.");
                        continue;
                    }

                    System.out.println();

                    wiseSaying = findById(id);

                    if (wiseSaying == null) {
                        System.out.println(id + "번 명언은 존재하지 않습니다.");
                        continue;
                    }

                    /*
                     명령) 수정?id=2
                     명언(기존) : 과거에 집착하지 마라.
                     명언 : 현재와 자신을 사랑하라.
                     작가(기존) : 작자미상
                     작가 : 홍길동
                     */

                    System.out.printf("명언(기존) : %s", wiseSaying.content);
                    System.out.print("명언 : ");
                    String editContent = sc.nextLine();

                    System.out.printf("작가(기존) : %s", wiseSaying.author);
                    System.out.print("작가 : ");
                    String editAuthor = sc.nextLine().trim();
                    int index = wiseSayings.indexOf(wiseSaying);
                    wiseSayings.set(index, new WiseSaying(id, editContent, editAuthor));

//                    System.out.println("수정");
                    break;
                case "삭제":
                    id = rq.getIntParam("id", 0);
                    if (id == 0) {
                        System.out.println("id를 입력해주세요.");
                        continue;
                    }

                    System.out.println();

                    wiseSaying = findById(id);

                    if (wiseSaying == null) {
                        System.out.println(id + "번 명언은 존재하지 않습니다.");
                        continue;
                    }

                    wiseSayings.remove(wiseSaying);
//                    System.out.println("삭제");
                    break;
                case "종료":
                    break outer;
            }
        }

    }

    public WiseSaying findById(int id) {
        for (int i = 0; i < wiseSayings.size(); i++) {
            if (wiseSayings.get(i).id == id)
                return wiseSayings.get(i);
        }

        return null;
    }

}

