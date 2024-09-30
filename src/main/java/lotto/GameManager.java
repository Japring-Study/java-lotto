package lotto;

import java.util.List;

public class GameManager {
    private final LottoInputView lottoInputView;
    private final LottoService lottoService;
    private final LottoOutputView lottoOutputView;

    public GameManager() {
        this.lottoService = new LottoService();
        this.lottoOutputView = new LottoOutputView();
        this.lottoInputView = new LottoInputView();
    }

    /**
     * 게임 시작
     */
    public void start() {
        int money = lottoInputView.receiveUserMoneyInput();
        List<Lotto> lottoList = lottoService.generateLottoNumber(money / 1000);
        lottoOutputView.printLotto(lottoList);

        List<Integer> winningNumbers = lottoInputView.receiveWinningNumberInput();
        int bonusNumber = lottoInputView.receiveBonusNumberInput(winningNumbers);

        LottoResult result = lottoService.checkWinningResult(lottoList, winningNumbers, bonusNumber);
        lottoOutputView.printWinningStatistics(result);

        double profitRate = lottoService.calculateProfitRate(money, result);
        lottoOutputView.printProfitRate(profitRate);
    }
}
