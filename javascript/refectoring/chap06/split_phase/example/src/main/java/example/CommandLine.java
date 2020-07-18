package example;

import java.util.stream.Stream;

public class CommandLine {
    String[] args;

    public CommandLine(String[] args) {
        if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");
        this.args = args;
    }

    public String filename() {
        return args[args.length - 1];
    }

    public boolean onlyCountReady() {
        return Stream.of(args).anyMatch(arg -> "-r".equals(arg));
    }
}
