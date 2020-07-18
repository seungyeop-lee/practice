package example;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AppTest {

    @Test(expected = RuntimeException.class)
    public void run_notArgs() throws IOException {
        String[] args = {};
        System.out.println(App.run(args));
    }

    @Test(expected = FileNotFoundException.class)
    public void run_notFindFile() throws IOException {
        String[] args = {"unknown.json"};
        System.out.println(App.run(args));
    }

    @Test
    public void run_totalLength() throws IOException {
        String[] args = {"test.json"};
        Assert.assertEquals(3, App.run(args));
    }

    @Test
    public void run_countStatusReady() throws IOException {
        String[] args = {"-r", "test.json"};
        Assert.assertEquals(2, App.run(args));
    }
}
