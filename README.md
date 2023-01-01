<img src="https://capsule-render.vercel.app/api?type=Shark&color=auto&height=200&section=header&text=Backend - Danawa&fontSize=90" />

-------------
# Project : Employment

---
## Contributors
### 김동열
<img src="https://github-readme-stats.vercel.app/api/top-langs/?username=ehfql6363&layout=compact"><br><br>
> 채용 목록 조회 및 공고 검색 기능 구현, ERD 작성 
### 조정빈
<img src="https://github-readme-stats.vercel.app/api/top-langs/?username=jojeongbin&layout=compact"><br><br>
> 채용 등록, 수정, 삭제 기능 구현

---
## Summary & Purpose
**기업 채용을 위한 웹 서비스**

---
## 목차
- [Tech & Stack](#tech--stack)
- [개요](#summary)
- [기능 구현 목록](#feature)
- [ERD](#erd)
- [TEST-CODE](#test-code)

---
## Tech & Stack
### Language
<img src="https://img.shields.io/badge/Java-17-007396?style=fflat&logo=java&logoColor=white"><Br>

### API
<img src="https://img.shields.io/badge/Spring Boot-2.7.6-6DB33F?style=flat&logo=Spring Boot&logoColor=white"/><br>
<img src="https://img.shields.io/badge/spring-6DB33F?style=flat&logo=spring&logoColor=white"><br>
<img src="https://img.shields.io/badge/gradle-02303A?style=flat&logo=gradle&logoColor=white">

### ORM
<img src="https://img.shields.io/badge/JPA-6DB33F?style=flat&logo=&logoColor=white"/><br>

### DB
<img src="https://img.shields.io/badge/mariaDB-003545?style=flat&logo=mariaDB&logoColor=white"><br>

### Tools
<img src="https://img.shields.io/badge/IntelliJ IDEA-000000?style=flat&logo=IntelliJ IDEA&logoColor=white"><br>

### Communication
<img src="https://img.shields.io/badge/Slack-4A154B?style=flat&logo=Slack&logoColor=white"><br>
<img src="https://img.shields.io/badge/Notion-000000?style=flat&logo=Notion&logoColor=white"><br>

---
## Summary
- **기업의 채용을 위한 웹 서비스**
- **회사는 채용 공고를 생성하고 수정 및 삭제가 가능**
- **사용자는 채용 공고를 검색 및 조회 가능**

---
## Feature
- [x] 채용 공고를 등록
  - API : ```/employ/submit```
  - RequestBody Example
      ```
      {
          "회사_id":회사_id,
          "채용포지션":"백엔드 주니어 개발자",
          "채용보상금":1000000,
          "채용내용":"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
          "사용기술":"Python"
      }
  
- [x] 채용 공고를 수정
  - API : ```/employ/modify```
  - RequestBody Example
    ```
    {
        "채용공고_id":채용공고_id,
        "채용포지션":"백엔드 주니어 개발자",
        "채용보상금":1500000, # 변경됨
        "채용내용":"원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..", # 변경됨
        "사용기술":"Python"
    } 

- [x] 채용 공고를 삭제
  - API : ```/employ/delete```
  
- [x] 채용 공고 목록 조회
  - API : ```/employ/load```
  - ResponseBody Example
    ```
    [
      {
          "채용공고_id": 채용공고_id,
          "회사명":"원티드랩",
          "국가":"한국",
          "지역":"서울",
          "채용포지션":"백엔드 주니어 개발자",
          "채용보상금":1500000,
          "사용기술":"Python"
      },
      {
          "채용공고_id": 채용공고_id,
          "회사명":"네이버",
          "국가":"한국",
          "지역":"판교",
          "채용포지션":"Django 백엔드 개발자",
          "채용보상금":1000000,
          "사용기술":"Django"
      }, 
      ...
    ]
  - [x] 채용 공고 검색
    - API : ```/employ/search?keyword=abc```
    - ResponseBody Example
    ```
    [
      {
          "채용공고_id": 채용공고_id,
          "회사명":"원티드랩",
          "국가":"한국",
          "지역":"서울",
          "채용포지션":"백엔드 주니어 개발자",
          "채용보상금":1500000,
          "사용기술":"Python"
      },
      {
          "채용공고_id": 채용공고_id,
          "회사명":"원티드코리아",
          "국가":"한국",
          "지역":"부산",
          "채용포지션":"프론트엔드 개발자",
          "채용보상금":500000,
          "사용기술":"javascript"
      }
    ]
- [x] 채용 상세 페이지 조회
  - API : ```/company/emp```
  ```
    {
        "채용공고_id": 채용공고_id,
        "회사명":"원티드랩",
        "국가":"한국",
        "지역":"서울",
        "채용포지션":"백엔드 주니어 개발자",
        "채용보상금":1500000,
        "사용기술":"Python",
        "채용내용": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
        "회사가올린다른채용공고":[채용공고_id, 채용공고_id, ..] # id List (선택사항 및 가산점요소).
    }

---
## ERD
![gdsc_week1_ERD.png](..%2F..%2FDownloads%2Fgdsc_week1_ERD.png)

---
## Test-Code



