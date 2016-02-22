javafxwebview
=============

A demonstration of how to create next-gen Java desktop applications with [AngularJS](https://www.angularjs.org) and [Bootstrap](http://getbootstrap.com), by means of the JavaFX WebView component.

Requisites
==========
1. Download and install Java 8.
2. Install [Apache Maven](http://maven.apache.org).


Download, compile and run
=========================
* Clone this repository (or download directly from github)
```
git clone https://github.com/lipido/javafxwebview.git
```
* Compile and run
```
cd javafxwebview
mvn package
cd target
java -jar javafx-webview-demo-0.0.1-SNAPSHOT.jar
```

Warning: Windows Users
-------------
There is a bug since Java 8 update 60 in Windows (http://hg.openjdk.java.net/openjfx/9-dev/rt/rev/d4f8c9496683),
where WebView is unable to load resources of the webpage if the project is delivered inside a JAR file.
The workaround is to run the project in this way:
```
cd javafxwebview
mvn package
cd target
java -cp classes;dependency-jars\json-simple-1.1.1.jar
es.uvigo.ei.sing.webviewdemo.WebViewDemo
```
