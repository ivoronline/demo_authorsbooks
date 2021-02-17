# KILL APPLICATION
pgrep -f 'demo_authorsbooks-0.0.1-SNAPSHOT.jar' | xargs kill

# REMOVE JAR
rm /home/igoreta/applications/TestJenkins/demo_authorsbooks-0.0.1-SNAPSHOT.jar

# COPY JAR
cp /var/lib/jenkins/.m2/repository/com/ivoronline/demo_authorsbooks/0.0.1-SNAPSHOT/demo_authorsbooks-0.0.1-SNAPSHOT.jar /home/igoreta/applications/AuthorsBooks
