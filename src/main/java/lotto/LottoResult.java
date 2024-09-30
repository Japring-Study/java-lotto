package lotto;

import java.util.HashMap;

public class LottoResult {
    private final HashMap<LottoRank, Integer> rankCounts;

    public LottoResult() {
        this.rankCounts = new HashMap<LottoRank, Integer>();
        for (LottoRank lottoRank : LottoRank.values()) {
            rankCounts.put(lottoRank, 0);
        }
    }

    public void addResult(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1); //현재 랭크 갯수보다 하나 업
    }

    public int getCountForRank(LottoRank lottoRank) {
        return rankCounts.get(lottoRank);
    }

    public long getTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
