package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

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
        return null;
    }

    public List<Integer> getResult(List<Lotto> lottos) {
        return null;
    }

    public double calculateRate(List<Integer> ranks, int count) {
        return 0D;
    }
}
