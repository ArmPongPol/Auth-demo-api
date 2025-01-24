FROM ubuntu:latest
LABEL authors="armpongpol"

ENTRYPOINT ["top", "-b"]