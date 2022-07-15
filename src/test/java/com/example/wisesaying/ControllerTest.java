package com.example.wisesaying;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {
    /**
     * 명령어 테스트
     * Add - 07/15
     */

    @Test
    public void 명령어_등록_입력_출력_테스트() {

        String input = """
                등록
                명언 1
                작가 1
                종료
                """.stripIndent();

        String rs = AppTestRunner.run(input);

        assertTrue(rs.contains("1번 명언 등록이 완료되었습니다."));
    }

    @Test
    public void 명령어_등록_입력_마지막_번호_테스트() {

        String input = """
                등록
                명언 1
                작가 1
                등록
                명언 2
                작가 2           
                등록
                명언 3
                작가 3
                종료
                """.stripIndent();

        String rs = AppTestRunner.run(input);

        assertTrue(rs.contains("1번 명언 등록이 완료되었습니다."));
        assertTrue(rs.contains("2번 명언 등록이 완료되었습니다."));
        assertTrue(rs.contains("3번 명언 등록이 완료되었습니다."));
    }




    @Test
    public void 명령어_등록_입력_목록_출력_테스트() {

        String input = """
                등록
                명언 1
                작가 1
                등록
                명언 2
                작가 2
                목록
                종료
                """.stripIndent();

        String rs = AppTestRunner.run(input);

        assertTrue(rs.contains("번호 / 명언 / 작가"));
        assertTrue(rs.contains("----------------"));
        assertTrue(rs.contains("1 / 명언 1 / 작가 1"));
        assertTrue(rs.contains("2 / 명언 2 / 작가 2"));
    }

//    @Test
//    public void Id로_element_찾기(){
//        String input = """
//                등록
//                명언 1
//                작가 1
//                등록
//                명언 2
//                작가 2
//                목록
//                종료
//                """.stripIndent();
//
//        String rs = AppTestRunner.run(input);
//
//        WiseSaying wiseSaying = AppTestRunner.app.findById(1);
//
//        assertEquals(wiseSaying.author,"작가 1");
//        assertEquals(wiseSaying.content,"명언 1");
//
//    }


    @Test
    public void 명령어_삭제_입력_테스트() {

        String input = """
                등록
                명언 1
                작가 1
                등록
                명언 2
                작가 2
                삭제?id=2
                목록
                종료
                """.stripIndent();

        String rs = AppTestRunner.run(input);
        assertTrue(rs.contains("번호 / 명언 / 작가"));
        assertTrue(rs.contains("----------------"));
        assertTrue(rs.contains("1 / 명언 1 / 작가 1"));
        assertFalse(rs.contains("2 / 명언 2 / 작가 2"));
    }

    @Test
    public void 명령어_삭제_입력_예외처리_테스트() {

        String input = """
                등록
                명언 1
                작가 1
                등록
                명언 2
                작가 2
                삭제
                삭제?id=3
                종료
                """.stripIndent();

        String rs = AppTestRunner.run(input);
        assertTrue(rs.contains("id를 입력해주세요."));
        assertTrue(rs.contains("3번 명언은 존재하지 않습니다."));
    }

    @Test
    public void 명령어_수정_입력_테스트() {

        String input = """
                등록
                명언 1
                작가 1
                등록
                명언 2
                작가 2
                수정?id=2
                명언 3
                작가 3
                목록
                종료
                """.stripIndent();

        String rs = AppTestRunner.run(input);
        assertTrue(rs.contains("번호 / 명언 / 작가"));
        assertTrue(rs.contains("----------------"));
        assertTrue(rs.contains("1 / 명언 1 / 작가 1"));
        assertTrue(rs.contains("2 / 명언 3 / 작가 3"));
    }
    /**
     * 명령어 테스트 끝
     */

}
