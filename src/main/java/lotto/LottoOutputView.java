package lotto;

import java.util.List;

public class LottoOutputView {

    public void printLotto(int numberOfLotto, List<List<Integer>> lottoNumbersList) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        for (List<Integer> lottoNumbers : lottoNumbersList) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public void printWinningStatistics(List<String> rankDescriptions, List<Integer> rankCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < rankDescriptions.size(); i++) {
            System.out.printf("%s - %d개\n", rankDescriptions.get(i), rankCounts.get(i));
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
