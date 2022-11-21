[lines]: https://img.shields.io/tokei/lines/github/Jachou-yt/JachLogger?style=plastic
[GitHub commit activity]: https://img.shields.io/github/commit-activity/m/Jachou-yt/JachLogger?style=plastic

![lines]
<br>
![GitHub commit activity]


# JachLogger
Useful Logger with many options which you have never seen. See the [wiki](https://github.com/Jachou-yt/JachLogger/wiki) for more information.
```xml
<dependency>
  <groupId>fr.jachou</groupId>
  <artifactId>jachlogger</artifactId>
  <version>1.1-SNAPSHOT</version>
</dependency>
```
# Usage
## Logger
Whitout File logger :

```java
// Create Jachlogger
JachLogger jachLogger = new JachLogger();
jachLogger.info("Example info");
```
With File logger :

```java
// Create logger file
LoggerFile loggerFile = new LoggerFile("test", "path");

JachLogger jachLogger = new JachLogger(loggerFile);
jachLogger.info("Example info");
```
