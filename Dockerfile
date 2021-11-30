FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /test9
ARG JAR_FILE=${WORKDIR}/target/test9-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENV PORT 9090
EXPOSE $PORT

VOLUME ["/test9/logs"]

ENTRYPOINT ["java","-jar","app.jar"]
#CMD ["/bin/sh", "-c", "chmod +rwx app.jar", "java -jar app.jar"]


