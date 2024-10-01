package lotto.domain;

public class Budget {
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 숫자만 입력할 수 있습니다.";
    private static final String DIVIDE_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 %d원 단위로 나누어 떨어져야합니다.";
    private static final String MINIMUM_PRICE_EXCEPTION_MESSAGE = "[ERROR] 로또 구입 최소 금액은 %d원 입니다.";
    private static final int LOTTO_UNIT_PRICE = 1000;
    private static final int ZERO = 0;
    private final int budget;

    private Budget(final int budget) {
        this.budget = budget;
    }

    public static Budget from(final String inputBudget) {
        int budget = Integer.parseInt(inputBudget);
        return new Budget(budget);
    }
}
