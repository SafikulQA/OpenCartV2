#!/bin/bash

echo "Running Maven Tests..."
cd "$(dirname "$0")"
mvn clean test

read -n 1 -s -r -p "Press any key to close..."
