.RECIPEPREFIX +=

.PHONY: test
test:
  sh gradlew test

.PHONY: build
build:
  sh gradlew build -x test
  mv -f build/libs/themoviedb.jar deploy/jar/themoviedb.jar
  cd deploy && docker build -f Dockerfile -t themoviedb:latest .
  docker image prune -f

.PHONY: run
run:
  docker run --rm --detach --network=host --name themoviedb themoviedb

.PHONY: logs
logs:
  docker logs -f themoviedb

.PHONY: start
start:
  $(MAKE) build
  $(MAKE) run

.PHONY: stop
stop:
  docker stop themoviedb

.PHONY: restart
restart:
  $(MAKE) stop
  $(MAKE) start

