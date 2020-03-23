FROM java:8
EXPOSE 8761
ADD /target/hub-callere-2.0.0.jar hub-callere-2.0.0.jar
ENTRYPOINT ["java","-jar","hub-callere-2.0.0.jar"]