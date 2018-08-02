FROM fabric8/java-jboss-openjdk8-jdk:1.4

ENV JAVA_APP_JAR="app.jar"
ENV JAVA_MAX_MEM_RATIO=50
ENV AB_OFF ""

ADD --chown=jboss:jboss https://www.aliyuncs.com/soft/config-server.jar /deployments/app.jar

ENV ENCRYPT_KEY_STORE_PASSWORD=letmein
ENV ENCRYPT_KEY_STORE_ALIAS=mytestkey
ENV ENCRYPT_KEY_STORE_SECRET=changeme
