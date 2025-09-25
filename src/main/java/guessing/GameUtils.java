package guessing;

import java.util.*;

/**
 * GameUtils provides common utility functions for games
 * GameUtils 클래스는 게임을 진행하면서 필요한 공통적인 유틸리티 함수들을 제공함
 */
public class GameUtils {

    /**
     * Validate if input is a single letter
     * @param input
     * @return
     */
    public static boolean isValidLetter(String input) {
        // TODO
        return true;
    }

    /**
     * Validate if input is a word of specific length containing only letters
     * @param input
     * @param expectedLength
     * @return
     */
    public static boolean isValidWord(String input, int expectedLength) {
        // TODO
        return true;
    }

    /**
     * Convert string to uppercase and trim whitespace
     * 스트링을 모두 대문자로 변환하고 공백, 개행문자들을 제거함
     * @param input
     * @return
     */
    public static String normalizeInput(String input) {
        // TODO
        return "";
    }

    /**
     * Get user confirmation (yes/no)
     * 유저의 확인을 받음 (yes/no)
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
     * @param scanner pre-defined reused scanner object
     * @param prompt interactive message to explain
     * @param min minimum value to set valid range
     * @param max maximum value to set valid range
     * @return valid integer
     */
    public static int getIntegerInput(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt + " (" + min + "-" + max + "): ");
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    /**
     * Create a formatted header with title
     * @param title
     * @param width
     * @return
     */
    public static String createHeader(String title, int width) {
        // TODO
        return "";
    }

    /**
     * Create a simple separator line
     * 콘솔 화면에 구분선을 생성
     * @param width
     * @return
     */
    public static String createSeparator(int width) {
        return "=".repeat(width);
    }

    /**
     * Format time duration from milliseconds to readable string
     * @param milliseconds
     * @return
     */
    public static String formatDuration(long milliseconds) {
        // TODO
        return "";
    }

    /**
     * Generate a random encouragement message for wins
     * 게임에서 승리했을때 보여줄 랜덤 메시지를 생성함
     * @return
     */
    public static String getRandomWinMessage() {
        String[] messages = {
                "Excellent work!",
                "Well done!",
                "Fantastic!",
                "Outstanding!",
                "Great job!",
                "Superb!",
                "Brilliant!",
                "Amazing!",
                "Perfect!",
                "Incredible!"
        };
        Random random = new Random();
        return messages[random.nextInt(messages.length)];
    }

    /**
     * Generate a random encouragement message for losses
     * 게임에서 패배했을때 보여줄 랜덤 메시지를 생성함
     * @return
     */
    public static String getRandomLoseMessage() {
        String[] messages = {
                "Don't give up!",
                "You'll get it next time!",
                "Keep trying!",
                "Practice makes perfect!",
                "Better luck next time!",
                "You're getting better!",
                "Almost there!",
                "Keep going!",
                "You've got this!",
                "Try again!"
        };
        Random random = new Random();
        return messages[random.nextInt(messages.length)];
    }

    /**
     * Convert win percentage to performance rating
     * 승리 비율을 아이콘으로 변환함
     * @param winPercentage
     * @return
     */
    public static String getPerformanceRating(double winPercentage) {
        if (winPercentage >= 90) {
            return "🏆 Master";
        } else if (winPercentage >= 80) {
            return "🥇 Expert";
        } else if (winPercentage >= 70) {
            return "🥈 Advanced";
        } else if (winPercentage >= 60) {
            return "🥉 Skilled";
        } else if (winPercentage >= 50) {
            return "📈 Improving";
        } else if (winPercentage >= 30) {
            return "🎯 Learning";
        } else {
            return "🌱 Beginner";
        }
    }

    /**
     * Clear the console (works on most terminals)
     * 콘솔창의 텍스트들을 모두 지움
     */
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[2J\033[H");
                System.out.flush();
            }
        } catch (Exception e) {
            // If clearing fails, just print some newlines
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }


}
