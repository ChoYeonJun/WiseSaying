package com.example.wisesaying;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    int lastId;

    WiseSayingRepository wiseSayingRepository;
    Scanner sc;
    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingRepository = new WiseSayingRepository();
    }

    public void create(Rq rq){
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        lastId++;
        wiseSayingRepository.create(new WiseSaying(lastId, content, author));
        System.out.printf("%d번 명언 등록이 완료되었습니다.", lastId);
//                    System.out.println("등록");
    }

    public void read(Rq rq){
        System.out.println("번호 / 명언 / 작가");
        System.out.println("----------------");
        List<WiseSaying> wiseSayings = wiseSayingRepository.findAll();
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

        WiseSaying wiseSaying =  wiseSayingRepository.findById(id);

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

        wiseSayingRepository.update(wiseSaying);

    }

    public void delete(Rq rq){
        int id = rq.getIntParam("id", 0);
        if (id == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        System.out.println();

        WiseSaying wiseSaying = wiseSayingRepository.findById(id);

        if (wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        wiseSayingRepository.delete(wiseSaying);
//                    System.out.println("삭제");
    }


}
