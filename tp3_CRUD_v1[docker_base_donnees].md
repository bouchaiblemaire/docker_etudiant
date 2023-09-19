# TP3 - Découverte d'un application Web dockerisé



## Objectifs de l'application qui va être développée

Nous allons cours de ce travail pratique analyser une infrastructure d'une application Web disposant : 
  * D'un backend : container Docker contenant un serveur de base de données Postgresql et d'une base de donnes "employés"
  * D'une API CRUD permettant d'exploiter la base de données
  * Le font-end sera à écrire sous forme de page JSP

**Objectifs : Pour cette séance de travail pratique**

**Découverte d'une application dockerisé**
1. Déploiement du container "Base de données"
2. Découverte de la base de données grâce à l'application DBViewer
3. Création d'une API CRUD d'accès à la base de données




---

---


##### **Exercice 1 : Le container "Base de données"**

Cloner le dépôt : https://github.com/bouchaiblemaire/docker_etudiant.git

Nous allons dans un premier temps étudier les fichiers :

 * `Dockerfile`
 * `build_postgresql_image.sh` 
 * `run_postgresql_container.sh`
 * `run_script_bd.sh`
 
Les fichiers `Dockerfile` et `build_postgresql_image.sh`
 
Editez les fichiers `Dockerfile` et `build_postgresql_image.sh` et interpréter leur contenu respectif. 

**Vous ne devez pas lancer le script** `build_postgresql_image.sh`.


---

##### **Question 1 :** Le fichier `Dockerfile`

  1. Quel est le rôle de ce fichier ?
  2. Expliquez les étapes décrites dans ce fichier.



**Evaluation 1:**

