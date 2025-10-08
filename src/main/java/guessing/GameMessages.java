package guessing;

import java.util.Random;

/**
 * GameMessages provides game-related message and formatting functions
 * 게임 관련 메시지 생성 및 UI 포맷팅 함수들을 제공함
 */
public class GameMessages {

    /**
     * Create a formatted header with title
     * 제목이 있는 서식화된 헤더를 생성
     *
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
     *
     * @param width
     * @return
     */
    public static String createSeparator(int width) {
        return "=".repeat(width);
    }

    /**
     * Generate a random encouragement message for wins
     * 게임에서 승리했을때 보여줄 랜덤 메시지를 생성함
     *
     * @return
     */
    public static String getRandomWinMessage() {
        String[] messages = {"Excellent work!", "Well done!", "Fantastic!", "Outstanding!", "Great job!", "Superb!", "Brilliant!", "Amazing!", "Perfect!", "Incredible!"};
        Random random = new Random();
        return messages[random.nextInt(messages.length)];
    }

    /**
     * Generate a random encouragement message for losses
     * 게임에서 패배했을때 보여줄 랜덤 메시지를 생성함
     *
     * @return
     */
    public static String getRandomLoseMessage() {
        String[] messages = {"Don't give up!", "You'll get it next time!", "Keep trying!", "Practice makes perfect!", "Better luck next time!", "You're getting better!", "Almost there!", "Keep going!", "You've got this!", "Try again!"};
        Random random = new Random();
        return messages[random.nextInt(messages.length)];
    }

    /**
     * Convert win percentage to performance rating
     * 승리 비율을 아이콘으로 변환함
     *
     * @param winPercentage
     * @return
     */
    public static String getPerformanceRating(int winPercentage) {
        if (winPercentage >= 90) {
            return "🏆 Master";
        }
        if (winPercentage >= 80) {
            return "🥇 Expert";
        }
        if (winPercentage >= 70) {
            return "🥈 Advanced";
        }
        if (winPercentage >= 60) {
            return "🥉 Skilled";
        }
        if (winPercentage >= 50) {
            return "📈 Improving";
        }
        if (winPercentage >= 30) {
            return "🎯 Learning";
        }
        return "🌱 Beginner";
    }
}