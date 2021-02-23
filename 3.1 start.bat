@echo off
@title 3.1 start

cd docker\dev
call docker-compose up -d eureka gateway sms es01 es02 es03

pause
