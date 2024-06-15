package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TextGeneratorTest {

    private DirectedGraph graph;

    @BeforeEach
    public void setUp() {
        // 初始化图
        String filePath = "src/main/java/org/example/test.txt";
        try{
            graph = Main.buildGraph(filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    @Test
    public void test1() {
        String inputText = "echoes song";

        // 捕获输出流
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 调用生成新文本的方法
        Main.generateNewText(graph, inputText);

        // 提取输出
        String output = outContent.toString();

        // 提取输出最后一行
        String[] lines = output.split("\n");
        String lastLine = lines[lines.length - 1].trim();

        // 验证输出
        String expectedOutput = "echoes the song";
        assertEquals(expectedOutput, lastLine);
    }

    @Test
    public void test2() {
        String inputText = "the echoes";

        // 捕获输出流
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 调用生成新文本的方法
        Main.generateNewText(graph, inputText);

        // 提取输出
        String output = outContent.toString();

        // 提取输出最后一行
        String[] lines = output.split("\n");
        String lastLine = lines[lines.length - 1].trim();

        // 验证输出
        String expectedOutput1 = "the forest echoes";
        String expectedOutput2 = "the creek echoes";
        assertTrue(lastLine.equals(expectedOutput1) || lastLine.equals(expectedOutput2));
    }

    @Test
    public void test3() {
        String inputText = "and the";

        // 捕获输出流
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 调用生成新文本的方法
        Main.generateNewText(graph, inputText);

        // 提取输出
        String output = outContent.toString();

        // 提取输出最后一行
        String[] lines = output.split("\n");
        String lastLine = lines[lines.length - 1].trim();

        // 验证输出
        String expectedOutput = "and the";
        assertEquals(expectedOutput, lastLine);
    }

    @Test
    public void test4() {
        String inputText = "and the echoes song";

        // 捕获输出流
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 调用生成新文本的方法
        Main.generateNewText(graph, inputText);

        // 提取输出
        String output = outContent.toString();

        // 提取输出最后一行
        String[] lines = output.split("\n");
        String lastLine = lines[lines.length - 1].trim();

        // 验证输出
        String expectedOutput1 = "and the forest echoes the song";
        String expectedOutput2 = "and the creek echoes the song";
        assertTrue(lastLine.equals(expectedOutput1) || lastLine.equals(expectedOutput2));
    }

    @Test
    public void test5() {
        String inputText = "";

        // 捕获输出流
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 调用生成新文本的方法
        Main.generateNewText(graph, inputText);

        // 提取输出
        String output = outContent.toString();

        // 提取输出最后一行
        String[] lines = output.split("\n");
        String lastLine = lines[lines.length - 1].trim();

        // 验证输出
        String expectedOutput = "";
        assertEquals(expectedOutput, lastLine);
    }

    @Test
    public void test6() {
        String inputText = "the";

        // 捕获输出流
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 调用生成新文本的方法
        Main.generateNewText(graph, inputText);

        // 提取输出
        String output = outContent.toString();

        // 提取输出最后一行
        String[] lines = output.split("\n");
        String lastLine = lines[lines.length - 1].trim();

        // 验证输出
        String expectedOutput = "the";
        assertEquals(expectedOutput, lastLine);
    }

    @Test
    public void test7() {
        String inputText = "the funny";

        // 捕获输出流
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 调用生成新文本的方法
        Main.generateNewText(graph, inputText);

        // 提取输出
        String output = outContent.toString();

        // 提取输出最后一行
        String[] lines = output.split("\n");
        String lastLine = lines[lines.length - 1].trim();

        // 验证输出
        String expectedOutput = "the funny";
        assertEquals(expectedOutput, lastLine);
    }

    @Test
    public void test8() {
        String inputText = "and the ,,, echoes song ,,,";

        // 捕获输出流
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 调用生成新文本的方法
        Main.generateNewText(graph, inputText);

        // 提取输出
        String output = outContent.toString();

        // 提取输出最后一行
        String[] lines = output.split("\n");
        String lastLine = lines[lines.length - 1].trim();

        // 验证输出
        String expectedOutput = "and the ,,, echoes the song ,,,";
        assertEquals(expectedOutput, lastLine);
    }
}
