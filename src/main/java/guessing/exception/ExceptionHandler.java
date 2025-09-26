package guessing.exception;

import java.util.function.Supplier;

public class ExceptionHandler {

    private static final String ERROR = "[ERROR] ";

    /**
     * 다음의 try-catch 로직을 함수형으로 변경할 수 있습니다.
     * <pre>
     *     private LottoPurchaseMoney askPurchaseMoney() {
     *     	while (true) {
     * 	    	try {
     * 	        	int money = inputView.askPurchaseMoney();
     * 	            return new LottoPurchaseMoney(money);
     *                        } catch (IllegalArgumentException exception) {
     *         		System.out.printf("[Error] " + exception.getMessage());
     *            }
     *         }
     *     }
     * </pre>
     * <p>
     * 변경된 메소드
     *
     * <pre>
     *     private LottoPurchaseMoney askPurchaseMoney() {
     *     	return exceptionHandler.run(() -> {
     *         	int money = inputView.askPurchaseMoney();
     *             return new LottoPurcahseMoney(money);
     *         });
     *     }
     * </pre>
     */
    public <T> T executeWithRetry(Supplier<T> callback) {
        while (true) {
            try {
                return callback.get();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }

    public <T> T run(Supplier<T> callback) {
        try {
            return callback.get();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR + "잘못된 입력을 하셨습니다. 다시 입력해주세요.");
            return null;
        }
    }

    public void cause(boolean flag) {
        if (flag) {
            throw new IllegalStateException("잘못된 입력을 하셨습니다. 다시 입력해주세요.");
        }
    }
}

