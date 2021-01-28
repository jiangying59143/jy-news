@echo off
@title 1.build

@Echo -----------------------------------------------------------
@Echo Build start
@Echo -----------------------------------------------------------

call mvn -T 1C clean install -Dmaven.test.skip=true

pause
