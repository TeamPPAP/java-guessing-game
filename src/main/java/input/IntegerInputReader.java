package input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerInputReader implements InputReader<Integer>{
    private final Scanner scanner;
    private final int minValue;
    private final int maxValue;

    // 생성자를 private
    private IntegerInputReader(Scanner scanner, int minValue, int maxValue) {
        this.scanner = scanner;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**
     * private 생성자 - 외부에서 직접 생성 불가
     *
     * [정적 팩토리 메서드 패턴 장점]
     * 1. 의미 있는 이름 제공: of(), forGame() 등 의도 명확
     * 2. 검증 로직 중앙화: 모든 생성이 팩토리 메서드를 거쳐 검증 보장
     * 3. 편의 메서드 제공: 자주 쓰는 설정을 메서드로 제공
     * 4. 객체 생성 통제: 필요시 캐싱, 싱글톤 적용 가능
     *
     * [public 생성자 사용 시 문제점]
     * - new IntegerInputReader(scanner, 100, 1) ← 잘못된 범위 객체 생성 가능
     * - 여러 곳에서 검증 로직 중복 작성
     * - 의도 불명확: new IntegerInputReader(scanner, 1, Integer.MAX_VALUE)
     */
    public static IntegerInputReader withRange(Scanner scanner, int minValue, int maxValue) {
        if (minValue > maxValue) {
            throw new IllegalArgumentException("최소값은 최대값보다 클 수 없습니다.");
        }
        return new IntegerInputReader(scanner, minValue, maxValue);
    }

    @Override
    public Integer read() {
        int input;
        while (true){
            try {
                input = scanner.nextInt();

                if(minValue > input || input > maxValue){
                    System.out.println("유효 범위를 벗어났습니다. " + minValue + " ~ " + maxValue + "사이의 정수만 입력할 수 있습니다." );
                    continue;
                }

                return input;
            }  catch (InputMismatchException e) {
                System.out.println(e.getMessage() + "❌ 올바른 숫자를 입력하세요.");
                scanner.next();
            }
        }


    }
}
