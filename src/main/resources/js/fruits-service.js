// Force java to connect the fruitsService object
// This is the only way I found to connect the java
// object before any subsequent javascript files are executed,
// such as angular controllers. This sentence must be called
// before any other script which will use fruitsService
alert("__CONNECT__BACKEND__fruitsService");