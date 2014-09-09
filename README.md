# User Database

## Logiciels nécessaires

* Eclipse Luna for Java EE developers https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/lunar
* Apache Tomcat 8.0.12 http://tomcat.apache.org/download-80.cgi
* Oracle JDK 8u20 http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
* Mysql Server 5.6.20 http://dev.mysql.com/downloads/mysql/
* Mysql Workbench 6.1.7 http://dev.mysql.com/downloads/workbench/

## Bibliothèques Java nécessaires

* mysql-connector-java 5.1.32 http://search.maven.org/remotecontent?filepath=mysql/mysql-connector-java/5.1.32/mysql-connector-java-5.1.32.jar
* jstl 1.2 http://search.maven.org/remotecontent?filepath=javax/servlet/jstl/1.2/jstl-1.2.jar
* jstl-api 1.2 http://search.maven.org/remotecontent?filepath=javax/servlet/jsp/jstl/javax.servlet.jsp.jstl-api/1.2.1/javax.servlet.jsp.jstl-api-1.2.1.jar
* Hibernate ORM 4.3.6.Final http://hibernate.org/orm/
* slf4j-api 1.7.7 http://search.maven.org/remotecontent?filepath=org/slf4j/slf4j-api/1.7.7/slf4j-api-1.7.7.jar

## Autres bibliothèques

* Bootstrap v3.2.0 https://github.com/twbs/bootstrap/releases/download/v3.2.0/bootstrap-3.2.0-dist.zip

## Liens utiles

* Sur Java EE http://resourcepool.io/2014/08/31/java-quickies-introducing-jee/
* Utilisation de la nouvelle API de date de java 8 avec Hibernate http://blog.progs.be/550/java-time-hibernate

## Etapes

1. Création des objets domaine
2. Création du DAO en faisant attention aux fermetures de connexions
3. Création du service, couche d'abstraction nécessaire
4. Création du controleur pour exposer notre application sur le web
5. Utilisation des JSP au lieu d'écrire le code html dans la servlet et rendre celles-ci inaccessibles
6. Utilisation des tags JSTL au lieu des scriptlets dans les fichiers .jsp
7. Ajout de bootstrap pour un meilleur look
8. Réécriture des DAOs, Services et controleurs pour les rendre singletons
9. Ajout de slf4j pour de meilleurs logs
10. Utilisation de Hibernate au lieu de mapper à la main les objets
11. Ajout d'une fonctionalité d'ajout d'un utilisateur