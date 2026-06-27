FROM gradle:8.5-jdk11 AS build
WORKDIR /app/todo_api_project
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

RUN --mount=type=cache,target=/home/gradle/.gradle \
    ./gradlew dependencies --no-daemon

COPY src ./src

RUN --mount=type=cache,target=/home/gradle/.gradle \
    ./gradlew bootJar --no-daemon


FROM eclipse-temurin:11-jre
WORKDIR /app
COPY --from=build /app/todo_api_project/build/libs/*.jar todo.jar
EXPOSE 8080
CMD ["java","-jar","todo.jar"]