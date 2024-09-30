package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개 일치하면, 1을 반환한다.")
    @Test
    void calculateRank_1st() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> answers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        //when
        int rank = lotto.calculateRank(answers, bonus);

        //then
        assertThat(rank).isEqualTo(1);
    }

    @DisplayName("5개 일치하고, 보너스 볼 일치하면, 2을 반환한다.")
    @Test
    void calculateRank_2nd() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> answers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        //when
        int rank = lotto.calculateRank(answers, bonus);

        //then
        assertThat(rank).isEqualTo(2);
    }

    @DisplayName("5개 일치하면, 3을 반환한다.")
    @Test
    void calculateRank_3rd() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        List<Integer> answers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        //when
        int rank = lotto.calculateRank(answers, bonus);

        //then
        assertThat(rank).isEqualTo(3);
    }

    @DisplayName("4개 일치하면, 4을 반환한다.")
    @Test
    void calculateRank_4th() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        List<Integer> answers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        //when
        int rank = lotto.calculateRank(answers, bonus);

        //then
        assertThat(rank).isEqualTo(4);
    }

    @DisplayName("3개 일치하면, 5을 반환한다.")
    @Test
    void calculateRank_5th() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        List<Integer> answers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        //when
        int rank = lotto.calculateRank(answers, bonus);

        //then
        assertThat(rank).isEqualTo(5);
    }

    @DisplayName("2개 이하 일치하면, 6을 반환한다.")
    @Test
    void calculateRank_6th() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        List<Integer> answers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        //when
        int rank = lotto.calculateRank(answers, bonus);

        //then
        assertThat(rank).isEqualTo(6);
    }
}
