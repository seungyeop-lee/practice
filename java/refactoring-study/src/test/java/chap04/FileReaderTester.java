package chap04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FileReaderTester {

    private FileReader _input;
    private FileReader _empty;

    @Before
    public void setUp() {
        try {
            _input = new FileReader("src/test/java/chap04/data.txt");
            _empty = newEmptyFile();
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    private FileReader newEmptyFile() throws IOException {
        File empty = new File("src/test/java/chap04/empty.txt");
        FileOutputStream out = new FileOutputStream(empty);
        out.close();
        return new FileReader(empty);
    }

    @Test
    public void testRead() throws IOException {
        char ch = '&';
        for (int i = 0; i < 4; i++) {
            ch = (char) _input.read();
        }
        assertEquals('d', ch);
    }

    @Test
    public void testReadAtEnd() throws IOException {
        int ch = -1234;
        for (int i = 0; i < 138; i++) {
            ch = _input.read();
        }
        assertEquals("read at end", -1, _input.read());
    }

    @Test
    public void testReadBoundaries() throws IOException {
        assertEquals("read first char", 'B', _input.read());
        int ch;
        for (int i = 1; i < 137; ++i) {
            ch = _input.read();
        }
        assertEquals("read last char", '6', _input.read());
        assertEquals("read at end", -1, _input.read());
        assertEquals("read past end", -1, _input.read());
    }

    @Test
    public void testEmptyRead() throws IOException {
        assertEquals(-1, _empty.read());
    }

    @Test
    public void testreadAfterClose() throws IOException {
        _input.close();
        try {
            _input.read();
            fail("read past end에 예외가 발생하지 않음");
        } catch (IOException e) {}
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
