package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Seller {

    private final int lottoPrice;

    public Seller(int lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public int calculateLottoCount(int money) {
        return 0;
    }

    public Lotto getLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<Lotto> getLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> getLotto())
                .collect(Collectors.toList());
    }

    public List<Integer> getResult(List<Lotto> lottos) {
        return null;
    }

    public double calculateRate(List<Integer> ranks, int count) {
        return 0D;
    }
}
