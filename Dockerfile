FROM java:8

MAINTAINER WolfAlexander nikal@kth.se

COPY target/SpringJavaFXAspectJTestApp /home/SpringJavaFXAspectJTestApp

RUN ls -la /home/SpringJavaFXAspectJTestApp

CMD ["java", "-jar", "/home/SpringJavaFXAspectJTestApp/SpringJavaFXAspectJTestApp.jar"]