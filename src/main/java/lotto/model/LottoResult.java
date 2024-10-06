package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final HashMap<LottoRank, Integer> rankCounts;

    public LottoResult() {
        this.rankCounts = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            rankCounts.put(lottoRank, 0);
        }
    }

    /**
     * 당첨 결과를 추가
     */
    public void addResult(LottoRank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1); //현재 랭크 갯수보다 하나 업
    }

    /**
     * 특정 랭크의 당첨 개수 반환
     */
    public int getCountForRank(LottoRank lottoRank) {
        return rankCounts.get(lottoRank);
    }

    /**
     * 전체 상금 합계 반환
     */
    public long getTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    /**
     * 랭크 설명을 역순으로 반환
     */
    public List<String> getRankDescriptions() {
        return rankCounts.keySet().stream()
                .filter(rank -> rank != LottoRank.NONE) // NONE 랭크 제외
                .sorted((r1, r2) -> r2.ordinal() - r1.ordinal()) // 역순 정렬 (ordinal 값을 기준으로)
                .map(LottoRank::getDescription) // 각 랭크의 설명 문자열 추출
                .collect(Collectors.toList());
    }

    /**
     * 각 랭크의 당첨 개수를 역순으로 반환
     */
    public List<Integer> getRankCounts() {
        return rankCounts.entrySet().stream()
                .filter(entry -> entry.getKey() != LottoRank.NONE) // NONE 랭크 제외
                .sorted((entry1, entry2) -> entry2.getKey().ordinal() - entry1.getKey().ordinal()) // 역순 정렬 (ordinal 값을 기준으로)
                .map(Map.Entry::getValue) // 각 랭크의 개수만 추출
                .collect(Collectors.toList());
    }
}
