# HadoopETL-Practice-1

## 프로젝트 구조
Hadoop -> kafka -> spark -> mysql 로 이루어진 데이터 파이프라인 API
1. FRED 데이터셋 FRED API를 이용하여 하둡 파일 시스템에 저장 (클러스터는 1개를 사용)
2. 카프카에 토픽으로 등록
3. 스파크를 통해 카프카에서 데이터를 불러와 인메모리상에서 데이터 처리 후 mysql로 저장

### 사용된 기술

<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"><img src="https://img.shields.io/badge/HADOOP-66CCFF?style=for-the-badge&logo=HADOOP&logoColor=white"><img src="https://img.shields.io/badge/KAFKA-231F20?style=for-the-badge&logo=KAFKA&logoColor=white"><img src="https://img.shields.io/badge/APACHE_SPARK-E25A1C?style=for-the-badge&logo=KAFKA&logoColor=white"><img src="https://img.shields.io/badge/MYSQL-4479A1?style=for-the-badge&logo=KAFKA&logoColor=white">

### 목적
하둡 생태계의 API 사용 방법 튜토리얼

### 사용 방법
HadoopETL-Practice-1/src/main/java/com/aaa/etl/load/
> EtlFileUploader2Hdfs.java : FRED API로부터 하둡 및 로컬에 데이터를 선별 후 저장

> EtlDataUploader2Kafka.java : 하둡파일시스템의 데이터를 카프카 토픽으로 저장

> EtlDataUploader2MySQL.java : 카프카 토픽을 스파크를 통해 불러와 전처리후 MYSQL에 배치로 저장

> EtlDataUploader2MySQLStream.java : : 카프카 토픽을 스파크를 통해 불러와 전처리후 MYSQL에 스트림으로 저장


## 체크
- Utils의 PropertyFileRader는 재사용 가능한 코드
- pom.xml, resources 디렉토리의 버전 및 설정에 유의

## TODO
- json 데이터 -> POJO 다른 데이터로 해보기
- log4j 설정 정리해서 블로깅
- 하둡, 카프카 클러스터 설정
- 도커 환경에서 실행



---
### 커밋 규칙
| 이름                | 내용                          |
|-------------------|-----------------------------|
| ✨ feat            | 새로운 기능 추가                   |
| 🐛 fix             | 버그 수정                      |
| 📝 docs            | 문서 수정                      |
| 💡 comment         | 필요한 주석 추가 및 변경             |
| 🎨 style           | 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우 |
| ♻️ refactor        | 코드 리팩토링                    |
| 🔧 update          | 코드 업데이트 및 수정              |
| ✅ test            | 테스트 코드                    |
| 📦 chore           | 빌드 업무 수정, 패키지 매니저 수정     |
| 🔥 remove          | 파일을 삭제하는 작업만 수행           |
| 🚚 rename          | 파일 혹은 폴더명을 수정하거나 옮김      |
| 🚑 !HOTFIX         | 급하게 치명적인 버그 고침           |
| 💥 !BREAKING CHANGE | 커다란 API 변경                 |
