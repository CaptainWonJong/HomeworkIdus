# HomeworkIdus
백패커(아이디어스) 앱 과제

### 탈락했으니까 public으로 전환합니다.
https://programmers.co.kr/competitions/125/2019-idus-blind-recruitment

~~제출해주신 과제가 정상적으로 실행되지 않아 -> LeakCanary 때문에 안됐다면 유감 :(~~

- apk 빌드할 때 ```aaptOptions.cruncherEnabled = false``` 설정을 넣어주면 안됩니다.

- https://appetize.io/ 에서 Gradle에 해당 속성이 들어가 있으면 실행이 안됩니다.

- 그리고 LeakCanary 적용하면 https://appetize.io/ 에서 Canary부터 실행되니까 빼는게 좋습니다.


### 코드리뷰 수정 Branch
hotfix/1.0.1 (~ 19.12.29 수정 예정)

### Rx -> 코루틴 수정 Branch
release/1.1.0 (~20.01.10 수정 예정)

- 만약 서버가 죽었다면 코루틴 공부는 [MySampleApp](https://github.com/CaptainWonJong/MySampleApp) 에서 진행 예정
