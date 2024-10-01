package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Seller {

    private final int lottoPrice;
    private static final List<Integer> prize = List.of(2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000, 0);

    public Seller(int lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public int calculateLottoCount(int money) {
        return money / lottoPrice;
    }

    public Lotto getLotto() {
        List<Integer> randoms = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(randoms);
        return new Lotto(randoms);
    }

    public List<Lotto> getLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> getLotto())
                .collect(Collectors.toList());
    }

    public List<Integer> getResult(List<Lotto> lottos, List<Integer> answers, int bonus) {
        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));

        for (Lotto lotto: lottos) {
            int index = lotto.calculateRank(answers, bonus) - 1;
            result.set(index, result.get(index) + 1);
        }
        return result;
    }

    public BigDecimal calculateRate(List<Integer> ranks, int count) {

        long prizeSum = IntStream.range(0, 6)
                .mapToLong(index -> (long) ranks.get(index) * prize.get(index))
                .sum();
        int cost = lottoPrice * count;

        double rate = prizeSum * 100 / (double) cost;
        return new BigDecimal(rate).setScale(1, BigDecimal.ROUND_HALF_UP);
    }
}
