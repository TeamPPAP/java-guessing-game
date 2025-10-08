package guessing;

import java.util.Scanner;

/**
 * InputUtils provides user input handling functions
 * 사용자 입력 처리를 위한 유틸리티 함수들을 제공함
 */
public class InputUtils {

    /**
     * Get string input from user
     * 사용자로부터 문자열 입력을 받음
     *
     * @param scanner
     * @param prompt
     * @return
     */
    public static String getStringInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Get user confirmation (yes/no)
     * 유저의 확인을 받음 (yes/no)
     *
     * @param scanner
     * @param prompt
     * @return
     */
    public static boolean getYesNoConfirmation(Scanner scanner, String prompt) {
        System.out.print(prompt + " (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.startsWith("y");
    }

    /**
     * Get integer input with validation within a range
     * 주어진 정해진 범위 내의 정수를 입력받음
     *
     * @param scanner pre-defined reused scanner object
     * @param prompt  interactive message to explain
     * @param min     minimum value to set valid range
     * @param max     maximum value to set valid range
     * @return valid integer
     */
    public static int getIntegerInputWithRange(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt + " (" + min + "-" + max + "): ");
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}