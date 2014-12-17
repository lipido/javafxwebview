// Force java to connect the calculatorService object
// This is the only way I found to connect the java
// object before any subsequent javascript files are executed,
// such as angular controllers. This sentence must be called
// before any other script which will use calculatorService
alert("__CONNECT__BACKEND__calculatorService");
