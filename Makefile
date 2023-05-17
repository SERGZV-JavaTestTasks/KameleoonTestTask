#-------------------------------------test-build-------------------------------------------
test-build:
	docker build -t sergzv/kameleoon:v0.0.1 .
test-run:
	docker run --rm -p 7777:8080 --name testtask sergzv/kameleoon:v0.0.1
test-remove:
	docker rmi sergzv/kameleoon:v0.0.1
	docker images
test-rebrun:
	docker rmi sergzv/kameleoon:v0.0.1
	docker build -t sergzv/kameleoon:v0.0.1 .
	docker run --rm -p 7777:8080 --name testtask sergzv/kameleoon:v0.0.1
#-------------------------------------build-------------------------------------------
build:
	docker build -t sergzv/kameleoon:v0.0.2 .
push:
	docker push sergzv/kameleoon:v0.0.2
run:
	docker run -p 7777:8080 -d --name testtask sergzv/kameleoon:v0.0.2
remove-container:
	docker rm testtask
	docker ps -a
remove-image:
	docker rmi sergzv/kameleoon:v0.0.2
	docker images