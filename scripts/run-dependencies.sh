#!/bin/bash

set -e

# cd to project root directory
cd "$(dirname "$(dirname "$0")")"

docker build --target base -t genomealmanac/chipseq-roundedmean-base .

docker run --name chipseq-roundedmean-base --rm -i -t -d \
    -v /tmp/chipseq-test:/tmp/chipseq-test \
    genomealmanac/chipseq-roundedmean-base /bin/sh