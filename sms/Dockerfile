FROM java:8
EXPOSE 8080 1080
ADD target/sms-0.0.1-SNAPSHOT.jar /app.jar
CMD java ${JAVA_OPTS} -jar /app.jar