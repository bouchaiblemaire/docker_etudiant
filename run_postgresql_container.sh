#! /bin/bash

echo "Auteur : B. LEMAIRE"
echo "Lancement du container postgresql"
echo "Nom du container : postgresql_container"
echo "Host : localhost"
echo "port : 5433"
echo "base de donnee : devavance_db"
echo "user : devavance_user"
echo "password : password"

docker run -it -d  --name postgresql_container -p 5433:5432 release_postgresql_image

exit 0

