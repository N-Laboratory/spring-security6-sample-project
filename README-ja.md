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

Spring Security 6のサンプルプロジェクト。
このプロジェクトは以下を使用しています。
* Spring Security 6
* Spring Data JPA
* H2 database
* JUnit 5

最近のSpring Security（5.x以降）ではセキュリティ設定の書き方が大幅に変わったことと、Spring Security 6でさらに非推奨・削除された関数が増えたため、備忘録もかねてこのプロジェクトを作成しました。

最新のSpring Security 6を利用した以下の機能を実装しています。
* ログイン
* ログアウト
* アカウント情報表示
* JUnitを利用したSpring Security 6のテスト

データベースにはH2 Databaseを使用しています。インメモリで起動しているため、別途環境を構築する必要はありません。

## 前提条件
ローカルのパソコンに以下がインストール済みであることが前提:
* Git
* Java（JAVA_HOMEを設定しておく必要があります）

また、Eclipse・VSCodeでSpring Bootのプロジェクトが起動できるように事前に環境構築をしておく必要があります。

Spring Security 6になったことで特に環境構築方法等は変わらないためここでは割愛します。

## 使い方
プロジェクトをインポート後、以下の手順でアプリケーションを起動することができます。

### Eclipse
* SpringSecuritySampleApplication.javaを選択
* 右クリック→実行→Javaアプリケーションを押下

### VSCode
* SpringSecuritySampleApplication.javaを選択
* 右クリック→Debug Javaを押下

以下のURLでアプリケーションの動作確認ができます。
* トップページ (http://localhost:8080/)
* ログインぺージ (http://localhost:8080/login)
* マイページ (http://localhost:8080/myPage)

## ユニットテストの実行
Spring Security 6のログイン認証をJUnitを使用してテストします。
### Eclipse
* LoginTestJpnVer.javaを選択
* 右クリック→実行→JUnitテストを押下

### VSCode
* LoginTestJpnVer.javaを選択
* 右クリック→現在のファイルでテストを実行を押下

## Author

👤 **Naoki Nakanishi**

* Website: https://n-laboratory.jp/nlab/
* Twitter: [@N-LAB](https://twitter.com/NL4boratory)