Vous devrez consigner votre réponse dans la zone **rendu n°1 : Dockerfile** sur la plateforme [einfo-learning.fr](http://enfin-learning.fr)

---

##### **Question 2 :** Le fichier `build_postgresql_image.sh`


  1. Donnez les droits d'exécution à ce fichier puis le lancer et exécuter ce script.


**Correction**

```shell 
chmod +x build_postgresql_image.sh
sudo ./build_postgresql_image.sh
```


  2. Vérifier que l'image a bien été créee. Quelle(s) commande(s) utilisez vous pour faire cette vérification 


**Evaluation 2: **

Vous devrez consigner votre réponse dans la zone **rendu n°2 : validation création image** sur la plateforme  [einfo-learning.fr](http://enfin-learning.fr)

---



**Correction**

```shell 
key_6@einfolearning:~/cours/dev_avance/docker_etudiant$ sudo ./build_postgresql_image.sh 
[+] Building 55.1s (11/12)                                                                                                                        docker:default
 => [internal] load build definition from Dockerfile                                                                                                        0.0s
[+] Building 55.9s (12/13)                                                                                                                        docker:default
[+] Building 55.9s (13/13) FINISHED                                                                                                               docker:default
 => [internal] load build definition from Dockerfile                                                                                                        0.0s
 => => transferring dockerfile: 1.13kB                                                                                                                      0.0s
 => [internal] load .dockerignore                                                                                                                           0.0s
 => => transferring context: 2B                                                                                                                             0.0s
 => [internal] load metadata for docker.io/library/ubuntu:14.04                                                                                             2.1s
 => [1/9] FROM docker.io/library/ubuntu:14.04@sha256:64483f3496c1373bfd55348e88694d1c4d0c9b660dee6bfef5e12f43b9933b30                                      17.9s
 => => resolve docker.io/library/ubuntu:14.04@sha256:64483f3496c1373bfd55348e88694d1c4d0c9b660dee6bfef5e12f43b9933b30                                       0.0s
 => => sha256:64483f3496c1373bfd55348e88694d1c4d0c9b660dee6bfef5e12f43b9933b30 1.20kB / 1.20kB                                                              0.0s
 => => sha256:881afbae521c910f764f7187dbfbca3cc10c26f8bafa458c76dda009a901c29d 945B / 945B                                                                  0.0s
 => => sha256:13b66b487594a1f2b75396013bc05d29d9f527852d96c5577cc4f187559875d0 3.31kB / 3.31kB                                                              0.0s
 => => sha256:2e6e20c8e2e69fa5c3fcc310f419975cef5fbeb6f7f2fe1374071141281b6a06 70.69MB / 70.69MB                                                            7.1s
 => => sha256:0551a797c01db074ab0233ceb567e66b8ebdcb9de9a2e7baa36d57dfbca463a3 72.66kB / 72.66kB                                                            0.3s
 => => sha256:512123a864da5e2a62949e65b67106292c5c704eff90cac2b949fc8d7ac1e58e 189B / 189B                                                                  0.5s
 => => extracting sha256:2e6e20c8e2e69fa5c3fcc310f419975cef5fbeb6f7f2fe1374071141281b6a06                                                                  10.4s
 => => extracting sha256:0551a797c01db074ab0233ceb567e66b8ebdcb9de9a2e7baa36d57dfbca463a3                                                                   0.0s
 => => extracting sha256:512123a864da5e2a62949e65b67106292c5c704eff90cac2b949fc8d7ac1e58e                                                                   0.0s 
 => [2/9] RUN locale-gen en_US.UTF-8                                                                                                                        2.3s 
 => [3/9] RUN apt-get update                                                                                                                                6.9s 
 => [4/9] RUN apt-get -y install postgresql postgresql-client postgresql-contrib                                                                           13.9s 
 => [5/9] RUN pg_dropcluster 9.3 main && pg_createcluster --locale en_US.UTF-8 9.3 main                                                                     3.3s 
 => [6/9] RUN echo "host    all             all             0.0.0.0/0 trust" >> /etc/postgresql/9.3/main/pg_hba.conf                                        0.4s 
 => [7/9] RUN echo "listen_addresses='*'" >> /etc/postgresql/9.3/main/postgresql.conf                                                                       1.0s 
 => [8/9] RUN service postgresql start &&  su postgres sh -c "createuser -d -r -s devavance_user" &&  su postgres sh -c "psql -c "alter user devavance_use  3.7s 
 => [9/9] RUN apt install curl -y                                                                                                                           3.6s 
 => exporting to image                                                                                                                                      0.7s
 => => exporting layers                                                                                                                                     0.7s 
 => => writing image sha256:2f4da4482dafb92259ea6136479a27d7ef7443e411660288ceb81fdc5933820a                                                                0.0s 
 => => naming to docker.io/library/release_postgresql_image                                                                                                 0.0s key_6@einfolearning:~/cours/dev_avance/docker_etudiant$            
```


  * Verification de l'image a bien été créee
```shell 
key_6@einfolearning:~/cours/dev_avance/docker_etudiant$ sudo docker image ls
REPOSITORY                 TAG       IMAGE ID       CREATED         SIZE
release_postgresql_image   latest    2f4da4482daf   2 minutes ago   337MB
key_6@einfolearning:~/cours/dev_avance/docker_etudiant$ 
```

---

##### **Question 3 :** Le fichier Le fichier `run_postgresql_container.sh`

**Question :** Répondez aux mêmes questions que la partie 1.




**Evaluation 3**

Vous devrez consigner votre réponse dans la zone **rendu n°3: exécution conteneur** sur la plateforme  [einfo-learning.fr](http://enfin-learning.fr)


---

**Reponse :**
```
./run_postgresql_container.sh 
Auteur : B. LEMAIRE
Lancement du container postgresql
Nom du container : postgresql_container
Host : localhost
port : 5433
base de donnee : devavance_db
user : devavance_user
password : password
15c426fe096e63ab6a515d43e9fa9b528d3e09de33843a593d84bed9184a501f
```
**Note :** : Le port 5433 est le port exposé à l'extérieur du container. Le port interne est 5432.


3. Le fichier `run_script_bd.sh`
**Question:** Répondez aux mêmes questions que la partie 1.


**Evaluation 4**

Vous devrez consigner votre réponse dans la zone **rendu n°4: peuplement de la base de données** sur la plateforme  [einfo-learning.fr](http://enfin-learning.fr)



**Reponse :**

```shell
./run_script_bd.sh 
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0
100   614  100   614    0     0   1135      0 --:--:-- --:--:-- --:--:--  1135
employee_bd.sql
DROP TABLE
CREATE TABLE
INSERT 0 1
INSERT 0 1
INSERT 0 1
INSERT 0 1
INSERT 0 1
INSERT 0 1
INSERT 0 1
INSERT 0 1
```


4. Ecrire un script permettant de réaliser les 3 opérations précédentes et le tester.

5. en utilisant le moniteur `psql` en ligne de commande. Coonectez-vous à la base de données et exécuter des requêtes sur celle-ci.


** Correction**

```
key_6@einfolearning:~/Bureau$ psql -h 127.0.0.1 -d devavance_db -U devavance_user -p 5433
psql (14.9 (Ubuntu 14.9-0ubuntu0.22.04.1), server 9.3.24)
Type "help" for help.

devavance_db=# 
devavance_db=# \d
                  List of relations
 Schema |      Name       |   Type   |     Owner      
--------+-----------------+----------+----------------
 public | employee        | table    | devavance_user
 public | employee_id_seq | sequence | devavance_user
(2 rows)

devavance_db=# select * from employee;
 id |     name      |         email         |     phone      |             address              
----+---------------+-----------------------+----------------+----------------------------------
  1 | Karim Mahmoud | kmshawky20@gmail.com  | 0097450413948  | Egypt
  2 | Fran Wilson   | franwilson@mail.com   | (204) 619-5731 | C/ Araquil, 67, Madrid, Spain
  3 | Maria Anders  | mariaanders@mail.com  | (503) 555-9931 | 25, rue Lauriston, Paris, France
  4 | Thomas Hardy  | thomashardy@mail.com  | (171) 555-2222 | 89 Chiaroscuro Rd, Portland, USA
  5 | Ahmed Omar    | amhedoomar@gmail.com  | 0096650413948  | KSA
  6 | Idam Wilson   | idamwilson@mail.com   | (204) 619-5331 | C/ Araquil, 67, Madrid, Spain
  7 | Peter Perrier | peterperrier@mail.com | (313) 555-5735 | Obere Str. 57, Berlin, Germany
  8 | Mark Hardy    | markshardy@mail.com   | (171) 555-2222 | 89 Chiaroscuro Rd, Portland, USA
(8 rows)

devavance_db=# \quit
key_6@einfolearning:~/Bureau$ 

```


**Evaluation 5**

Vous devrez consigner votre réponse dans la zone **rendu n°5: connection à la base de données et requêtes** sur la plateforme  [einfo-learning.fr](http://enfin-learning.fr)



6. Utiliser l'application DBViewer pour vous connecter à la base de données et exécuter des requêtes sur celle-ci.


7. Dessiner l'infrastrcuture de votre application


**Evaluation 6**

Vous devrez consigner votre réponse dans la zone **rendu n°6: infrastructure** sur la plateforme  [einfo-learning.fr](http://enfin-learning.fr)

**Important :** Vous devrez déponser une capture du dessin de l'infrastructure au format jpg.

