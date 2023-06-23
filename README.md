# MovieApp_Retrofit_MVVM_Android
[One of Geeks for Geeks's Android Pages](https://www.geeksforgeeks.org/android-build-a-movie-app-using-retrofit-and-mvvm-architecture-with-kotlin/)<br>
위 링크에 있는 것을 읽고 따라하면서 Android에서 Kotlin으로 Retrofit 라이브러리와 MVVM 패턴을 학습하고자 한다.

# This is the translation of [this link](https://www.geeksforgeeks.org/android-build-a-movie-app-using-retrofit-and-mvvm-architecture-with-kotlin/)
Model-View-ViewModel(MVVM)은 MVP와 MVC 디자인 패턴의 모든 결함을 극복한 산업에서 인정받는 아키텍쳐 패턴이다.<br>
MVVM은 data presentation logic(Views or UI)를 핵심 비지니스 로직과 분리하는 것을 제안한다.<br>

<b>MVVM의 분리된 code layers</b><br>
<ul>
  <li><b>Model : </b> 이 레이어는 data sources의 추상화를 책임진다. Model과 VM은 data를 얻고 저장하기 위해 함께 일한다.</li>
  <li><b>View : </b> View의 목적은 사용자의 행동을 VM에게 알리는 것이다. 이 레이어는 VM을 관찰(감시)하고 app의 어떤 로직도 포함하지 않는다.</li>
  <li><b>ViewModel : </b> 이것은 View와 관련있는 data stream을 노출시킨다. 게다가, Model과 View 사이의 연결을 제공한다. </li>
</ul>
<img src="https://media.geeksforgeeks.org/wp-content/uploads/20201002215007/MVVMSchema.png" width="500" height="300">

이 article에서, 우리는 MVVM 아키텍쳐와 Kotlin 언어를 사용해 간단한 movie 상세 앱을 빌드흔 법을 배울 것이다.<br>
이 앱을 빌드하기 위해서, 우리는 MVVM 아키텍쳐와 Retrofit 라이브러리가 필요하다. Retrofit은 a third-party library로 우리가 안드로이드에서 network request(요청)을 하는 것을 돕는다. 우리는 The Movie Database Website (TMDB)로 부터 데이터를 fetch(가져오는 것)할 것이다. 이 웹사이트(TMDB)를 사용하기 위해서, 로그인하고 API키를 가져올 필요가 있다. 이 예에서, 우리는 인기있는 영화 목록을 fetch할 것이다.<br>
[TMDB](https://developer.themoviedb.org/reference/movie-popular-list)를 클릭해서 바로 사이트로 이동해 보자.
