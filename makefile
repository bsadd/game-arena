build-backend:
	cd backend \
    && pwd \
    && mvn clean package \
    && docker build -t gamearena-gamearena-api .

docker-compose: build-backend
	docker compose up --remove-orphans