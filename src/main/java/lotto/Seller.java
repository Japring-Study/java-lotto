package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Seller {

    private final int lottoPrice;

    public Seller(int lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public int calculateLottoCount(int money) {
        return money / lottoPrice;
    }

    public Lotto getLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
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

    public double calculateRate(List<Integer> ranks, int count) {
        return 0D;
    }
}
