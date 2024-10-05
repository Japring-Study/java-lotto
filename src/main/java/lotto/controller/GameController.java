package lotto.controller;

import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;
import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final LottoInputView lottoInputView;
    private final LottoController lottoService;
    private final LottoOutputView lottoOutputView;

    public GameController() {
        this.lottoService = new LottoController();
        this.lottoOutputView = new LottoOutputView();
        this.lottoInputView = new LottoInputView();
    }

    /**
     * 게임 시작
     */
    public void start() {
        int money = lottoInputView.receiveUserMoneyInput();
        List<Lotto> lottoList = lottoService.generateLottoNumber(money / 1000);
        lottoOutputView.printLotto(lottoList.size(), lottoList.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList()));

        List<Integer> winningNumbers = lottoInputView.receiveWinningNumberInput();
        int bonusNumber = lottoInputView.receiveBonusNumberInput(winningNumbers);

        LottoResult result = lottoService.checkWinningResult(lottoList, winningNumbers, bonusNumber);
        lottoOutputView.printWinningStatistics(result.getRankDescriptions(), result.getRankCounts());

        double profitRate = lottoService.calculateProfitRate(money, result);
        lottoOutputView.printProfitRate(profitRate);
    }
}
