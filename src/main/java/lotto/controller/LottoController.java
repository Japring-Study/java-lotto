package lotto.controller;

import lotto.InputView;
import lotto.domain.Budget;
import lotto.domain.Lottos;
import lotto.domain.strategy.LottoGenerateStrategy;
import lotto.domain.strategy.LottoGenerator;
import lotto.domain.strategy.UserLottoGenerateStrategy;

public class LottoController {
    private Budget budget;
    private LottoGenerator lottoGenerator = new LottoGenerator();

    public void runMachine() {
        final Lottos userLottos = buyLotto();
    }

    private Lottos buyLotto() {
        try {
            budget = Budget.from(InputView.getBudgetInput());
            setLottoGeneratorStrategy(new UserLottoGenerateStrategy());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLotto();
        }
    }

    public void setLottoGeneratorStrategy(LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoGenerator.setLottoGenerateStrategy(lottoGenerateStrategy);
    }
}
