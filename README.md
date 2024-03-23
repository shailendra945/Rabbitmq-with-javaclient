# Rabbitmq-with-javaclient
it will have implementation of various queueing concept using java client.

===========================================================================
We can use below docker-compose.yaml, to use rabbit mq docker container.

version: "3.2"
services:
rabbitmq:
image: rabbitmq:3-management
container_name: 'rabbitmq'
ports:
- 5672:5672
- 15672:15672
volumes:
- ~/.docker-conf/rabbitmq/data/:/var/lib/rabbitmq/
- ~/.docker-conf/rabbitmq/log/:/var/log/rabbitmq
networks:
- rabbitmq_go_net

networks:
rabbitmq_go_net:
driver: bridge