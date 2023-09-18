#! /bin/bash
docker exec postgresql_container  bash -c "curl -O -L https://github.com/bouchaiblemaire/ressources/raw/main/postgresql/employee_bd.sql.tar.gz &&\
tar xvfz employee_bd.sql.tar.gz && PGPASSWORD=password psql \
  -h 127.0.0.1 \
  -p 5432 \
  -d devavance_db \
  -U devavance_user \
  -f employee_bd.sql&&rm employee_bd.sql.*"