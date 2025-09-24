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
     * 	                    } catch (IllegalArgumentException exception) {
     *         		System.out.printf("[Error] " + exception.getMessage());
     *            }
     *         }
     *     }
     * </pre>
     *
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
    public <T> T run(Supplier<T> callback) {
        while (true) {
            try {
                return callback.get();
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR + exception.getMessage());
            }
        }
    }
}

