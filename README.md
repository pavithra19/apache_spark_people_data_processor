# Apache Spark People and Customer Processor Project

This project demonstrates the use of Structured APIs in Apache Spark, with a primary focus on Scala. It provides practical examples and code for processing, analyzing, and transforming people-related datasets using Spark’s RDD, DataFrame and Dataset APIs.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Sample Data](#sample-data)

## Overview

The goal of this project is to help users learn and implement Apache Spark’s Structured APIs for handling structured data. The code is written in Scala and demonstrates best practices for building scalable data pipelines.

## Features

- Data ingestion from CSV and other sources
- Data cleaning and transformation using DataFrame, RDD and Dataset APIs
- Example queries and aggregations
- Shell scripts for running Hadoop jobs
- Modular Scala code for reusability

## Project Structure

```
.
├── src/
│   └── main/
│       └── scala/
│           └── [Scala source files]
├── data/
│   └── people.csv
├── scripts/
│   └── [Shell scripts for running jobs]
├── README.md
```

- **src/main/scala/**: Scala source code using Spark Structured APIs
- **data/**: Example datasets (e.g., people.csv, customers.csv)
- **scripts/**: Shell scripts to run Hadoop jobs

## Prerequisites

- Java 8 or above
- Scala 2.12.x or 2.13.x
- Apache Spark 3.x

## Getting Started

**Clone the repository:**
   ```bash
   git clone https://github.com/pavithra19/apache_spark_people_processor_project.git
   cd apache_spark_people_processor_project
   ```

## Usage

- Modify or replace `/people.csv` with your own data.
- Adjust the code in `src/main/scala/` as needed for your use case.
- Use the provided shell scripts in `scripts/` to automate job execution in hadoop.

## Sample Data

The default `data/people.csv` should be in the following format:

```csv
name,age
Alice,19
Bob,20
Charlie,39
```
