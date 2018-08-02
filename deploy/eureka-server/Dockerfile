FROM fabric8/java-jboss-openjdk8-jdk:1.4

ENV JAVA_APP_JAR="app.jar"
ENV JAVA_MAX_MEM_RATIO=50
ENV AB_OFF ""

ADD --chown=jboss:jboss https://www.aliyuncs.com/soft/eureka-1.0.0.jar /deployments/app.jar
