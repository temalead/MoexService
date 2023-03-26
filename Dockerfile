FROM openjdk:19
EXPOSE 8080
ADD target/MoexBondService.jar MoexBondService.jar
ENTRYPOINT ["java","-jar","/MoexBondService.jar"]