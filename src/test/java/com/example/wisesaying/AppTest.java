package com.example.wisesaying;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void 테스트_실험() {
        int rs = 10 + 20;
        assertEquals(30, rs);
    }
    @Test
    void 파일에_내용쓰기() {
        Util.mkdir("test_data");
        Util.saveToFile("test_data/1.json", "내용");
    }
    @Test
    public void 테스트_스캐너(){
        //given
        String input = """
                등록
                명언 1
                작가 1
                """.stripIndent();
        //when
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);

        String cmd1 = sc.nextLine().trim();
        String cmd2 = sc.nextLine().trim();
        String cmd3 = sc.nextLine().trim();
        //then
        assertEquals("등록", cmd1);
        assertEquals("명언 1", cmd2);
        assertEquals("작가 1", cmd3);
    }

    @Test
    public void 표준출력을_리다이렉션하여_결과_문자열() throws IOException{
        //given
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕");
        //when
        String rs = output.toString().trim();

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();
        //then
        assertEquals("안녕", rs);
    }

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
