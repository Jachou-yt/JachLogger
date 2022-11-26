# JachLogger
Useful Logger with many options which you have never seen. See the wiki for more information.
```xml
<dependency>
  <groupId>fr.jachou</groupId>
  <artifactId>jachlogger</artifactId>
  <version>1.1-SNAPSHOT</version>
</dependency>

<repositories>
        <repository>
            <id>space-jachlogger</id>
            <url>https://maven.pkg.jetbrains.space/jachou/p/jachou-s-project/jachlogger</url>
        </repository>
    </repositories>
```
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
