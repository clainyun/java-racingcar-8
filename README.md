# java-racingcar-precourse

## 구현할 기능 목록

### 1. 자동차 이동 관리
> 각 자동차의 현재 위치를 관리하고 전진 여부를 결정한다.
- [x] 자동차의 위치를 저장한다
- [x] 무작위 값이 4 이상일 경우 전진한다


### 2. 입력 처리
> 사용자로부터 경주에 필요한 정보를 입력받는다.
- [x] 경주할 자동차의 이름을 입력받는다 (예: pobi,woni,jun)
- [x] 자동차 이름을 쉼표로 분리한다
- [x] 자동차 이름이 5자 이하인지 검증한다
- [x] 시도할 횟수를 입력받는다
- [x] 시도할 횟수가 1 이상의 숫자인지 검증한다


### 3. 경주 진행
> 지정된 횟수만큼 반복하며 자동차를 이동시킨다.
- [x] 시도 횟수만큼 반복한다
- [x] 자동차를 이동시킨다 ("-"로 이동 표시)


### 4. 결과 출력
> 각 차수별 실행 결과와 최종 우승자를 출력한다.
- [x] 각 자동차의 실행 결과를 출력한다 (예: pobi : --)
- [x] 자동차 경주 게임의 최종 우승자를 찾는다
- [x] 우승자는 한 명 이상일 수 있다
- [x] 여러 명일 경우 쉼표로 구분해 출력한다 (예: 최종 우승자 : pobi, jun)


### 5. 예외 처리
> 유효하지 않은 입력에 대해 IllegalArgumentException을 발생시키고 프로그램을 종료한다.
- [x] 자동차 이름이 5자 초과인 경우 IllegalArgumentException 발생
- [x] 자동차 이름이 공백 또는 빈 문자열인 경우 IllegalArgumentException 발생
- [x] 시도 횟수가 공백이거나 빈 문자열인 경우 IllegalArgumentException 발생
- [x] 시도 횟수가 숫자가 아니거나 1 미만인 경우 IllegalArgumentException 발생
- [x] 예외 발생 시 프로그램을 종료한다 (System.exit() 사용 금지)


### 6. 프로그래밍 요구 사항
> 프로그래밍 구현 규칙을 따른다.
- [x] indent depth를 3이 넘지 않도록 구현한다
- [x] 3항 연산자는 사용하지 않는다
- [x] 메서드는 한 가지 일만 수행하도록 구현한다 (SRP 준수)
- [x] JUnit 5와 AssertJ를 이용해 테스트를 작성한다
- [x] 1주차 공통 피드백을 반영한다
    - [x] 이름을 통해 의도를 드러낸다
    - [x] 의미 있는 커밋 메시지를 작성한다


## 제출 전 체크리스트
> 제출 전 요구사항과 구현 내용을 다시 검토한다.
- [x] 모든 테스트(`./gradlew clean test`)가 성공적으로 통과한다
- [x] 출력 형식이 예시와 정확히 일치한다
- [x] 예외 발생 시 `IllegalArgumentException` 이후 종료된다
- [x] README의 모든 체크박스 항목이 구현 완료되었다
- [x] 기능 단위로 커밋이 분리되어 있다

## 리팩토링
> 기능 구현 완료 후 코드 품질 향상을 위한 개선 작업 목록
- [x] 매직 넘버를 상수로 추출
  - 목적: 의미를 명확히 하고 가독성을 높인다
  - 대상:
    - Car: MAX_NAME_LENGTH(5), MOVING_THRESHOLD(4)
    - Application: MIN_RANDOM_VALUE(0), MAX_RANDOM_VALUE(9)
- [ ] String += 연산을 StringBuilder로 최적화
  - 목적: 불필요한 문자열 연산을 줄이고 성능을 개선한다
  - 대상:  
    - createWinnerNamesString 메서드
    - addWinnerNameWithComma 메서드