#!/bin/sh

find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java esobchak.school21.Simulator md5scenario.txt