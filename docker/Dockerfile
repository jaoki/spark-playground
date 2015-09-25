FROM centos:centos7

ENV JAVA_HOME /jdk1.8.0_51


RUN yum install -y wget which tar git

RUN wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u51-b16/jdk-8u51-linux-x64.tar.gz"

RUN tar xf jdk-8u51-linux-x64.tar.gz
RUN rm jdk-8u51-linux-x64.tar.gz

ENV PATH $PATH:$JAVA_HOME/bin

