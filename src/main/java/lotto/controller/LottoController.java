package lotto.controller;

import lotto.domain.Budget;

public class LottoController {
    private Budget budget;

    public void runMachine() {
        buyLotto();
    }

    private void buyLotto() {
        try {

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLotto();
        }
    }
}
