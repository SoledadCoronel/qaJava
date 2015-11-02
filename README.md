Actualizar los repositorios de Ubuntu
-------------------------------------
sudo apt-get update
sudo apt-get upgrade


Configurando permisos para apt get
----------------------------------
sudo apt-get install -y acl curl


Java
----
printf "\n" | sudo add-apt-repository ppa:webupd8team/java
sudo apt-get -y update
echo oracle-java7-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
sudo apt-get install -y  oracle-java7-installer
sudo update-java-alternatives -s java-7-oracle


Instalar PHP
------------
sudo apt-get install -y php5 php5-mysql php5-dev php-pear php5-curl php-apc php5-intl php5-xsl php5-gd php5-mcrypt php5-gmp php5-memcached php5-sqlite


Composer
--------
curl -sS https://getcomposer.org/installer | php
sudo mv composer.phar /usr/bin/composer


