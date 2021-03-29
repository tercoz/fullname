FROM openjdk:8-jre-alpine
RUN addgroup -S user && adduser -S user -G user
USER user:user
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","my.name.fullname.FullnameApplication"]