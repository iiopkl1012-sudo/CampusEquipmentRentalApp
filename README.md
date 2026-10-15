# 캠퍼스 기자재 대여 앱 — week6-room

학습 단계별 개발 이력을 보관하는 Android 앱입니다. `final`의 기자재 대여 화면을 기반으로 로그인·사용자 세션과 Room 로컬 DB 저장 구조를 추가한 버전입니다.

## 브랜치별 개발 단계

| 브랜치 | 개발 범위 |
| --- | --- |
| `final` | 홈 → 기자재 목록 → 상세 → 대여 신청 → 완료 화면 구성. `EquipmentRepository`의 샘플 기자재를 사용하고 신청 내용을 Bundle로 전달 |
| `week6-room` | 사용자 ID 로그인과 세션 추가, 대여 신청의 Room 저장 연동, 사용자·기자재 테이블의 Entity/DAO 기반 구성 |
| `week7-room` | 회원가입 화면·내비게이션 추가, `users` 저장 및 DB 조회 로그인, 샘플 회원 초기 저장, 중복 가입 방지와 DB 마이그레이션 추가 |

## final 대비 추가·변경 사항

| 영역 | 주요 코드 | 개발 내용 |
| --- | --- | --- |
| 사용자 모델 | `model/User.kt` | 사용자 ID·이름·학과·역할을 가진 `User`와 학생·교수·조교를 구분하는 `UserRole` 추가 |
| 로그인·세션 | `data/UserRepository.kt`, `data/UserSession.kt` | 샘플 회원 목록과 사용자 조회, 로그인 사용자 보관·로그아웃·로그인 상태 확인 추가 |
| 로그인 화면 | `ui/LoginFragment.kt`, `fragment_login.xml`, `nav_graph.xml` | 사용자 ID 입력 및 로그인 이벤트 추가. 시작 화면을 로그인으로 변경하고 성공 시 홈으로 이동 |
| Room 환경 | 프로젝트·앱의 `build.gradle.kts` | KSP, Room runtime·ktx·compiler, lifecycleScope 사용 의존성 추가 |
| 대여 데이터 | `data/local/RentalEntity.kt`, `RentalDao.kt` | `rentals` 테이블 정의 및 신청 저장·전체 조회·사용자별 조회 함수 추가 |
| 대여 저장 연동 | `ui/rental/RentalFragment.kt`, `fragment_rental.xml` | 세션 사용자 정보를 표시하고 `lifecycleScope`에서 대여 신청을 DB에 저장한 뒤 완료 화면으로 이동 |
| 사용자 DB 기반 | `data/local/UserEntity.kt`, `UserDao.kt` | `users` 테이블 매핑 및 `insertUser`, `getUsersAll`, `getUserId` 정의 |
| 기자재 DB 기반 | `data/local/EquipmentEntity.kt`, `EquipmentDao.kt` | `equipments` 테이블 매핑 및 `insertEquipment`, `getEquipmentsAll`, `getEquipmentId` 정의 |
| DB 연결 | `data/local/AppDatabase.kt` | 세 Entity를 등록한 버전 2 DB 및 각 DAO 접근 함수, 앱 공용 DB 인스턴스 구성 |
| 화면 간 전달 | `util/NavKeys.kt`, `ui/complete/CompleteFragment.kt` | 사용자 ID 전달 키와 완료 화면의 사용자 정보 표시 코드 수정 |

## 주요 개발 이력

아래 커밋은 개발이 진행된 순서입니다.

| 커밋 | 진행 내용 |
| --- | --- |
| `5802491` | `final` 브랜치의 기준 버전 |
| `20d67bc` | 사용자 모델과 Room 개발 환경 추가 |
| `d6cacf2` ~ `7027f8a` | 사용자 저장소·세션·로그인 화면 및 이벤트 처리, 화면 보완 |
| `3a29ad7` ~ `c022042` | `data.local`의 Room 객체와 AppDatabase 구성 |
| `45a908f` ~ `023e23d` | 대여 신청의 `rentals` 테이블 저장 연동 |
| `d2f0761` | 사용자 계정 관련 코드 보완 |
| `b428aeb` | User·Equipment Entity/DAO와 DB 등록 등을 포함한 week6 개발 상태 백업 |

## 이 버전의 범위와 다음 단계

`week6-room`은 대여 저장을 Room에 연결하고 사용자·기자재 DB 구조를 준비한 중간 단계입니다. 로그인은 `UserRepository`, 기자재 화면은 `EquipmentRepository`의 샘플 데이터를 사용하며, 회원가입 화면과 기본 회원의 DB 자동 저장은 포함하지 않습니다.

이 스냅샷에는 `User.userId`로 필드명을 변경한 뒤 `UserRepository` 조회 코드에 `loginId` 참조가 남아 있습니다. 또한 DB 버전 1 → 2 마이그레이션은 아직 추가되지 않았습니다. 이 후속 수정과 회원가입·DB 로그인 연동은 `week7-room`에서 진행했습니다.

이번 README 추가에서는 개발 스냅샷을 보존하기 위해 앱 코드를 변경하지 않았으며, 빌드와 테스트는 재실행하지 않았습니다.
