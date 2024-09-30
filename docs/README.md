# 기능 목록
+ 각 기능에 대한 예외사항과 핸들링도 기재

- [ ] 게임 관리 - GameManager class
    - [ ] 게임 시작 - start()
- [ ] 로또 게임 구현 - LottoGame class
    - [ ] 6개의 숫자 생성 **(Computer)** - generateLottoNumber()
    - [ ] 로또 구입 금액 입력 받기 **(Me)** - receiveUserMoneyInput()
      - [ ] **예외사항** : 1000원으로 나누어 떨어지지 않는 경우 -> `IllegalArgumentException`
    - [ ] 당첨 번호 입력 받기 **(Me)** - receiveUserNumberInput()
      - [ ] **예외사항** : 쉼표를 기준으로 구분하지 않은 경우 -> `IllegalArgumentException`
      - [ ] **예외사항** : 로또 번호의 숫자 범위 밖의 경우 (1 ~ 45) -> `IllegalArgumentException`
      - [ ] **예외사항** : 숫자가 중복되는 경우 -> `IllegalArgumentException`
    - [ ] 보너스 번호 입력 받기 **(Me)** - receiveUserBonusInput()
      - [ ] **예외사항** : 로또 번호의 숫자 범위 밖의 경우 (1 ~ 45) -> `IllegalArgumentException`
      - [ ] **예외사항** : 숫자가 중복되는 경우 -> `IllegalArgumentException`
    - [ ] 발행한 로또 수량 및 번호를 오름차순으로 출력 - issuanceLotto()
    - [ ] 당첨 내역 출력 - printWinningDetails()
    - [ ] 수익률 계산 (소수점 둘째 자리 반올림) - calculateRateOfProfit()

-------

* 당첨 번호와 보너스 번호를 입력하는 기능을 분리하는게 좋을까?
  * 가독성을 위해 분리하는 방향으로 선택