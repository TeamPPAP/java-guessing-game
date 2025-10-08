package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    Game game;

    private final List<Player> players = new ArrayList<>(); // 각 플레이어별 기록을 쌓을 그릇
    private final static Scanner sc = new Scanner(System.in);

    public void run () {
        boolean shouldShutdown = false;
        int tries = 0;
        do {
            startRound();

            int partySize = promptPartySize(); // Player 수 입력받기

            for (int i = 0; i < partySize; i++) {
                Player p = createPlayer();
                tries = game.run(); // 맞추면 시도 횟수, 못 맞추면 -1

                recordAttemptAndAdd(p, tries);

                handleOutCome(tries);
            }

            // TODO 최종 우승자 발표
            announceWinner(players);

            // TODO OR 연산의 특징에 따른 소스 개선 필요 - isGameOver가 true면 askPlayAgain를 아예 실행하지 않는다.
            shouldShutdown = !askPlayAgain();
            if (shouldShutdown) {
                System.out.println("게임이 종료되었습니다.");
            }
        } while (!shouldShutdown);
    }

    // TODO 플레이어 청소 및 게임 생성
    public void startRound() {
        this.players.clear();
        this.game = new Game();
        Player.resetSequence();
    }

    // TODO 플레이어 생성
    public Player createPlayer() {
        Player p = new Player(); // 매번 새로 플레이어 생성
        System.out.println("== PLAYER ["+ p.getId() + "]번 시작! ==");
        return p;
    }

    // TODO 플레이어별 레코드 기록, LIST 에 플레이어 추가
    public void recordAttemptAndAdd(Player p, int tries) {
        p.recordAttempt(tries);
        players.add(p);
    }

    public boolean askPlayAgain(){
        boolean result = false;
        System.out.println("\n한판 더 하시겠습니까❓ [Y/N]");

        try {
            String answer = sc.nextLine().toUpperCase();

            result = answer.equals("Y");

            if(Arrays.asList("Y", "N").contains(result))
                throw new IllegalArgumentException("[Y/N] 이 아닌 다른 값을 입력하였습니다.");
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            return result;
        }

    }

    // TODO 플레이어 수 입력
    public int promptPartySize() {
        System.out.println("게임에 참여할 인원 수는 몇명인가요?:");
        return sc.nextInt();
    }

    // TODO 우승자 출력
    public void announceWinner(List<Player> players) {
        Player winner = findMinTries(players);
        if (winner != null) {
            System.out.println("우승자는 [" + winner.getId() + "]번 플레이어 입니다");
        }
        System.out.println("우승자가 없습니다.");
    }

    // TODO 우승자 계산
    public Player findMinTries(List<Player> players) {
        int min = Integer.MAX_VALUE;
        Player winner = null;

        for (Player p : players) {
            int t = p.latestTries();
            if (t > 0 && t < min) {
                min = t;
                winner = p;
            }
        }
        return winner;
    }

    // TODO 진행 결과 출력
    public void handleOutCome(int tries) {
        if (tries > 0) {
            System.out.println(tries + "번 만에 맞췄습니다.1\n");
            return; // 가드 리턴
        }

        if (game.isGameOver()) {
            System.out.println("Game Over❗ (정답 : "+game.getAnswerNumber()+")");
            return;
        }
    }
}
