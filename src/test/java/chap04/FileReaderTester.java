package chap04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileReaderTester {

    private FileReader _input;

    @Before
    public void setUp() {
        try {
            _input = new FileReader("src/test/java/chap04/data.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("테스트 파일을 열 수 없음");
        }
    }

    @Test
    public void testRead() throws IOException {
        char ch = '&';
        for (int i = 0; i < 4; i++) {
            ch = (char) _input.read();
        }
        assertEquals('d', ch);
    }

    @After
    public void tearDown() {
        try {
            _input.close();
        } catch (IOException e) {
            throw new RuntimeException("테스트 파일을 닫는 중 에러 발생");
        }
    }
}
