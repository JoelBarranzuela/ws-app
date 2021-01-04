FROM maven:3.6-jdk-8-alpine AS BUILDER
WORKDIR /app
COPY pom.xml  .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package
FROM openjdk:8-jre-alpine
RUN apk add --no-cache tzdata
ENV TZ=America/Lima
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY --from=builder /app/target/ws-app-1.jar  /
CMD ["java","-jar","/wsp-app-1.jar"]