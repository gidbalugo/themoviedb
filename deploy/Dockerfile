FROM openjdk:8

EXPOSE 9090

COPY jar/themoviedb.jar /
COPY ./docker-entrypoint.sh /
RUN chmod +x /docker-entrypoint.sh

ENTRYPOINT ["/docker-entrypoint.sh"]