package com.example.wisesaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingRepository {
    int lastId;
    List<WiseSaying> wiseSayings;
    Scanner sc;
    public WiseSayingRepository() {
        lastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void create(WiseSaying wiseSaying){
        wiseSayings.add(wiseSaying);
    }


    public void update(WiseSaying wiseSaying){
        int index = wiseSayings.indexOf(wiseSaying);
        wiseSayings.set(index, wiseSaying);
    }

    public void delete(WiseSaying wiseSaying){
        wiseSayings.remove(wiseSaying);
    }

    public List<WiseSaying> findAll(){
        return wiseSayings;
    }

    public WiseSaying findById(int id) {
        for (int i = 0; i < wiseSayings.size(); i++) {
            if (wiseSayings.get(i).id == id)
                return wiseSayings.get(i);
        }

        return null;
    }
}
