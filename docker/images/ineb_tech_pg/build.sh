#!/bin/sh

set -ex

REGISTRY=registry.ineb.tech:81

VERSION=0.0.1

DOCKER_IMAGE=$REGISTRY/tech/pg-ineb-dbg:$VERSION

docker build . -t $DOCKER_IMAGE