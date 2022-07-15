package com.example.wisesaying;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RqTest {
    @Test
    public void Rq__getIntParam(){
        //given
        Rq rq = new Rq("삭제?id=1");
        //when
        int id = rq.getIntParam("id", 0);
        //then
        assertEquals(1, id);
    }

    @Test
    public void Rq__getIntParam_2(){
        Rq rq = new Rq("검색?id=10&no=1");

        int id = rq.getIntParam("id", 0);
        int no = rq.getIntParam("no", 0);

        assertEquals(10, id);
        assertEquals(1, no);
    }

    @Test
    public void Rq__getPath(){
        Rq rq = new Rq("삭제?id=1");
        String path = rq.getPath();
        assertEquals("삭제", path);
    }
}
