FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=./build/libs/appuntes-api.jar

ARG PASS_DB
ARG USER_DB

ENV PASS_DB=${PASS_DB}
ENV USER_DB=${USER_DB}
CMD echo "El valor de PASS_DB es: $PASS_DB" && echo "El valor de USER_DB es: $USER_DB"


WORKDIR /opt/app
ADD ${JAR_FILE} "app.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]