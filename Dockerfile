FROM maven:3.9.2 as MAVEN
WORKDIR /home/api
COPY . /home/api
RUN java --version
RUN mvn clean package --batch-mode --update-snapshots
RUN ls target

FROM openjdk:17-alpine
COPY --from=MAVEN /home/api/target/*.jar *.jar
RUN ls -la
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "*.jar"]