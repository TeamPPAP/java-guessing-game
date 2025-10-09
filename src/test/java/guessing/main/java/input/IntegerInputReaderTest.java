package guessing.main.java.input;

import input.IntegerInputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

class IntegerInputReaderTest {
    /**
     * Scanner에 가짜 입력을 주입하는 헬퍼 메서드
     */
    private Scanner createScannerWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        return new Scanner(in);
    }

    @Test
    @DisplayName("정상적인 범위의 정수 입력 테스트")
    void testValidInput() {
        // Given: 50을 입력으로 준비
        Scanner scanner = createScannerWithInput("50");
        IntegerInputReader reader = IntegerInputReader.withRange(scanner, 1, 100);

        // When: 입력 읽기
        Integer result = reader.read();

        // Then: 50이 반환되어야 함
        Assertions.assertEquals(Integer.valueOf(50), result);

    }

    @Test
    @DisplayName("비정상적인 범위의 정수 입력 테스트")
    void testWithOutRangeValidInput() {
        // Given: 50을 입력으로 준비
        Scanner scanner = createScannerWithInput("200");
        IntegerInputReader reader = IntegerInputReader.withRange(scanner, 1, 100);

        // When: 입력 읽기
        Integer result = reader.read();

        // Then: 50이 반환되어야 함
        Assertions.assertEquals(Integer.valueOf(50), result);

    }
}
