# JachLogger
Useful Logger with many options which you have never seen. See the wiki for more information.
# Usage
## Logger
Whitout File logger :

```java
JachLogger jachLogger = new JachLogger();

jachLogger.info("Example info");
```
With File logger :

```java
LoggerFile loggerFile = new LoggerFile("test", "path");

JachLogger jachLogger = new JachLogger(loggerFile);
        
jachLogger.info("Example info");
```
