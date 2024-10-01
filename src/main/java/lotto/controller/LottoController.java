package lotto.controller;

import lotto.view.InputView;
import lotto.domain.Lotto;
import lotto.domain.*;
import lotto.domain.strategy.LottoGenerateStrategy;
import lotto.domain.strategy.LottoGenerator;
import lotto.domain.strategy.UserLottoGenerateStrategy;
import lotto.domain.strategy.WinningLottoGenerateStrategy;
import lotto.view.OutputView;

public class LottoController {
    private Budget budget;
    private LottoGenerator lottoGenerator = new LottoGenerator();

    public void runMachine() {
        final Lottos userLottos = buyLotto();
        final WinningLotto winningLotto = drawLotto();
        final WinningStatistics winningStatistics = makeStatistics(userLottos, winningLotto);
        OutputView.printWinningStaticstics(winningStatistics);
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

    private WinningStatistics makeStatistics(final Lottos userLottos, final WinningLotto winningLotto) {
        return WinningStatistics.of(userLottos, winningLotto, budget);
    }

    public void setLottoGeneratorStrategy(final LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoGenerator.setLottoGenerateStrategy(lottoGenerateStrategy);
    }
}
