docker run --rm \
  --platform linux/amd64 \
  -d \
  -e MYSQL_ROOT_PASSWORD=password \
  -p 3306:3306 \
  -v mysql:/var/lib/mysql \
  mysql:8.0.33