# JachLogger
Useful Logger with many options which you have never seen. See the wiki for more information.
# Dowload
You can download the Jachlogger with this link : https://github.com/Jachou-yt/JachLogger/releases/
# Usage
## Logger
Whitout File logger :

```java
JachLogger jachLogger = new JachLogger();

jachLogger.info("Exeample info");
```
With File logger :

```java
LoggerFile loggerFile = new LoggerFile("test", "path");

JachLogger jachLogger = new JachLogger(loggerFile);
        
jachLogger.info("Exeample info");
```
