package lotto.controller;

import lotto.InputView;
import lotto.Lotto;
import lotto.domain.Bonus;
import lotto.domain.Budget;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.domain.strategy.LottoGenerateStrategy;
import lotto.domain.strategy.LottoGenerator;
import lotto.domain.strategy.UserLottoGenerateStrategy;
import lotto.domain.strategy.WinningLottoGenerateStrategy;

public class LottoController {
    private Budget budget;
    private LottoGenerator lottoGenerator = new LottoGenerator();

    public void runMachine() {
        final Lottos userLottos = buyLotto();
        final WinningLotto winningLotto = drawLotto();
    }

    private Lottos buyLotto() {
        try {
            budget = Budget.from(InputView.getBudgetInput());
            setLottoGeneratorStrategy(new UserLottoGenerateStrategy());
            Lottos userMultipleLottos = lottoGenerator.generateLottosByBudget(budget);
            return userMultipleLottos;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLotto();
        }
    }

    private WinningLotto drawLotto() {
        try {
            final Lotto lotto = getWinningLotto();
            final Bonus bonus = getBonus();
            return WinningLotto.of(lotto, bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return drawLotto();
        }
    }

    private Lotto getWinningLotto() {
        try {
            InputView.printRequireWinningNumbersMessage();
            setLottoGeneratorStrategy(new WinningLottoGenerateStrategy());
            return lottoGenerator.generateLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    private Bonus getBonus(){
        try {
            return Bonus.from(InputView.getBonusInput());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getBonus();
        }
    }

    public void setLottoGeneratorStrategy(LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoGenerator.setLottoGenerateStrategy(lottoGenerateStrategy);
    }
}
