## Coding Challenge: NYC Schools

This repository contains a detailed sample app that implements using Java, Kotlin, MVVM architecture (ViewModel, LiveData, ViewBinding, Navigation Component), Dagger2, Kotlin Coroutines, Retrofit, OkHttp3.

<p align="center">
  <img src="images/demo1.gif" width = "320" height="672"/>
  <img src="images/demo2.gif" width = "320" height="672"/>
</p>

# Architecture Blueprint
<p align="center">
  <img src="images/ArchitecturalBluePrint.JPG"/>
  <br>
</p>
  
# Dagger Dependency Graph
<p align="center">
  <img src="images/DaggerComponentDiagram.JPG"/>
  <br>
</p>

# Dagger Dependency Graph with Scope
<p align="center">
  <img src="images/DaggerScopeDiagram.JPG"/>
  <br>
</p>

# Github branches
<p align="center">
  <img src="images/GithubModel.JPG"/>
  <br>
</p>

### The app has following packages:
1. **di**: It contains the Dagger (dependency injection) related packages, like component, sub component, module and scope.
2. **model**: It contains all the data accessing and manipulating components.
3. **network**: Contains Api urls, network exception, custom response object and status of request.
4. **repository**: Repository is bridge between viewmodel and data. It is responsible for get accessing data from internet using network package.
5. **ui**: It contains Activities, Fragments and adapter.
6. **utils**: It contains utility classes like itemClickListener
7. **viewmodel**: MainViewModel, a bridge between view and repository.

### Library reference resources:
1. Github api for list of commits: https://developer.github.com/v3/repos/commits/
2. Dagger: https://developer.android.com/training/dependency-injection/dagger-android
3. Navigation Component: https://developer.android.com/guide/navigation/navigation-getting-started
4. DataBinding: https://developer.android.com/topic/libraries/data-binding
5. ViewBinding: https://developer.android.com/topic/libraries/view-binding
6. Kotlin Coroutine: https://kotlinlang.org/docs/coroutines-basics.html#coroutines-are-light-weight
7. Retrofit: https://github.com/square/retrofit
8. OkHttp3 (Logging Interceptor): https://github.com/square/okhttp
9. OkHttp3 (Network Connection Interceptor): https://medium.com/programming-lite/retrofit-2-handling-network-error-defc7d373ad1
  
### Testing Libraries
  1. JUnit 4: https://github.com/junit-team/junit4
  2. Mokito: https://github.com/mockito/mockito
