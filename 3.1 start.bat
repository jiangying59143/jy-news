@echo off
@title 3.1 start

cd docker\dev
call docker-compose up -d eureka gateway sms

pause
