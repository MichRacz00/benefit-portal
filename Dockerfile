FROM eclipse-temurin:17-jre-alpine
COPY target/benefit-portal-0.0.1-SNAPSHOT.jar benefit-portal.jar

ENTRYPOINT ["java","-jar","/benefit-portal.jar"]
EXPOSE 808