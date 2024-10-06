# 기능 목록
+ 각 기능에 대한 예외사항과 핸들링도 기재
+ MVC 패턴을 사용

- model 패키지
  - [x] 로또 번호 관리 - Lotto class
    - [x] 특정 번호가 로또 번호 리스트에 포함되어 있는지 확인 - contains()
    - [x] 당첨 번호 리스트와 로또 번호 리스트의 일치 개수를 반환 - matchCount()
    - [x] 로또 번호 리스트 반환 - getNumbers()
  - [x] 로또 당첨 등수 관리 - LottoRank class
    - [x] 일치하는 등수를 찾음 - findMatchingRank()
    - [x] 등수의 설명을 반환 - getDescription()
    - [x] 등수의 상금을 반환 - getPrize()
  - [x] 로또 당첨 결과 관리 - LottoResult class
    - [x] 당첨 결과를 추가 - addResult()
    - [x] 전체 상금 합계 반환 - calculateTotalPrize()
    - [x] 랭크 설명을 역순으로 반환 - reverseRankDescriptions()
    - [x] 각 랭크의 당첨 개수를 역순으로 반환 - reverseRankCounts()
- view 패키지
  - [x] 사용자 입력 처리 - LottoInputView class
    - [x] 로또 구입 금액 입력 받기 - receiveUserMoneyInput()
      - 예외사항 : 구입 금액이 1,000원 단위가 아닌 경우 ➔ IllegalArgumentException
      - 예외사항 : 입력이 숫자가 아닌 경우 ➔ IllegalArgumentException
    - [x] 당첨 번호 입력 받기 - receiveWinningNumberInput()
      - 예외사항 : 당첨번호가 6개가 아닌 경우 ➔ IllegalArgumentException
      - 예외사항 : 당첨번호에 중복된 숫자가 있는 경우 ➔ IllegalArgumentException
      - 예외사항 : 로또번호가 1부터 45 사이가 아닌 경우 ➔ IllegalArgumentException
    - [x] 보너스 번호 입력 받기 - receiveBonusNumberInput()
      - 예외사항 : 당첨번호에 중복된 숫자가 있는 경우 ➔ IllegalArgumentException
      - 예외사항 : 로또번호가 1부터 45 사이가 아닌 경우 ➔ IllegalArgumentException
  - [x] 결과 출력 - LottoOutputView class
    - [x] 로또 번호 목록 출력 - printLotto()
    - [x] 당첨 통계 출력 - printWinningStatistics()
    - [x] 총 수익률 출력 - printProfitRate()
- controller 패키지
  - [x] 로또게임 구현 - GameController class
    - [x] 게임 시작 - start()
  - [x] 로또 게임 로직 처리 - LottoController class
    - [x] 로또 번호 생성 - generateLottoNumber()
    - [x] 당첨 결과 확인 - checkWinningResult()
    - [x] 수익률 계산 - calculateProfitRate()
- util 패키지
  - [x] 입력 변환 유틸리티 - LottoParser class
    - [x] 입력 정수 리스트로 변환 - parseNumbers()
  - [x] 입력 검증 유틸리티 - LottoValidator class
    - [x] 구입 금액 검증 - validateMoneyInput()
    - [x] 로또 번호 리스트 검증 - validateNumbers()
    - [x] 보너스 번호 검증 - validateBonusNumber()

-------

* 당첨 번호와 보너스 번호를 입력하는 기능을 분리하는게 좋을까?
  * 가독성을 위해 분리하는 방향으로 선택