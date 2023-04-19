test-build:
	docker build -t sergzv/kameleoon:v0.0.1 .
test-run:
	docker run --rm --name testtask sergzv/kameleoon:v0.0.1
test-remove:
	docker rmi sergzv/kameleoon:v0.0.1
	docker images
test-reb&run:
	docker rmi sergzv/kameleoon:v0.0.1
	docker build -t sergzv/kameleoon:v0.0.1 .
	docker run --rm --name testtask sergzv/kameleoon:v0.0.1