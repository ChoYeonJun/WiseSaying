package com.example.wisesaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    Scanner sc;
    WiseSayingRepository wiseSayingRepository;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingRepository = new WiseSayingRepository(sc);
    }

    public void create(Rq rq){
        wiseSayingRepository.create(rq);
    }
    public void read(Rq rq){
        wiseSayingRepository.read(rq);
    }
    public void update(Rq rq){
        wiseSayingRepository.update(rq);
    }
    public void delete(Rq rq){
        wiseSayingRepository.delete(rq);
    }
}

