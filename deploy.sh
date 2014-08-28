#!/bin/sh

if [[ ! -d src/main/webapp ]]; then
    echo "src/main/webapp not found, exit."
    exit 0
fi

APPNAME=yingze

test -z "$CATALINA_HOME" && echo "CATALINA_HOME not set." && exit 1
test -z "$APPNAME" && echo "APPNAME not set." && exit 2

rm -r -f $CATALINA_HOME/webapps/$APPNAME

cp -r src/main/webapp $CATALINA_HOME/webapps/$APPNAME
cp -r target/classes $CATALINA_HOME/webapps/$APPNAME/WEB-INF/

cp -r lib $CATALINA_HOME/webapps/$APPNAME/WEB-INF/
[[ -d lib-runtime ]] && cp lib-runtime/* $CATALINA_HOME/webapps/$APPNAME/WEB-INF/lib/
rm $CATALINA_HOME/webapps/$APPNAME/WEB-INF/lib/servlet-api.jar

echo "Deploy done."
