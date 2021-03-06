# UKID
## 목차소개 
1. 소개
2. 기획서
    * 목적 및 필요성
        * 문제인식
        * 기획의도
        * 시장/소비자 동향/분석
        * 차별화 요소
    * 개요
        * 프로젝트 소개
        * 주요 기능
        * 적용 기술
        * 개발 사양
        * 독창성
    * 수행 방법 및 일정
        * 수행방법 확보방안
        * 추진 일정
        * 역할 분담
    * 기대효과 및 활용분야
    * 비지니스모델
3. 개발서
    * 안드로이드 앱
    * 서버
    * 딥러닝
4. 기타
    * 일정관리
    * 추후목표
    * 인용 및 참고자료
## 1. 소개
스마트모바일프로그램 앱둥이 팀의 'UKID' 어플입니다.  
팀 소개를 먼저 하겠습니다.
앱둥이는 '앱 (어플)' + '-둥이'의 합성어로 앱을 개발하는 저희 팀을 귀엽게 표현한 말 입니다.

이번 프로젝트에서는 'UKID' 라는 아이 교육 및 학습 어플리케이션을 개발하였습니다.

[![Watch the video](./readme/background.png)](https://www.youtube.com/watch?v=9r5Qc6dFX84)

## 2. 기획서
   * ### 목적 및 필요성 
        + #### 문제인식
            1. 아이의 참여권
                유엔아동권리협약의 4대 기본권은 생존권, 보호권, 발달권, 참여권이다. 하지만 국내의 영유아 인권 논의는 생존권,
                보호권에만 치중돼 있고, 특히 '참여권'에 대한 논의는 초보적인 수준이다. 유니세프(unicef)는 아동의 참여권을
                "표현의 자유, 유익한 정보를 얻을 권리 등"이라고 덧붙히면서 참여권에 대한 중요성을 강조한다.
                
                > 아이가 마음 껏 표현하고 정보를 얻을 수 있는 환경이 필요하다.
             
            2. 다중지능 검사 및 교육의 높은 가격
                 가드너는 지능을 "하나 이상의 문화나 공동체의 상황에서 가치가 있는 문제를 해결하거나 산출을 형성하는 능력"
                이라고 정의하고 있다. 이러한 정의, 분석, 관찰 속에서 지능을 8개의 영역으로 나누게된다.
                 다중지능은 개개인마다 다르고 개인의 강점과 약점을 알려주고 개인의 진로와 학습의 목표를 결정하게 해주며,
                 개인의 인지양식이나 문제해결양식을 알려주고 이를 기초로 학습방법을 적합하게 선택할 수 있게 해준다.
                하지만 이러한 교육은 단계별 30만원을 호가하는 등 높은 가격대로 형성되어있다.
                
                > 저렴한 비용의 개인별 다중지능 교육 콘텐츠가 필요하다.           
                      
        + #### 기획의도(문제해결)
            1. 어린이가 스스로 학습할 수 있는 어플리케이션 개발
                - 통계자료에 따르면 3세~9세 아동의 스마트폰 이용률은 73.7%를 기록했다.
                - 학습에 용의한 시각적 학습 콘텐츠를 제공한다. 
                - 아이는 다양한 퀴즈 및 콘텐츠를 통해 스스로 학습할 수 있다. 
                
            2. 저비용, 교효율 다중지능 학습 및 검사
                - 부모님은 제공되는 다중지능 검사를 통해 아이의 다중지능을 확인할 수 있다.
                - 동영상 및 다양한 콘텐츠를 통해 다중지능을 학습 시킬 수 있다.
                - 시각적으로 다중지능 표현하여 한눈에 알아보기 쉽다.
                - 다중지능 별 상세설명 및 학습방법을 제공한다.
                                
        + #### 시장/소비자 동향/분석
            ![kids1](./readme/kids1.png)
             
             세계시장 및 한국시장에서 에듀테크 시장은 나날이 커져가고 있다.
             2020년 기준 한국 에듀테크는 10조원 이상을 추정하고있다. 
             
            ![kids2](./readme/kids2.jpeg)
            
             국내 키즈산업 규모도 점점들어나고 있는데 2017년 기준 40조원으로 점점 늘어나는 추세이다.  
             또한 유튜브의 성장세와 일 평균 유튜브 이용시간도 늘어나고 있다.
             
             > 에듀테크 시장 및 키즈 산업의 시장이 나날이 커진다는 것은 유아학습 시장도 커진다는 것으로 볼 수 있다.
     
        + #### 차별화 요소
            - 다중지능 별 동영상을 제공한다.
            - 아이의 관심사를 파악하며 분석할 수 있다.
            - 인공지능을 통해 아이가 사물을 학습할 수 있다.
            
   * ### 개요
        + #### 프로젝트 소개
            '스스로 학습할 수 있는 환경을 만들자' 라는 취지로 계획된 'UKID' 프로젝트는  
            어플리케이션 기반 서비스입니다.  
            아이는 시각적인 콘텐츠를 활용하여 다중지능을 학습할 수 있습니다.  
            부모님은 아이의 다중지능을 확인하며 교육 계획을 수립할 수 있습니다.
            
        + #### 주요 기능 
            1. 교육
                - 다중지능 동영상 시청 : 다중지능 별 나뉘어진 동영상을 시청할 수 있습니다.
                - 사물 학습 : 카메라를 이용하여 주변 사물을 인식하고 그에 대한 설명을 확인할 수 있습니다. 
                - 수학 놀이 : 덧셈, 뺄셈을 통해 수학 놀이를 할 수 있습니다.
                
            2. 분석
                - 다중지능 : 다중지능에 분석을 통해 교육 방법 및 대표 직업을 확인할 수 있습니다.
                - 관심 동영상 : 아이 시청 동영상 분석을 통해 관심있는 다중지능 동영상을 확인 할 수 있습니다. 
                - 포즈 인식 : 아이의 포즈를 인식하여 행동 분석에 활용할 수 있습니다. (추후 개발 예정)
                
        + #### 적용 기술
            1. YoutubeCrawling : 유튜브 동영상의 정보를 가져오며 자연어 처리를 통한 탑 키워드를 추출할 수 있습니다.
            2. MultiLabel Classification : 키워드를 통해 다중지능을 항목별 분류해주는 기술입니다.
            3. Object detection : 사물을 인식하고 해당 영역을 바운딩 및 설명을 하는 기술입니다.
            4. Random Math Game : 랜덤으로 숫자, 기호를 선택하며 
            5. ChartFrame : 다중지능을 Bar, Pie 형대의 차트로 확인하는 기술입니다.
        + #### 개발 사양
            1. AWS
                t2.micro : vCPU 1, Memory 1GB를 가지며 Linux(Ubuntu18.0.4)운영체제를 가진 인스턴스 입니다. Server로 이용되며 프리티어로 운영중입니다.
            2. GPU Server
                AMD 3700X CPU, Memory 32GB, RTX 2070S를 가지며, 딥러닝 학습용 Server입니다. 
        + #### 독창성
            1. 서비스적 관점
                - 기존 고비용의 설문 및 학습이 아닌 무료로 이용할 수 있다.
                - 부모님의 아이학습 커뮤니티를 개설하여 정보를 공유할 수 있다 (추후 개발 예정)
            2. 기능적 관점
                - 키워드를 통한 다중지능 분류를 통하여 원하는 지능의 동영상을 볼 수 있다.
                - 카메라를 통해 주변 사물을 인식하여 아이들이 쉽게 사물을 학습하는 기능을 제공한다.
                - 다중지능 분석 결과를 사용자들이 보기 쉽게 인터페이스를 제공한다.
   * ### 수행 방법 및 일정
        + #### 수행방법 확보방안
            1. 데이터 
                - 동영상 데이터 : 크롤링을 통해 유튜브 동영상 정보 수집.
                - 사물인식 데이터 : COCO Dataset, Kaggle, pixabay를 통한 이미지 수집.
            2. 서버
                - AWS EC2 t2.micro를 통한 웹 호스팅
            3. 디자인
                - Photoshop : 로그 및 배너 세부 디자인
                - ovenapp : 앱 activity 컨셉 디자인
                - zepline : 전체적인 앱 디자인
                
        + #### 추진 일정
            ![paln](https://user-images.githubusercontent.com/50088364/85386496-a52e4080-b57e-11ea-9a52-94787dbca12e.png)
        + #### 개발 역할
            * 박시온 (풀스택)
                1. 안드로이드 앱
                    - SharedPreferences : SharedPreferences를 통한 데이터 관리
                    - AuthCheckPage : 자동 로그인 및 유저 셋업으로 전환되는 로직 개발
                    - SetUserInfoActivity : 첫 로그인 시 유저 정보 및 설문조사 (Fragment) 개발
                    - DetectionActivity : 사물 인식 카메라 페이지 (사물 설명 dialog) Custom 개발
                    - StudyMathFragment : 수학 학습 페이지 로직 개발
                    - UserAnalysisFragment : 아이의 TOP3 다중지능 페이지 로직 개발
                2. Server
                    - Python (중앙서버) : 요청에 따른 Data, Deep learning Server API처리
                    - NodeJS(데이터서버) : 데이터 시각화, 데이터 요청에 따른 데이터 전송 
                    - Deep learning Server : 데이터 수집, 키워드 추출, 모델 예측 처리 
                    - DB 개발 : DataBase(Mysql) Modeling 및 개발
                    - YoutubeCrawling : 유튜브에서 동영상의 메타데이터, 자막데이터를 자동 수집 로직 개발
                3. Deep learning
                    - NLP 키워드 추출 : 동영상 정보를 이용하여 TOP 키워드 추출 
                    - Multilabel Classification : Keras를 이용한 NLP Multilabel Classification
                    - Object Detection : tensorflow Lite를 이용한 Object detection 및 사물 설명 Custom
                4. REAMDME.md 작성
                
            * 천건호 (앱개발)
                - APP API Interface : Retrofit2를 이용한 Server와 API 통신 Interface 개발
                - YoutubePlayer : API를 통해 동영상 정보를 받아온 후 Main화면에 YoutubePlayer 연동
                - 동영상 카테고리 : 동영상을 카테고리에 맞게 화면에 표출하는 로직 작성
                - 로그인 및 회원가입 : 유저 회원가입 및 로그인 activity 개발
                - MypageActivity : 마이페이지 하단 유저 동영상 시청에 관련된 정보처리
                - 유저의 성별에 맞게 성별 ICON Change
                
            * 김나형 (앱개발)
                - MainActivity : 메인 Fragment 구현
                - Google Admob  : 어플리케이션에 admob 연동
                - MypageActivity : 마이페이지 유저 정보 표현 및 다중지능 차트화
                - 동영상 라벨링 : 다중지능별 동영상 라벨링
            * 이세환 (디자인 및 레이아웃 구성)
                - 로딩페이지 layout, animation 구현  
                - 배경 layout(app bar, background) 구현
                - fab button(layout, label, blur처리) 구현
                - navigation header layout 구현
                - 유저 셋업 시 설문 layout 구현
                - 지능별 Detail 결과해석 layout, activity 구현
                - 계산기 놀이 layout 구현
                - 각종 이미지 수집
            * 정가영 (디자인)
                - 앱 로고제작 : 앱 로고 'U' 및 'UKID' 디자인
                - 로그인, 회원가입, Main화면 : 3가지의 화면 디자인
                - Fab 디자인 : 메인화면 Fab Button 디자인
                - 동영상 라벨링 : 다중지능별 동영상 라벨링
         
   * ### 기대효과 및 활용분야
        + 사용자 측면
            - 아이는 자신이 보고싶은 동영상을 보면서 다중지능을 학습 할 수 있다. 
              또한 수학 게임, 사물 인식 등 다양한 콘텐츠를 통하여 재미와 흥미를 느낄 수 있다.
              부모님은 아이의 다중지능을 파악하여 높은 다중지능의 추천 진로를 통하여
              미래 설계를 할 수 있으며 부족한 지능의 학습법을 확인 할 수 있어
              교육 계획을 수립하는데 도움을 줄 수 있다.
            
        + 비지니스 측면
            - 기존 설문 및 교육 단계별 30만원을 호가하는 등 높은 비용을 무료 ~ 소정 비용으로 이용할 수 있다.
              이를 통해 비용을 절약할 수 있다.
            - Google admob, 광고를 확인하면 무료로 다중지능을 분석할 수 있다.   
           
        + 활용 분야
            - 유아 다중지능 분석 및 유아 다중지능 학습
   * ### 비지니스모델
        + 앱의 Google Admob을 활용한 광고 수입.
        + 유아제품 쇼핑몰 거래 수수료. (추후 예정)
        + 교육콘텐츠 제작하는 유튜버들과 제휴 (추후 예정)
        + 향상된 설문지 (20개의 설문) 설문비.
## 3. 개발서
   * ### 안드로이드 앱
        + #### 디렉토리 구조
        ##### app/src/main/java/com/example/ukidapp 이후 Activity만
        ![tree.png](./readme/tree.png)
        
        + #### 사양
         complieSdkVersion : 29
         targetSdkVersion : 28
         minSdkVersion : 21  
        + #### 실행방법
         git clone https://github.com/sion9262/ukid.git
         또는
         Download ZIP
         
        + #### 개발 
        ##### 권환
        ###### 권한에는 인터넷, 인터넷 상태체크, 카메라 가 있습니다.
        ![permission](./readme/permission.png)
        
        ##### 네트워크 보안문제 설정
        ##### error : No Network Security Config specified, using platform default  
        ##### 방법 1
        ![http1](./readme/http1.png)
        
         AndroidManifest.xml
         -> application 
         android:usesCleartextTraffic="true" 추가
        
        ##### 방법 2
        ![http2](./readme/http2.png)
         
         AndroidManifest.xml 
         -> application
         android:networkSecurityConfig="@xml/network_security_config" 추가
         
        ![http3](./readme/http3.png)
        
         res/xml/network_security_config.xml 
         // res에 xml 폴더 추가 후 network_security_config.xml 추가
         
         <?xml version="1.0" encoding="utf-8"?>
         <network-security-config>
            <!--Set application-wide security config using base-config tag.-->
            <!--<base-config cleartextTrafficPermitted="true"/>-->
            <base-config cleartextTrafficPermitted="true">
                <trust-anchors>
                    <certificates src="system" />
                </trust-anchors>
            </base-config>
         </network-security-config>
        
        ##### LoginActivity 로그인 기능
        ![active_login](./readme/active_login.jpg)
        
        ![flogin](./readme/login.JPG)
        
        ![flogin2](./readme/login2.JPG)
        
        ![flogin3](./readme/login3.JPG)
        
         LoginActivity의 코드이다.
         사용자가 입력한 이메일, 패스워드를 검증 한 후
         Retrofit을 통해 Server에 로그인 요청을 한다.
         응답은 GSON형식의 AuthModel로 저장되며
         로그인 성공시 Sharedpreferences에 유저 정보가 저장된다.
         
        ##### RegisterActivity 회원가입 기능
        ![active_reg](./readme/active_reg.jpg)
        
        ![flogin](./readme/register1.JPG)
        
        ![flogin2](./readme/register2.JPG)
        
        ![flogin3](./readme/register3.JPG)
        
         RegisterActivity의 코드이다.
         사용자가 입력한 이메일, 패스워드, 전화번호를 검증 한 후
         Retrofit을 통해 Server에 회원가입 요청을 한다.
         응답은 GSON형식의 AuthModel로 저장되며
         회원가입 성공시 LoginActivity로 이동된다.
         
        ##### SetUserInfoActivity 초기 유저 정보 및 설문
        ![active_setup1](./readme/active_setup1.jpg)
        
        ![active_setup2](./readme/active_setup2.jpg)
        
        ![flogin](./readme/setup1.png)
        
        ![flogin2](./readme/setup2.png)
        
        ![flogin3](./readme/setup3.JPG)
        
        ![flogin3](./readme/setup4.JPG)
        
        ![flogin3](./readme/setup5.JPG)
        
        ![flogin3](./readme/setup6.JPG)
        
         SetUserInfoActivity의 코드이다.
         Activity는 9개의 Fragment와 함께 작동되며,
         pageIndex 마다 하는 일이 다르다.
         
         1 -> 유저 성별, 이름, 나이 
         2 -> 언어지능 설문
         3 -> 논리수학지능 설문
         4 -> 공간지능 설문
         5 -> 신체운동지능 설문
         6 -> 음악지능 설문
         7 -> 대인간관계지능 설문
         8 -> 자기성찰지능 설문
         9 -> 자연친화지능 설문 
         
         이후 각 설문별 데이터를 가져와 Server로 저장하게 되며
         Sharedpreferences에 유저 정보 및 설문내용이 저장된다.         
         
        ##### MainActivity 메인
        ![active_main](./readme/active_main.jpg)
        
        ![mainactivity](./readme/mainactivity1.png)
        
        ![mainactivity](./readme/mainactivity1.png)
        
        ![mainactivity](./readme/mainactivity1.png)
        
         MainActivity의 코드이다.
         Main은 4개의 Fragment로 구성되어 있다.
         각 기능들을 연결해주는 역할을 하고 있다.
        
        ##### HomeFragment 카테고리별 동영상확인 
        ![active_main2](./readme/active_main2.jpg)
        
        ![home1](./readme/hom1.png)
        
        ![home2](./readme/hom2.png)
        
        ![home3](./readme/hom3.png)
        
        ![home5](./readme/hom5.png)
        
        ![home6](./readme/hom6.png)
        
         HomeFragment의 코드이다.
         HomeFragment는 기본적으로 RecyclerView의 구조를 가지고 있다.
         
         첫 시작시 모든 카테고리의 동영상을 불러온다.
         이후 Fab버튼을 통해 여러 지능의 카테고리를 클릭하게 되면
         Server에 해당 지능의 동영상을 받아오고
         RecyclerView의 Data를 관장해주는 Adapter 수정 및 notifyDataSetChanged하게된다.
         
         각 동영상을 클릭하면 movie의 정보를 담아 YoutubePlayActivity로 전송하게 된다.
         
        ##### YoutubePlayActivity 유튜브 실행 
        ![YoutubePlayActivity1](./readme/YoutubePlayActivity1.png)
        
        ![YoutubePlayActivity2](./readme/YoutubePlayActivity2.png)
        
        ![YoutubePlayActivity3](./readme/YoutubePlayActivity3.png)
                
        ![YoutubePlayActivity4](./readme/YoutubePlayActivity4.png)
        
         YoutubePlayActivity의 코드이다.
         시작시 onStart 를 통하여 동영상 시작 시간을 저장한다.
         이후 HomeFragment에서 받은 동영상 정보를 getStringExtra통해 받아온 후
         initializeYoutubePlayer() 함수를 통해 유튜브를 재생하게 된다.
         동영상 시청 후 activity가 onDestroy하게 되면 
         정지 시간 - 시작 시간 = 동영상 시청시간이 구해지게 된다.
         이러한 정보는 SavePlayMovieData을 통해 유저의 시청 동영상 정보가 서버에 저장되게된다.
         
        ##### MypageActivity 마이페이지 
        ![active_mypage](./readme/active_mypage.jpg)
        
        ![mypage1](./readme/mypage1.JPG)
        
        ![mypage2](./readme/mypage2.JPG)
        
        ![mypage3](./readme/mypage3.JPG)
                
        ![mypage4](./readme/mypage4.JPG)
        
        ![mypage5](./readme/mypage5.JPG)
        
        ![mypage6](./readme/mypage6.JPG)
        
        ![mypage7](./readme/mypage7.JPG)

         MypageActivity의 코드이다.
         
         Mypage에서는 크게 3가지 기능으로 나뉘게 된다.
         
         1. 유저 정보 확인
            Sharedpreferences에서 유저 정보를 확인하여 뿌려줌.   
         2. 유저 다중지능 점수 확인
            Sharedpreferences에서 다중지능 점수를 확인하여 Pie Chart로 표현
         3. 유저 시청한 동영상 확인
            Server에서 User의 동영상 시청 정보를 확인하여 다중지능별 시청 횟수
            및 최근에 시청한 동영상 목록이 보여지게된다.
            
        ##### DectionActivity 사물 인식 
        ![active_detect](./readme/active_detect.jpg)
        
        ![detection1](./readme/detection1.png)

         DectionActivity 코드 중 수정만 한 부분이다.
         Object detection기능은 tensorflow libray를 사용하였고
         기본 코드 중 일부분 수정하였다.
         1. 예측 정확도 60%이상만 예측한 것으로 하였다.
            - 낮은 정확도는 필터링
         2. ArrayList로 결과를 저장한 후 CameraActivity UI 변경
            - showDetectionReulst는 CameraActivity의 함수 중 일부이며
              저장된 결과를 List로 보여주는 함수이다.
              원래 다른 Activity에서 다른 UI를 수정할 수 없지만,
              Thread를 이용하여 접근할 수 있다.
        
        ##### CameraActivity 사물 인식 
        ![camera1](./readme/camera1.png)
        
        ![camera1](./readme/camera2.png)
        
        ![camera1](./readme/camera3.png)

         CameraActivity 코드 중 수정만 한 부분이다.
         
         첫번째로 보이는 화면은 기존 Frame을 설정하는 UI에서
         ListView로 바꾸어주어, Adapter을 SETUP하며,
         ItemCickListener을 설정하여 주었다.
         
         두번째로 보이는 화면은 이미 저장된 label에 관한 정보를 불러와
         labelKR, labelSubText에 값을 넣어준다.
         
         세번쨰로 보이는 화면은 Item을 추가하고 검증하는 단계이다.
         위의 DetectionActivity에서 result값을 넣어주면
         영어 -> 영어 + 한글로 넘겨주고 listitem에 추가하게 된다.
         이후 중복된 사물은 추가 안되게 막아준다.
         
         밑에 함수는 ItemClick이 되면 labelSubText와 비교하여
         영어 + 한글 + 설명 을 리턴하게 된다.
        
        ##### StudyMathFragment 수학놀이 
        ![active_math](./readme/active_math.jpg)
        
        ![math1](./readme/math1.JPG)
        
        ![math2](./readme/math2.JPG)
        
        ![math3](./readme/math3.JPG)
        
        ![math4](./readme/math4.JPG)
        
        ![math5](./readme/math5.JPG)
        
        ![math6](./readme/math6.JPG)
                
         StudyMathFragment의 코드이다.
         
         랜덤으로 덧셈 뺄셈을 결정하며, 숫자 또한 랜덤으로 결정된다.
         
         추후 tryCount, answerCount, failCount를 이용하여
         아이가 논리수학지능의 점수를 갱신해주는 업데이트를 할 예정이다.
         
        ##### UserAnalysisFragment 유저 분석
        ![active_a](./readme/active_a.jpg) 
        
        ![analysis1](./readme/analysis1.JPG)
        
        ![analysis1](./readme/analysis2.JPG)
        
        ![analysis1](./readme/analysis3.JPG)
                
         UserAnalysisFragment의 코드이다.
         Sharedpreferences에서 다중지능 점수를 가져와
         Top3의 다중지능을 추출하여 Bar Chart형식으로 표현된다.
         
         이후 확인하러가기 버튼을 누르게되면 Top3 다중지능과 함께 
         DetailUserScore로 전환된다.
         
        ##### DetailUserScore 다중지능 분석 
        ![active_detail1](./readme/active_detail.jpg)
        ![active_detail2](./readme/active_detail2.jpg)
          
        ![detail1](./readme/detail1.JPG)
        
        ![detail2](./readme/detail2.JPG)
        
        ![detail3](./readme/detail3.JPG)
        
        ![detail4](./readme/detail4.JPG)
        
        ![detail5](./readme/detail5.JPG)
        
        ![detail6](./readme/detail6.JPG)
                
         DetailUserScore의 코드이다.
         UserAnalysisFragment받은 Top3 를 가지고
         화면을 구성하게 되며, 전면 광고 및 배너 광고가 포함되어있다.
         
         주요 기능은 각 지능별 설명과 추천직업, 대표인물, 향상시키는 법
         이 들어가있다.
         
        
         
         
   * ### 서버
   + #### Python Server (중앙서버)
     fastAPI를 이용한 서버구성
     https://github.com/sion9262/ukidfastapi
            
        #### 설치방법
         git clone https://github.com/sion9262/ukidfastapi.git
        #### 필요라이브러리 
         PYTHON VERSION >= 3.6

         pip install fastapi
        
         pip install email-validator
        
         pip install uvicorn
        
         실행 방법 : uvicorn main:app --reload
         
        #### 디렉토리 구조
        ![pythonbackend](./readme/pythonbackend.png)
        
        #### main.py
        ![api](./readme/api.png)
        
         API를 처리하는 부분입니다.
         각 기능 Auth, Movies에 관한 Model을 생성하며 로직을 수행합니다.
        
        #### Auth/Auth.py
        Auth class 는 아래의 기능을 수행합니다.   
        로그인, 회원가입, 유저정보설정, 유저정보 받아오기와 같은 기능을 수행합니다.
        ##### Login 
        ![login](./readme/login.png)
        
        ##### Register
        ![reg](./readme/reg.png)
        
        ##### setUser
        ![setuser](./readme/setuser.png)
        
        ##### userplaymovies
        ![userplaymovies](./readme/userplaymovies.png)
        
        #### Moives/Moives.py
        Movies class 는 아래의 기능을 수행합니다.   
        전체 동영상 가져오기, 카테고리별 동영상 가져오기,   
        유저가 시청한 동영상 저장, 랜덤 영상 프로세싱 기능을 수행합니다.
        ##### getMovies 
        ![getmoives](./readme/getmovie.png)
        
        ##### getcategory
        ![getcategory](./readme/getcategory.png)
        
        ##### userplaymovies
        ![postmovie](./readme/postmovie.png)
        
        ##### movieUtil
        ![movieutil](./readme/movieutil.png)
     
   + #### Node Server (데이터서버)
         StrAPI 이용한 서버구성  
         https://strapi.io/
     
        - ##### 데이터베이스 구성도
        ![db1](./readme/db1.JPG)
        ![db2](./readme/db2.JPG)
        
        ![db3](./readme/strapi.png)
     
   + #### 딥러닝 Server (딥러닝서버)
     개인 컴퓨터에 Local로 제한함.   
                           
   * ### 딥러닝
       - NLP
        ![nlp1](./readme/nlp1.png)
        ![nlp2](./readme/nlp2.png)
        ![nlp3](./readme/nlp3.png)
        ![nlp4](./readme/nlp4.png)
 
             NLP키워드 분리에는 Konlpy가 라이브러리를 사용한다.
             https://konlpy-ko.readthedocs.io/ko/v0.4.3/
             
             Library
             konlpy == 0.5.2
             
             순서
             1. Server에서 키워드 분리가 안된 데이터를 가져온다.
             2. 가져온 데이터에서 제목, 내용, 자막, 태그 등 텍스트 데이터를 가져온다.
             3. getKeyword를 통해 한글, 영어로 키워드를 분리 후 불용어 제거를 해주며 다시 합친 값을 받는다.
             4. 위의 결과를 Counting한 후 Top Keyword를 추출 한 뒤 서버에 저장한다.
            실행결과
            ![nlp5](./readme/nlp5.png)
            
       - MultiLabel Classification
        
             Library
             Tensorflow == 1.14.0
             numpy == 1.18.4
             pandas == 0.25.3
             
             https://parksion.tistory.com/78 [박시온 블로그]
             
       - Object Detection
       아래의 라이브러리를 이용하여 개발하였다.
       https://www.tensorflow.org/lite/models/object_detection/overview
   
## 4. 기타
 
   * ### 일정관리
     #### 안드로이드 개발
     ![develp](./readme/develop.png)
     
     #### 서버 및 딥러닝 개발
     ![server](./readme/server.png)
    
     #### 디자인
     ![design](./readme/design.png)
     
     > 모든 Milestone을 완료한 결과  
                                                                                                                                                                                                        
   * ### 추후 개발 목표
        + Pose Estimation 포즈 인식
            원래 Pose Classification으로 이미지 분류의 따른 학습 모델이 였지만,    
            Pose Estimation으로 손 위치, 다리 위치를 인식하여  
            행동 분석을 예측하는 모델 만들기
        + 유아 쇼핑몰 연동  
            비지니스 모델이였던 쇼핑몰 연동을 통한 구매 수수료를  
            앱 안에 넣고 활성하하는 기능 개발
        
        + 부모 커뮤니티  
            부모님끼리의 경험 및 지식공유 할 수 있는 커뮤니티 개발
   * 인용 및 참고             
    
    [베이비뉴스 - 투표 못하는 아기도 ‘참여권’이 있습니다.](https://www.ibabynews.com/news/articleView.html?idxno=63406)
    [이영재 교수 논문](다중지능이론의 교육학적 의의)
    [유아동스마트폰이용사태](https://blog.naver.com/PostView.nhn?blogId=sfdirect&logNo=221603563752&parentCategoryNo=&categoryNo=8&viewDate=&isShowPopularPosts=true&from=search)
    [국내 키즈산업 규모](https://jmagazine.joins.com/economist/view/322077)
    [세계 에듀테크시장 규모](https://biz.chosun.com/site/data/html_dir/2019/05/09/2019050901216.html)
    [딥 러닝을 이용한 자연어 처리 입문](https://wikidocs.net/22933)