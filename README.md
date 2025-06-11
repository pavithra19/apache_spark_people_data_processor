# Apache Spark People and Customer Processor Project

This project is a data processing application built with Apache Spark and Scala. This project is designed to efficiently process, analyze, and transform large datasets related to people data. It leverages Spark’s distributed computing capabilities to handle CSV, JSON, other structured data formats for scalable data ingestion, cleaning, and reporting. The codebase is modular, making it easy to extend for custom data pipelines or integrate with additional data sources. Shell scripts are included for streamlined deployment and execution.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Sample Data](#sample-data)

## Overview

- Fast and scalable data processing using Apache Spark
- Written primarily in Scala for performance and maintainability
- Modular pipeline for data ingestion, transformation, and export
- Shell scripts for automation and ease of use
- Suitable for batch processing of large people-related datasets


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
   git clone https://github.com/pavithra19/apache_spark_people_data_processor.git
   cd apache_spark_people_data_processor
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
