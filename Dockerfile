FROM  adoptopenjdk:11-jre-hotspot

#ENV BASE /opt/microservices/inventory-service
#
#RUN apt-get update
#RUN apt-get install unzip
#
#RUN mkdir -p $BASE/bin
#
#COPY run_application.sh $BASE/bin
#RUN chmod -R +x $BASE/bin

VOLUME /tmp

#RUN mvnw install
COPY target/*.jar application.jar


ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v1.12.0/opentelemetry-javaagent.jar /urs/local/opentelemetry-java/opentelemetry-javaagent-v1.12.0.jar

#COPY target/inventory-service-*.jar $BASE/
#


ENV JAVA_OPTS -javaagent:/urs/local/opentelemetry-java/opentelemetry-javaagent-v1.12.0.jar


EXPOSE 8009

CMD ["java", "-javaagent:/urs/local/opentelemetry-java/opentelemetry-javaagent-v1.12.0.jar", "-jar", "application.jar"]
