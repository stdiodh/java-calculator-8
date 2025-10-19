# java-calculator-precourse

> 1주차 미션 - 문자열 덧셈 계산기

## 과제 제출 전 체크 리스트

- [x] 터미널에서 `java --version` 실행하여 Java 버전이 21인지 확인
<img width="724" height="124" alt="스크린샷 2025-10-19 오후 3 43 48" src="https://github.com/user-attachments/assets/fe627953-9c90-4716-a3f1-dffc7c89edbe" />

- [x] 아래 명령어를 실행하여 실행하여 모든 테스트가 통과하는지 확인
    - Mac/Linux 사용자 : `./gradlew clean test`
    - Windows 사용자 : `gradlew.bat clean test`
- [x] `BUILD SUCCESSFUL` 메시지를 확인

<img width="1505" height="317" alt="스크린샷 2025-10-19 오후 3 44 10" src="https://github.com/user-attachments/assets/b5ecbd04-c093-459d-88a0-446f9370828a" />

---

## 기능 목록

### 1. 입력

- [x] 사용자로부터 문자열을 입력받는다.

### 2. 문자열 분리 및 파싱

- [x] 입력 값이 비어있거나 null인 경우 0을 반환한다.
- [x] 기본 구분자 (쉼표 `,`, 콜론 `:`)를 기준으로 문자열을 분리한다.
- [x] 커스텀 구분자를 지원한다.
    - [x] `\\`, `/n` 사이의 문자를 커스텀 구분자로 식별한다.
    - [x] 커스텀 구분자를 기준으로 나머지 문자열을 분리한다.

### 3. 입력 검증 (예외 처리)

- [x] 입력 값에 음수가 포함되어 있는 경우 예외를 발생시킨다.
- [x] 문자열 각 부분을 숫자로 변환이 불가능한 경우 예외를 발생시킨다.

### 4. 계산

- [x] 분리된 숫자들의 합을 계산한다.

### 5. 출력

- [x] 최종 계산된 합을 출력한다.
