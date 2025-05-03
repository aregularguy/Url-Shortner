FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY . .
RUN ./gradlew clean build
ENTRYPOINT ["java", "-jar", "build/libs/*.jar"]