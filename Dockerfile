FROM gradle as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM eclipse-temurin:17-jdk-focal
COPY --from=build /home/gradle/src/build/libs/blazebankcardservice-1.0-SNAPSHOT.jar /app/blazebankcardservice-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "app/blazebankcardservice-1.0-SNAPSHOT.jar"]