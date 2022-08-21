#!/bin/sh

set -ex

USERNAME=$1
PASSWORD=$2

REGISTRY=registry.ineb.tech:81

VERSION=0.0.1

DOCKER_IMAGE=$REGISTRY/tech/pg-ineb-dbg:$VERSION

docker build . -t $DOCKER_IMAGE

docker login -u $USERNAME -p $PASSWORD http://${REGISTRY}

docker push $DOCKER_IMAGE