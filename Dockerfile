FROM  adoptopenjdk:11-jre-hotspot



WORKDIR /opt/inventory

#RUN mvnw install
COPY ./inventory/target/*.jar application.jar


ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.12.0/opentelemetry-javaagent.jar /urs/local/opentelemetry-java/opentelemetry-javaagent-v1.12.0.jar


ENV JAVA_OPTS -javaagent:/urs/local/opentelemetry-java/opentelemetry-javaagent-v1.12.0.jar


EXPOSE 8009

CMD ["java", "-javaagent:/urs/local/opentelemetry-java/opentelemetry-javaagent-v1.12.0.jar", "-jar", "application.jar"]
