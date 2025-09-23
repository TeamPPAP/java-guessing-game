package guessing;

import java.util.*;

/**
 * GameUtils provides common utility functions for guessing games
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
     * @param input
     * @return
     */
    public static String normalizeInput(String input) {
        // TODO
        return "";
    }

    /**
     * Get user confirmation (yes/no)
     * @param scanner
     * @param prompt
     * @return
     */
    public static boolean getYesNoConfirmation(Scanner scanner, String prompt) {
        // TODO
        return true;
    }

    /**
     * Get integer input with validation within a range
     * @param scanner
     * @param prompt
     * @param min
     * @param max
     * @return
     */
    public static int getIntegerInput(Scanner scanner, String prompt, int min, int max) {
       // TODO
        return 0;
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
     * @param width
     * @return
     */
    public static String createSeparator(int width) {
        // TODO
        return "";
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
