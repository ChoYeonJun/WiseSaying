package com.example.wisesaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    int lastId;
    List<WiseSaying> wiseSayings;
    Scanner sc;
    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        lastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void create(Rq rq){
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        lastId++;
        wiseSayings.add(new WiseSaying(lastId, content, author));

        System.out.printf("%d번 명언 등록이 완료되었습니다.", lastId);
//                    System.out.println("등록");
    }

    public void read(Rq rq){
        System.out.println("번호 / 명언 / 작가");
        System.out.println("----------------");
        for (int i = 0; i < wiseSayings.size(); i++)
            System.out.printf("%d / %s / %s\n", wiseSayings.get(i).id, wiseSayings.get(i).content, wiseSayings.get(i).author);

//                    System.out.println("목록");
    }

    public void update(Rq rq){
        int id = rq.getIntParam("id", 0);
        if (id == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        System.out.println();

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return ;
        }

        System.out.printf("명언(기존) : %s", wiseSaying.content);
        System.out.print("명언 : ");
        String editContent = sc.nextLine();

        System.out.printf("작가(기존) : %s", wiseSaying.author);
        System.out.print("작가 : ");
        String editAuthor = sc.nextLine().trim();
        int index = wiseSayings.indexOf(wiseSaying);
        wiseSayings.set(index, new WiseSaying(id, editContent, editAuthor));

    }

    public void delete(Rq rq){
        int id = rq.getIntParam("id", 0);
        if (id == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        System.out.println();

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        wiseSayings.remove(wiseSaying);
//                    System.out.println("삭제");
    }

    public WiseSaying findById(int id) {
        for (int i = 0; i < wiseSayings.size(); i++) {
            if (wiseSayings.get(i).id == id)
                return wiseSayings.get(i);
        }

        return null;
    }
}
