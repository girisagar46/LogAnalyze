#!/bin/bash
#hadoop fs -mkdir -p input
#hadoop fs -put /home/iam/IdeaProjects/WordLineCatcher/data/wordLineList.csv input/
hadoop jar /home/iam/IdeaProjects/WordLineCatcher//target/org.project.wordlinecatcher-1.0-SNAPSHOT.jar com.project.wordlinecatcher.StartDriver "sachin"
