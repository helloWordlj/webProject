#!/bin/sh
provider_classpath=$CLASSPATH:.;
lib_jars=/usr/local/Collect/provider_v1/lib/*.jar;
project_path=
for i  in $lib_jars
do
   CLASSPATH=$CLASSPATH:$i
done
   CLASSPATH=$CLASSPATH:$provider_classpath:/usr/local/Collect/provider_v1/yxw_interfaces.jar;
export CLASSPATH
export JAVA_HOME=/usr/java/jdk1.7.0_71
cd /usr/local/Collect/provider_v1
nohup  $JAVA_HOME/bin/java -server -Xmx2048M -Xms2048M -XX:PermSize=512M -XX:MaxPermSize=512M -Xss5M com.yxw.interfaces.service.ProgramStartUp &
