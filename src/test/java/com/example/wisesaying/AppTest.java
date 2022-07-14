package com.example.wisesaying;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void 테스트_실험() {
        int rs = 10 + 20;
        assertEquals(30, rs);
    }

    @Test
    public void 테스트_스캐너(){
        String input = """
                등록
                명언 1
                작가 1
                """.stripIndent();

        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);

        String cmd1 = sc.nextLine().trim();
        String cmd2 = sc.nextLine().trim();
        String cmd3 = sc.nextLine().trim();

        assertEquals("등록", cmd1);
        assertEquals("명언 1", cmd2);
        assertEquals("작가 1", cmd3);
    }
}
