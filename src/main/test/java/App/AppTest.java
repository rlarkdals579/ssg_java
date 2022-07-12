package App;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    @DisplayName("파일에 내용쓰기")
    void writedownToFileTest(){
        Util.mkdir("test_data");
        Util.saveToFile("test_data/1.json", "내용들");
    }

    @Test
    @DisplayName("스캐너 인풋 테스트")
    public void ScannerInputTest() {
        String input = """
                등록
                명언1
                작가1
                """.stripIndent();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner sc = new Scanner(in);

        String cmd = sc.nextLine().trim();
        String content = sc.nextLine().trim();
        String author = sc.nextLine().trim();

        assertEquals("등록", cmd);
        assertEquals("명언1", content);
        assertEquals("작가1", author);
    }

    @Test
    @DisplayName("스캐너 아웃풋 테스트")
    public void ScanerOuputTest() throws IOException {
        // 표준출력을 리다이렉션
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕");

        String rs = output.toString().trim();

        // 표준출력을 원상복구
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        output.close();

        assertEquals("안녕", rs);
    }


    @Test
    @DisplayName("삭제 테스트")
    public void Rq__getIntParam() {
        Request rq = new Request("삭제?id=1");

        int id = rq.getIntParam("id", 0);

        assertEquals(1, id);
    }

    @Test
    public void Rq__getIntParam__2() {
        Request rq = new Request("검색?id=10&no=1");

        int id = rq.getIntParam("id", 0);
        int no = rq.getIntParam("no", 0);

        assertEquals(10, id);
        assertEquals(1, no);
    }

    @Test
    public void Rq__getPath() {
        Request rq = new Request("삭제?id=1");

        String path = rq.getPath();

        assertEquals("삭제", path);
    }
}


