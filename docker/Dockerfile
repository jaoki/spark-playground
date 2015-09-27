FROM centos:centos7

ENV JAVA_HOME /jdk1.8.0_51
ENV SPARK_HOME /usr/local/lib/spark-1.4.1-bin-hadoop2.6


RUN yum install -y sudo wget which tar git vim

# java
RUN wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u51-b16/jdk-8u51-linux-x64.tar.gz" && \
  tar xf jdk-8u51-linux-x64.tar.gz && \
  rm jdk-8u51-linux-x64.tar.gz

ENV PATH $PATH:$JAVA_HOME/bin

# scala
RUN wget --no-cookies --no-check-certificate http://www.scala-lang.org/files/archive/scala-2.11.7.rpm && \
	yum install -y scala-2.11.7.rpm && \
	rm scala-2.11.7.rpm

# spark
RUN cd /usr/local/lib && wget --no-cookies --no-check-certificate http://d3kbcqa49mib13.cloudfront.net/spark-1.4.1-bin-hadoop2.6.tgz && \
	cd /usr/local/lib && tar -xvf spark-1.4.1-bin-hadoop2.6.tgz && \
	cd /usr/local/lib && rm spark-1.4.1-bin-hadoop2.6.tgz && \
	cp $SPARK_HOME/conf/log4j.properties.template $SPARK_HOME/conf/log4j.properties && \
	sed -i 's/log4j.rootCategory=INFO, console/log4j.rootCategory=WARN, console/' $SPARK_HOME/conf/log4j.properties

ENV PATH $PATH:$SPARK_HOME/bin


