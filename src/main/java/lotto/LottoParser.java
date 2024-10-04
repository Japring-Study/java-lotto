package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoParser {


    private LottoParser() {
    }

    /**
     * 입력 정수 리스트로 변환
     */
    public static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim) //스페이스 제거
                .map(Integer::parseInt) //정수 변환
                .collect(Collectors.toList());
    }
}
