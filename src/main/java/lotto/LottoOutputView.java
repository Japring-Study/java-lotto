package lotto;

import java.util.List;

public class LottoOutputView {

    public void printLotto(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for(Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printWinningStatistics(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank != LottoRank.NONE) {
                //println (X) print(X) printf(O)
                System.out.printf("%s - %d개\n", lottoRank.getDescription(), result.getCountForRank(lottoRank));
            }
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
