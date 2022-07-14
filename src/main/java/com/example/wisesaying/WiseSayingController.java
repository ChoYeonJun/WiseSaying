package com.example.wisesaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private List<WiseSaying> wiseSayings;
    private int wiseSayingLastId;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        this.wiseSayings = new ArrayList<>();
        this.wiseSayingLastId = 0;
    }

    public void Create(Rq rq){
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();

        System.out.print("작가 : ");
        String author = sc.nextLine().trim();
        int id = ++wiseSayingLastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public void Read(Rq rq){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------");
        for(int i = wiseSayings.size() -1 ; i >= 0; i-- )
            System.out.printf("%d / %s / %s\n", wiseSayings.get(i).id, wiseSayings.get(i).content, wiseSayings.get(i).author);
    }

    public void Update(Rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if(paramId == 0){
            System.out.println("id를 입력해주세요.");
            return ;
        }


        WiseSaying wiseSaying_ = findById(paramId);

        if(wiseSaying_ == null){
            System.out.printf("%d 명언은 존재하지 않습니다.\n", paramId);
            return ;
        }

        System.out.printf("명언(기존) : %s\n", wiseSaying_.content);
        System.out.printf("명언 : ");
        wiseSaying_.content = sc.nextLine();
        System.out.printf("작가(기존) : %s\n", wiseSaying_.author);
        System.out.printf("작가 : ");
        wiseSaying_.author = sc.nextLine();

        System.out.printf("%d번 명언이 수정되었습니다.\n", paramId);
    }


    public void Delete(Rq rq){
        int paramId = rq.getIntParam("id", 0);

        if(paramId == 0){
            System.out.println("id를 입력해주세요.");
            return ;
        }


        WiseSaying wiseSaying_ = findById(paramId);

        if(wiseSaying_ == null){
            System.out.printf("%d 명언은 존재하지 않습니다.\n", paramId);
            return ;
        }

        wiseSayings.remove(wiseSaying_);

        System.out.printf("%d 명언이 삭제 되었습니다.\n", paramId);
    }

    private WiseSaying findById(int paramId){
        for(WiseSaying wiseSaying: wiseSayings){
            if(wiseSaying.id == paramId) return wiseSaying;
        }
        return null;
    }
}
