export TOM=$AS/tomcat/apachetomcat7069

mvn clean install -U

rm -rf $TOM/webapps/books*

mv target/*.war $TOM/webapps

sh $TOM/bin/catalina.sh run
