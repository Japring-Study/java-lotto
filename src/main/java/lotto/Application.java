package lotto;

import java.util.List;

public class Application {

    public static final int LOTTO_PRICE = 1_000;

    public static void main(String[] args) {

        int purchaseMoney = UI.receivePurchaseMoney();
        Seller seller = new Seller(LOTTO_PRICE);

        int purchaseCount = seller.calculateLottoCount(purchaseMoney);
        List<Lotto> lottos = seller.getLottos(purchaseCount);
        UI.printBoughtLottos(lottos);

        List<Integer> answers = UI.receiveAnswers();
        int bonus = UI.receiveBonus();

        List<Integer> result = seller.getResult(lottos, answers, bonus);
        UI.printResult(result);
        UI.printRate(seller.calculateRate(result, purchaseCount));
    }
}
