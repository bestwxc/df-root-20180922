#!/bin/bash
name=df-cloud-eureka-server
profile=native
vmargs="-Xmx512m -Xms128m"

SERVER_DIR=$(cd `dirname $0`;pwd)
JAR_PATH=`find $SERVER_DIR -name "$name*.jar"`

get_pid(){
    pid=`ps -ef|grep java|grep "$name"|awk '{print $2}'`
}
stop(){
    kill -9 $1
    sleep 1
    get_pid
    if [ -n "$pid" ]
    then
        echo "停止失败，请检查"
    else
        echo "停止成功"
    fi
}

start(){
    nohup java -jar $JAR_PATH --spring.profiles.active=$profile $vmargs &
    sleep 1
    get_pid
    if [ -n "$pid" ]
        then
            echo "启动成功，pid:$pid"
        else
            echo "启动失败"
        fi
}

print_usage(){
    echo "Usage: bash run.sh {start|stop|restart}"
}

doAlive(){
    case $1 in
        "restart")
            stop $pid
            start
            ;;
        "stop")
            stop $pid
            ;;
        "start")
            echo "当前存活，未执行操作"
            ;;
        *)
            print_usage
            ;;
    esac
}

doDead(){
    case $1 in
        "stop")
            echo "当前未存活，未执行操作"
            ;;
        "start")
            start
            ;;
        "restart")
            start
            ;;
        *)
            print_usage
            ;;
    esac
}

get_pid

if [ -n "$pid" ]
then
    echo "$application_name当前存活，pid:$pid"
    doAlive $1
else
    echo "$application_name当前未存活"
    doDead $1
fi