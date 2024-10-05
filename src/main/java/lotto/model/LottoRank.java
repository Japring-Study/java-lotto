package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    NONE(0, 0, "");

    private final int matchCount;
    private final int prize;
    private final String description;

    LottoRank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static LottoRank getRank(int count, boolean bonusMatch) {
        return Arrays.stream(values()) //모든 LottoRank 값을 스트림으로 변환
                .filter(rank -> rank.matchCount == count)
                .filter(rank -> rank != SECOND || (rank == SECOND && bonusMatch))
                .findFirst()
                .orElse(NONE);
    }

    public String getDescription() {
        return description;
    }

    public long getPrize() {
        return prize;
    }
}
