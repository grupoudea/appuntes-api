@echo off
echo Starting...

REM Definimos variables
set IMAGE_NAME=appuntes-i
set CONTAINER_NAME=%IMAGE_NAME%-con

echo %IMAGE_NAME%
echo %CONTAINER_NAME%

echo Stoping container %CONTAINER_NAME%
docker stop %CONTAINER_NAME% 2>&1 | findstr /C:"No such"
if %errorlevel%==0 (
  echo Error trying stop container %CONTAINER_NAME% maybe container does not exist
) else (
  echo %CONTAINER_NAME% has been stopped. Good job!
)

echo Removing container %CONTAINER_NAME%
docker rm %CONTAINER_NAME% 2>&1 | findstr /C:"No such"
if %errorlevel%==0 (
  echo Error trying remove container %CONTAINER_NAME% maybe container does not exist
) else (
  echo %CONTAINER_NAME% has been removed. Good job!
)

echo Removing image %IMAGE_NAME%
docker rmi %IMAGE_NAME% 2>&1 | findstr /C:"No such"
if %errorlevel%==0 (
  echo Error trying remove image %IMAGE_NAME% maybe image does not exist
) else (
  echo %IMAGE_NAME% has been removed. Good job!
)

echo pass %PASS_DB%

call gradlew clean build -x test

docker build --tag %IMAGE_NAME% --build-arg PASS_DB=%PASS_DB% --build-arg USER_DB=%USER_DB% .
