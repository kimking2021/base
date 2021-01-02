
### logback配置文件说明

```

<?xml version="1.0" encoding="utf-8" ?>
<!-- [configuration属性配置]
    (1) scan:当此属性设置为true时，配置文件如果发生改变，将会被重新加载，默认值为true。
    (2) scanPeriod:设置监测配置文件是否有修改的时间间隔，如果没有给出时间单位，默认单位是毫秒。当scan为true时，此属性生效。默认的时间间隔为1分钟。
    (3) debug:当此属性设置为true时，将打印出logback内部日志信息，实时查看logback运行状态。默认值为false  -->
<configuration scan="true" scanPeriod="60 seconds" debug="false">
    <!--    上下文名称，默认default-->
    <!--    <contextName>default</contextName>-->

    <!-- 定义变量：通用日志输出格式
     %d:日期；%thread：线程名；%-5level：左对齐5个字符显示日志级别；%logger：日志位置；%msg：日志消息；%n：换行符；-->
    <property name="COMMON_LOG_PATTERN" value="%d{yyyy-MM-dd HH:mm:ss} [%thread] [%-5level] %logger - %msg%n" />
    <!-- 定义变量：日志文件输出路径(只可定义绝对路径，${catalina.home}为环境变量中的tomcat根目录) -->
    <property name="LOG_HOME" value="${catalina.home}/logback-logs" />

    <!-- 日志写到控制台（appender：负责写日志的组件） -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <!-- 输出格式化 -->
            <pattern>${COMMON_LOG_PATTERN}</pattern>
        </encoder>
    </appender>

    <!-- DEBUG级别日志配置 -->
    <!--  DEBUG输出到文件（每天生成带日期文件，文件大小最大1k）  -->
    <appender name="DEBUG_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!-- 日志过滤器，只过滤需要的日志 -->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>DEBUG</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <!-- 按照日期和大小循环生成日志 -->
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <!-- 文件名格式 -->
            <fileNamePattern>${LOG_HOME}/%d{yyyy-MM-dd}/debug.%d{yyyy-MM-dd}.(%i).%d{HHmmss}.log</fileNamePattern>
            <!-- 每个文件最大 -->
            <maxFileSize>100MB</maxFileSize>
            <!-- 日志最大的历史 10天 -->
            <maxHistory>10</maxHistory>
        </rollingPolicy>
        <encoder>
            <!-- 输出格式化 -->
            <pattern>${COMMON_LOG_PATTERN}</pattern>
        </encoder>
    </appender>
    <!--  异步DEBUG输出到文件（使用异步日志，先写入阻塞队列，再写入磁盘。避免日志记录时会占用大量的CPU和IO资源）  -->
    <appender name="ASYNC_DEBUG_FILE" class="ch.qos.logback.classic.AsyncAppender">
        <!--   默认当BlockingQueue还有20%容量，将丢弃TRACE、DEBUG和INFO级别的event，只保留WARN和ERROR级别的event。为了保持所有的events，设置该值为0。     -->
        <discardingThreshold>0</discardingThreshold>
        <!-- 队列大小，默认256，该值会影响性能 -->
        <queueSize>1024</queueSize>
        <!-- 关联appender -->
        <appender-ref ref="DEBUG_FILE"/>
    </appender>

    <!--  WARN级别日志配置  -->
    <!--  WARN输出到文件（每天生成带日期文件，文件大小最大1k）  -->
    <appender name="WARN_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!-- 日志过滤器，只过滤需要的日志 -->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>WARN</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <!-- 按照日期和大小循环生成日志 -->
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <!-- 文件名格式 -->
            <fileNamePattern>${LOG_HOME}/%d{yyyy-MM-dd}/warn.%d{yyyy-MM-dd}.(%i).%d{HHmmss}.log</fileNamePattern>
            <!-- 每个文件最大 -->
            <maxFileSize>100MB</maxFileSize>
            <!-- 日志最大的历史 10天 -->
            <maxHistory>10</maxHistory>
        </rollingPolicy>
        <encoder>
            <!-- 输出格式化 -->
            <pattern>${COMMON_LOG_PATTERN}</pattern>
        </encoder>
    </appender>
    <!--  异步WARN输出到文件（使用异步日志，先写入阻塞队列，再写入磁盘。避免日志记录时会占用大量的CPU和IO资源）  -->
    <appender name="ASYNC_WARN_FILE" class="ch.qos.logback.classic.AsyncAppender">
        <!--   默认当BlockingQueue还有20%容量，将丢弃TRACE、DEBUG和INFO级别的event，只保留WARN和ERROR级别的event。为了保持所有的events，设置该值为0。     -->
        <discardingThreshold>0</discardingThreshold>
        <!-- 队列大小，默认256，该值会影响性能 -->
        <queueSize>1024</queueSize>
        <!-- 关联appender -->
        <appender-ref ref="WARN_FILE"/>
    </appender>

    <!--  ERROR级别日志配置  -->
    <!--  ERROR输出到文件（每天生成带日期文件，文件大小最大1k）  -->
    <appender name="ERROR_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!-- 日志过滤器，只过滤需要的日志 -->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>ERROR</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
        <!-- 按照日期和大小循环生成日志 -->
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <!-- 文件名格式 -->
            <fileNamePattern>${LOG_HOME}/%d{yyyy-MM-dd}/error.%d{yyyy-MM-dd}.(%i).%d{HHmmss}.log</fileNamePattern>
            <!-- 每个文件最大 -->
            <maxFileSize>100MB</maxFileSize>
            <!-- 日志最大的历史 10天 -->
            <maxHistory>10</maxHistory>
        </rollingPolicy>
        <encoder>
            <!-- 输出格式化 -->
            <pattern>${COMMON_LOG_PATTERN}</pattern>
        </encoder>
    </appender>
    <!--  异步ERROR输出到文件（使用异步日志，先写入阻塞队列，再写入磁盘。避免日志记录时会占用大量的CPU和IO资源）  -->
    <appender name="ASYNC_ERROR_FILE" class="ch.qos.logback.classic.AsyncAppender">
        <!--   默认当BlockingQueue还有20%容量，将丢弃TRACE、DEBUG和INFO级别的event，只保留WARN和ERROR级别的event。为了保持所有的events，设置该值为0。     -->
        <discardingThreshold>0</discardingThreshold>
        <!-- 队列大小，默认256，该值会影响性能 -->
        <queueSize>1024</queueSize>
        <!-- 关联appender -->
        <appender-ref ref="ERROR_FILE"/>
    </appender>

    <!--  CUSTOM级别日志配置  -->
    <!--  CUSTOM输出到文件（每天生成带日期文件，文件大小最大1k）  -->
    <appender name="CUSTOM_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!-- 按照日期和大小循环生成日志 -->
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <!-- 文件名格式 -->
            <fileNamePattern>${LOG_HOME}/%d{yyyy-MM-dd}/custom/custom.%d{yyyy-MM-dd}.(%i).%d{HHmmss}.log</fileNamePattern>
            <!-- 每个文件最大 -->
            <maxFileSize>100MB</maxFileSize>
            <!-- 日志最大的历史 10天 -->
            <maxHistory>10</maxHistory>
        </rollingPolicy>
        <encoder>
            <!-- 输出格式化 -->
            <pattern>${COMMON_LOG_PATTERN}</pattern>
        </encoder>
    </appender>
    <!--  异步CUSTOM输出到文件（使用异步日志，先写入阻塞队列，再写入磁盘。避免日志记录时会占用大量的CPU和IO资源）  -->
    <appender name="ASYNC_CUSTOM_FILE" class="ch.qos.logback.classic.AsyncAppender">
        <!--   默认当BlockingQueue还有20%容量，将丢弃TRACE、DEBUG和INFO级别的event，只保留WARN和ERROR级别的event。为了保持所有的events，设置该值为0。     -->
        <discardingThreshold>0</discardingThreshold>
        <!-- 队列大小，默认256，该值会影响性能 -->
        <queueSize>1024</queueSize>
        <!-- 关联appender -->
        <appender-ref ref="CUSTOM_FILE"/>
    </appender>

    <!-- “根”日志的记录器（root日志记录器的默认level是DEBUG），最多一个root元素
        日志级别：TRACE<DEBUG<INFO<WARN<ERROR
        日志级别定义在类: ch.qos.logback.classic.Level -->
    <root level="WARN">
        <appender-ref ref="STDOUT"/>
        <appender-ref ref="DEBUG_FILE"/>
        <appender-ref ref="ASYNC_WARN_FILE"/>
        <appender-ref ref="ASYNC_ERROR_FILE"/>
    </root>

    <!-- 指定包打印日志（一般用于定制输出日志）。
        name：用来指定某个包或者某个类的日志打印（包名可以是类的全路径，也可以是部分包名）
        value：最小日志级别
        additivity：（false：子logger只在自己的appender中输出；
        true：logger不止会在自己的appender里输出，还会在root的logger的appender里输出）-->

    <!--
    <logger name="com.demo.app.controller" level="INFO" additivity="false">
        <appender-ref ref="STDOUT"/>
        <appender-ref ref="ASYNC_CUSTOM_FILE"/>
    </logger>
    -->

</configuration>


```