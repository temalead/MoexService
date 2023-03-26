FROM openjdk:19
EXPOSE 8005
ADD target/moex-bond-service.jar moex-bond-service.jar
ENTRYPOINT ["java","-jar","/moex-bond-service.jar"]