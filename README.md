Application Java Poc pour Plateforme de déploiement continu
 - Méthode greeting
 - Méthode hello
 - Méthode kill
 - Méthode cpu

Test d'intégration continue et de déploiement continu
- branche dev pour intégration continue
  * git clone
  * build (mvn package sans test unitaire)
  * tests unitaires (mvn test)
  * test qualité du code (mvn sonar:sonar)
  * build image docker
  * release (docker push)
- branche master pour déploiement continu sur l'environnement de production
  * kubectl apply

Prérequis
 - Credential ID 'registry' pour réaliser le push sur la registry privée
 - Parametre/Variable environnement pour URL registry privée

