package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        int purchaseMoney = UI.receivePurchaseMoney();
        Seller seller = new Seller(1000);

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
