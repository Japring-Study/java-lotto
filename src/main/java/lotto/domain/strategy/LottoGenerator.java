package lotto.domain.strategy;

import lotto.Lotto;
import lotto.domain.Budget;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private LottoGenerateStrategy lottoGenerateStrategy;

    public Lotto generateLotto() {
        return lottoGenerateStrategy.generate();
    }

    public Lottos generateLottosByBudget(Budget budget) {
        final int countOfLottoLine = budget.getCountOfLottoLines();
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countOfLottoLine; i++) {
            lottos.add(generateLotto());
        }
        return Lottos.from(lottos);
    }

    public void setLottoGenerateStrategy(LottoGenerateStrategy lottoGenerateStrategy) {
        this.lottoGenerateStrategy = lottoGenerateStrategy;
    }
}
