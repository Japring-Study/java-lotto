package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private static final int LOTTO_MIN_NUMBER = 1;         // 로또 번호의 최소값
    private static final int LOTTO_MAX_NUMBER = 45;        // 로또 번호의 최대값
    private static final int LOTTO_NUMBER_COUNT = 6;       // 로또 번호의 개수
    private static final double PERCENTAGE_CONVERSION = 100.0; // 수익률 계산 비율

    /**
     * 로또 번호 생성
     */
    public List<Lotto> generateLottoNumber(int count) {
        List<Lotto> result = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
            result.add(new Lotto(numbers));
        }
        return result;
    }

    /**
     * 당첨 결과 확인
     */
    public LottoResult checkWinningResult(List<Lotto> lottoList, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottoList) {
            int matchCount = lotto.matchCount(winningNumbers);
            boolean bonusMatch = lotto.contains(bonusNumber);
            result.addResult(LottoRank.findMatchingRank(matchCount, bonusMatch));
        }
        return result;
    }

    /**
     * 수익률 계산
     */
    public double calculateProfitRate(int money, LottoResult result) {
        long totalPrize = result.getTotalPrize();
        return (totalPrize * PERCENTAGE_CONVERSION) / money;
    }
}
