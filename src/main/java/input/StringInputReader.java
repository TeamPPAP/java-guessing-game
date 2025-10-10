package input;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringInputReader implements InputReader<String>{
    private final Scanner scanner;
    private final List<String> allowedValues;

    private StringInputReader(Scanner scanner, List<String> allowedValues) {
        this.scanner = scanner;
        this.allowedValues = allowedValues.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static StringInputReader withAllowedValues(Scanner scanner, List<String> allowedValues ) {
        if (allowedValues == null || allowedValues.isEmpty()) {
            throw new IllegalArgumentException("허용된 값을 최소 1개 이상 지정해야 합니다.");
        }
        return new StringInputReader(scanner, allowedValues);
    }

    @Override
    public String read() {
        while (true){
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.isEmpty()) {
                System.out.println("❌ 입력이 비어있습니다.");
                continue;
            }

            if(!allowedValues.contains(input)){
                System.out.println("유효 범위를 벗어났습니다. " + allowedValues.toString() + "중 하나를 입력해주세요." );
                continue;
            }

            return input;

        }
    }
}
