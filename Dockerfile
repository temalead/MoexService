FROM maven:3.8.7-eclipse-temurin-19 AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B -f pom.xml clean package -DskipTests

FROM eclipse-temurin:19
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8005
ENTRYPOINT ["java","-jar","app.jar"]