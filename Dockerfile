FROM maven:3-openjdk-8

ARG DB_USERNAME

ARG DB_PASSWORD

WORKDIR /app

COPY . /app/

EXPOSE 8080

RUN sed -i "s|spring.datasource.username=|spring.datasource.username=$DB_USERNAME|" src/main/resources/application.properties &&\
          sed -i "s|spring.datasource.password=|spring.datasource.password=$DB_PASSWORD|" src/main/resources/application.properties

CMD ["mvn", "spring-boot:run"]
