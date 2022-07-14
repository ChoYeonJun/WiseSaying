package com.example.wisesaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;

    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingRepository = new WiseSayingRepository();
    }

    public void Create(Rq rq){
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();

        System.out.print("작가 : ");
        String author = sc.nextLine().trim();
        int id = ++wiseSayingRepository.wiseSayingLastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayingRepository.wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public void Read(Rq rq){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------");
        for(int i = wiseSayingRepository.wiseSayings.size() -1 ; i >= 0; i-- ) {
            WiseSaying wiseSaying = wiseSayingRepository.wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.content, wiseSaying.author);
        }
    }

    public void Update(Rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if(paramId == 0){
            System.out.println("id를 입력해주세요.");
            return ;
        }


        WiseSaying wiseSaying_ = wiseSayingRepository.findById(paramId);

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


        WiseSaying wiseSaying_ = wiseSayingRepository.findById(paramId);

        if(wiseSaying_ == null){
            System.out.printf("%d 명언은 존재하지 않습니다.\n", paramId);
            return ;
        }

        wiseSayingRepository.wiseSayings.remove(wiseSaying_);

        System.out.printf("%d 명언이 삭제 되었습니다.\n", paramId);
    }


}
