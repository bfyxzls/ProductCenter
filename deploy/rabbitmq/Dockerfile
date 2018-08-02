FROM rabbitmq:3.6.10-management-alpine

ENV TZ=Asia/Shanghai
RUN echo "http://mirrors.aliyun.com/alpine/v3.5/main" >/etc/apk/repositories \ 
    && echo "http://mirrors.aliyun.com/alpine/v3.5/community" >>/etc/apk/repositories \
    && apk add --no-cache --update su-exec \
    && rm -rf /var/cache/apk/* \
    && ln -snf /usr/share/zoneinfo/$TZ /etc/localtime \
    && echo $TZ > /etc/timezone
	
RUN rabbitmq-plugins enable --offline rabbitmq_shovel rabbitmq_shovel_management rabbitmq_web_stomp 
