#!/bin/bash

# Previewing first 10 lines of customers.csv for verification
head -n 10 customers.csv

# Creating HDFS output directory
hdfs dfs -mkdir -p /etl/outputs/subscriptions_2021

# Uploading local CSV file to HDFS
hdfs dfs -put /Big_Data/output/subscriptions_2021/part-00000*.csv /etl/outputs/subscriptions_2021/

# Previewing uploads in hdfs
hdfs dfs -tail /etl/outputs/subscriptions_2021/
