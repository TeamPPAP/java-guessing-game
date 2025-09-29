package guessing;

import java.util.*;

/**
 * GameUtils provides common utility functions for games
 * GameUtils 클래스는 게임을 진행하면서 필요한 공통적인 유틸리티 함수들을 제공함
 */
public class GameUtils {

    /**
     * Get string input
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
     * Get integer input without validation within a range
     * 정수를 입력 받는 함수
     * @param scanner
     * @param prompt
     * @return
     */
    public static int getIntegerInput(Scanner scanner,String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid number");
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
        if (width < title.length() + 4) {
            width = title.length() + 4;
        }
        StringBuilder header = new StringBuilder();
        String border = "=".repeat(width);
        header.append(border).append("\n");
        int padding = (width - title.length()) / 2;
        String leftPad = " ".repeat(padding);
        String rightPad = " ".repeat(width - title.length() - padding);
        header.append(leftPad).append(title).append(rightPad).append("\n");
        header.append(border);
        return header.toString();
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
    public static String getPerformanceRating(int winPercentage) {
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

}
