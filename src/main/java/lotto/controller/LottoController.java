package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    /**
     * 6개의 숫자 생성
     */
    public List<Lotto> generateLottoNumber(int count) {
        List<Lotto> result = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            result.add(new Lotto(numbers));
        }
        return result;
    }

    public LottoResult checkWinningResult(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottoList) {
            int matchCount = lotto.matchCount(winningNumbers);
            boolean bonusMatch = lotto.contains(bonusNumber);
            result.addResult(LottoRank.getRank(matchCount, bonusMatch));
        }
        return result;
    }

    public double calculateProfitRate(int money, LottoResult result) {
        long totalPrize = result.getTotalPrize();
        return (totalPrize * 100.0) / money;
    }
}
