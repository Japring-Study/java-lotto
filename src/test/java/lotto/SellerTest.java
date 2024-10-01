package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SellerTest {

    @DisplayName("받은 금액을 lottoPrice로 나눈 몫을 반환한다.")
    @Test
    void calculateLottoCount() {
        //given
        final int lottoPrice = 1_000;
        Seller seller = new Seller(lottoPrice);
        int money = 10_000;

        //when
        int count = seller.calculateLottoCount(money);

        //then
        assertThat(count).isEqualTo(10);
    }

    @DisplayName("random한 Lotto 한 개 반환")
    @Test
    void getLotto() {
        //given
        List<Integer> answers = List.of(8, 21, 23, 41, 42, 43);
        final int lottoPrice = 1_000;
        Seller seller = new Seller(lottoPrice);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    //when
                    Lotto lotto = seller.getLotto();

                    //then
                    int rank = lotto.calculateRank(answers, -1);
                    assertThat(rank).isEqualTo(1);
                },
                answers
        );
    }

    @DisplayName("발행된 로또는 오름차순이어야한다.")
    @Test
    void getLotto_Ascending() {
        //given
        List<Integer> answers = List.of(8, 21, 23, 41, 42, 43);
        List<Integer> unsortedAnswers = List.of(42, 21, 43, 41, 8, 23);
        final int lottoPrice = 1_000;
        Seller seller = new Seller(lottoPrice);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    //when
                    Lotto lotto = seller.getLotto();

                    //then
                    assertThat(lotto.toString()).isEqualTo(answers.toString());
                },
                unsortedAnswers
        );
    }

    @DisplayName("개수만큼의 로또를 반환한다.")
    @Test
    void getLottos() {
        //given
        int count = 10;
        final int lottoPrice = 1_000;
        Seller seller = new Seller(lottoPrice);

        //when
        List<Lotto> lottos = seller.getLottos(10);

        //then
        assertThat(lottos.size()).isEqualTo(count);
    }

    @DisplayName("반환된 길이는 6이다.")
    @Test
    void getResult_length() {
        //given
        final int lottoPrice = 1_000;
        Seller seller = new Seller(lottoPrice);

        //when
        List<Integer> result = seller.getResult(List.of(), List.of(), -1);

        //then
        assertThat(result.size()).isEqualTo(6);
    }

    @DisplayName("1~6등의 개수를 반환한다.")
    @Test
    void getResult() {
        //given
        List<Integer> answers = List.of(8, 21, 23, 41, 42, 43);
        List<Integer> second = List.of(8, 21, 23, 41, 42, 44);
        final int lottoPrice = 1_000;
        Seller seller = new Seller(lottoPrice);

        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> lottos = seller.getLottos(2);

                    //when
                    List<Integer> result = seller.getResult(lottos, answers, 44);

                    //then
                    assertThat(result.equals(List.of(1, 1, 0, 0, 0, 0))).isTrue();
                },
                answers,
                second
        );
    }

    @DisplayName("수익률을 계산해 반환한다.")
    @Test
    void calculateRate() {
        //given
        List<Integer> result = List.of(1, 1, 0, 0, 0, 0);
        int count = 2;
        double expectedRate = (2_000_000_000 + 30_000_000) / (double) 2_000 * 100;

        final int lottoPrice = 1_000;
        Seller seller = new Seller(lottoPrice);

        //when
        BigDecimal rate = seller.calculateRate(result, count);

        //then
        assertThat(rate.doubleValue()).isEqualTo(expectedRate);
    }

    @DisplayName("수익률은 소수점 둘째자리에서 반올림")
    @Test
    void calculateRate_decimal() {
        //given
        List<Integer> result = List.of(1, 1, 0, 0, 0, 0);
        int count = 3;

        final int lottoPrice = 1_000;
        Seller seller = new Seller(lottoPrice);

        //when
        BigDecimal rate = seller.calculateRate(result, count);

        //then
        assertThat(rate.toPlainString().split("\\.")[1].length()).isEqualTo(1);
    }
}