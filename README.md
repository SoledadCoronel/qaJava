# Carpetas

* FunctionalTests: Tiene los tests de behat nuevos y los importados desde plataforma y ademas los tests de Java+Selenium nuevos creados por Sole y Marina y a la vez hay tests viejos creados por otros automations 
* IntegrationTests: Tiene todos los tests de integración (Jmeter) de Rewards, Usuarios, Beneficios y Reconocimientos
* LegacyTests: Tiene los tests funcionales creados en su momento por Diogo que no se están usando por el momento. VER QUE HACER CON ESTOS TESTS!
* SQLData: Contiene los dumps de bases de datos utilizados como datos base para QA


# Behat (Dependencias para correr tests de behat
 

Actualizar los repositorios de Ubuntu
-------------------------------------
sudo apt-get update
sudo apt-get upgrade


Configurando permisos para apt get
----------------------------------
sudo apt-get install -y acl curl


Instalar Java
-------------
printf "\n" | sudo add-apt-repository ppa:webupd8team/java
sudo apt-get -y update
echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
sudo apt-get install -y  oracle-java7-installer
sudo update-java-alternatives -s java-7-oracle


Instalar PHP
------------
sudo apt-get install -y php5 php5-mysql php5-dev php-pear php5-curl php-apc php5-intl php5-xsl php5-gd php5-mcrypt php5-gmp php5-memcached php5-sqlite


Instalar Composer
-----------------
curl -sS https://getcomposer.org/installer | php
sudo mv composer.phar /usr/bin/composer


