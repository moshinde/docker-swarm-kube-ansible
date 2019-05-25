# docker-swarm-kube-ansible#
Using docker

sudo docker network create --driver=bridge --subnet=172.16.0.0/16 gameOfContainers

sudo docker run -d --name dbserver -e MYSQL_ROOT_PASSWORD=****** -e MYSQL_DATABASE=currency -p 3306:3306 --net gameOfContainers --ip 172.16.14.211 mysql:latest

sudo docker run -dit --name currency-exchange-service -p 8300:8300 --net gameOfContainers --ip 172.16.15.111 monicashinde3/currency-exchange-service

sudo docker run -dit --name currency-conversion-service  -e SQL_HOST_IP=172.16.14.211 -e SQL_PORT=3306 -e SQL_DB=currency -e SQL_PWD=***** -e EXCHANGE_SERVICE_HOST=172.16.15.111 -p 8400:8400 --net gameOfContainers --ip 172.16.15.112 monicashinde3/currency-conversion-service
