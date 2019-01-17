FROM openjdk:8-jre

ADD target/hello-1.0.jar .

CMD java -jar hello-1.0.jar
