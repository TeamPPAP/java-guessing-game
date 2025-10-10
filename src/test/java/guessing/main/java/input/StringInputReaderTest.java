package guessing.main.java.input;

import input.StringInputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

class StringInputReaderTest {

    private Scanner createScannerWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        return new Scanner(in);
    }

    @Test
    @DisplayName("정상 입력 테스트 - Y")
    void testValidInputY() {
        Scanner scanner = createScannerWithInput("Y");
        StringInputReader reader = StringInputReader.withAllowedValues(
                scanner,
                Arrays.asList("Y", "N")
        );

        String result = reader.read();

        Assertions.assertEquals("Y", result);
    }

    @Test
    @DisplayName("정상 입력 테스트 - N")
    void testValidInputN() {
        Scanner scanner = createScannerWithInput("N");
        StringInputReader reader = StringInputReader.withAllowedValues(
                scanner,
                Arrays.asList("Y", "N")
        );

        String result = reader.read();

        Assertions.assertEquals("N", result);
    }

    @Test
    @DisplayName("소문자 입력 테스트 - 대문자로 변환")
    void testLowercaseInput() {
        Scanner scanner = createScannerWithInput("y");
        StringInputReader reader = StringInputReader.withAllowedValues(
                scanner,
                Arrays.asList("Y", "N")
        );

        String result = reader.read();

        Assertions.assertEquals("Y", result);
    }

    @Test
    @DisplayName("잘못된 입력 후 정상 입력 테스트")
    void testInvalidThenValidInput() {
        Scanner scanner = createScannerWithInput("A\nY");
        StringInputReader reader = StringInputReader.withAllowedValues(
                scanner,
                Arrays.asList("Y", "N")
        );

        String result = reader.read();

        Assertions.assertEquals("Y", result);
    }

    @Test
    @DisplayName("여러 번 잘못된 입력 후 정상 입력 테스트")
    void testMultipleInvalidThenValidInput() {
        Scanner scanner = createScannerWithInput("A\nB\nC\nN");
        StringInputReader reader = StringInputReader.withAllowedValues(
                scanner,
                Arrays.asList("Y", "N")
        );

        String result = reader.read();

        Assertions.assertEquals("N", result);
    }

    @Test
    @DisplayName("빈 입력 후 정상 입력 테스트")
    void testEmptyThenValidInput() {
        Scanner scanner = createScannerWithInput("\nY");
        StringInputReader reader = StringInputReader.withAllowedValues(
                scanner,
                Arrays.asList("Y", "N")
        );

        String result = reader.read();

        Assertions.assertEquals("Y", result);
    }

    @Test
    @DisplayName("공백 포함 입력 테스트 - trim 처리")
    void testInputWithSpaces() {
        Scanner scanner = createScannerWithInput("  Y  ");
        StringInputReader reader = StringInputReader.withAllowedValues(
                scanner,
                Arrays.asList("Y", "N")
        );

        String result = reader.read();

        Assertions.assertEquals("Y", result);
    }

    @Test
    @DisplayName("빈 allowedValues로 생성 시 예외 발생")
    void testEmptyAllowedValuesThrowsException() {
        Scanner scanner = createScannerWithInput("Y");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringInputReader.withAllowedValues(scanner, Arrays.asList());
        });
    }

    @Test
    @DisplayName("null allowedValues로 생성 시 예외 발생")
    void testNullAllowedValuesThrowsException() {
        Scanner scanner = createScannerWithInput("Y");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringInputReader.withAllowedValues(scanner, null);
        });
    }
}