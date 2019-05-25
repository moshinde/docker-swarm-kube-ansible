FROM tomcat:8-jre8
ADD target/currency-conversion-service-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
ENV SQL_HOST_IP=localhost
ENV SQL_PORT=3306
ENV SQL_DB=currency
ENV SQL_PWD=Margery@123
ENV EXCHANGE_SERVICE_HOST=localhost
RUN sh -c 'touch /usr/local/tomcat/webapps/currency-conversion-service-0.0.1-SNAPSHOT.war'
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/currency-conversion-service-0.0.1-SNAPSHOT.war"]
EXPOSE 8400