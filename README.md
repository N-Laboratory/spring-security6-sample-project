<h1 align="center">Spring Security 6 Sample Project</h1>
<p align="center">
  <img src="https://img.shields.io/badge/-Java-007396.svg?logo=Java&style=flat">
  <img src="https://img.shields.io/badge/-Spring Boot-lightyellow.svg?logo=Spring Boot&style=flat">
  <img src="https://img.shields.io/badge/-Spring Security-lightyellow.svg?logo=Spring Security&style=flat">
  <img src="https://img.shields.io/badge/-JUnit5-F36D00.svg?logo=JUnit5&style=flat">
  <img src="https://img.shields.io/badge/-Windows-0078D6.svg?logo=windows&style=flat">
  <img src="https://img.shields.io/badge/-Mac-grey.svg?logo=macos&style=flat">
  <img src="https://img.shields.io/badge/-Linux-black.svg?logo=linux&style=flat">
  <img src="https://img.shields.io/badge/-VSCode-007ACC.svg?logo=visualstudiocode&style=flat">
  <a href="https://twitter.com/NL4boratory" target="_blank">
    <img alt="Twitter: N-LAB" src="https://img.shields.io/twitter/follow/NL4boratory.svg?style=social" />
  </a>
  <a href="https://github.com/N-Laboratory" target="_blank">
    <img src="https://img.shields.io/badge/-FollowMyAccount-grey.svg?logo=github&style=flat">
  </a>
</p>

[日本語版 README はこちら](https://github.com/N-Laboratory/spring-security6-sample-project/blob/main/README-ja.md)

Sample project using Spring Security 6.
This project use following.
* Spring Security 6
* Spring Data JPA
* H2 database
* JUnit 5

I created this project for learning Spring Security 6, because recent Spring Security (5.x) has drastically changed security settings, and Spring Security 6 has further deprecated or removed more functions.

You can do the following in this project.
* Login
* Logout
* Show user account info
* Test spring security by JUnit.

This project use H2 Database in-memory mode. So you don't have to build database environment.

## Prerequisites
Make sure you have installed all of the following prerequisites on your development machine:
* Git - Download & Install Git. OSX and Linux machines typically have this already installed.
* Java - Download & Install Java and set JAVA_HOME.

You also have to build spring-boot running environment (Eclipse or VSCode) in advance.

## Usage
### Eclipse
* Click SpringSecuritySampleApplication.java
* Right click and run as Java Application

### VSCode
* Click SpringSecuritySampleApplication.java
* Right click and click Debug Java

You can access following page.
* Top page (http://localhost:8080/)
* Login page (http://localhost:8080/login)
* My page (http://localhost:8080/myPage)

## Run unit tests
Test spring security login authentication by JUnit.
### Eclipse
* Click LoginTestEngVer.java
* Right click and run as JUnit Test

### VSCode
* Click LoginTestEngVer.java
* Right click and click running the current test file

## Author

👤 **Naoki Nakanishi**

* Website: https://n-laboratory.jp/nlab/
* Twitter: [@N-LAB](https://twitter.com/NL4boratory)