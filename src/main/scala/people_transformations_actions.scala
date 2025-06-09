//Transformations and Actions


//RDD:

import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder()
  .appName("RDD Example")
  .master("local[*]")
  .getOrCreate()

val sc = spark.sparkContext  // Get SparkContext

// Load CSV file as RDD
val rdd = sc.textFile("/people.csv")

// Remove header and split data
val header = rdd.first()
val dataRDD = rdd.filter(_ != header).map(line => {
  val cols = line.split(",")
  (cols(0), cols(1).toInt) // (Name, Age)
})

// Transformation: Filter people above 18
val adultsRDD = dataRDD.filter { case (_, age) => age > 18 }

// Transformation: Map to uppercase names
val upperRDD = adultsRDD.map { case (name, age) => (name.toUpperCase, age) }

// Action: Collect & Print
upperRDD.collect().foreach(println)


//DataFrame:


import org.apache.spark.sql.functions._

val df = spark.read.option("header", "true").csv("/people.csv")

// Transformation: Convert age to Integer
val dfTyped = df.withColumn("Age", col("Age").cast("int"))

// Transformation: Filter people older than 18
val dfAdults = dfTyped.filter(col("Age") > 18)

// Transformation: Uppercase names
val dfUpper = dfAdults.withColumn("Name", upper(col("Name")))

// Action: Show results
dfUpper.show()


//Dataset:

----*----

import org.apache.spark.sql.{SparkSession, Dataset, Encoders}
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._

// Define the case class for Dataset
case class Person(Name: String, Age: Int)

// Initialize SparkSession
val spark = SparkSession.builder()
  .appName("Dataset Example")
  .master("local[*]")
  .getOrCreate()

import spark.implicits._  // Important for implicit Encoders

// Load CSV into DataFrame
val df = spark.read
  .option("header", "true")  // Ensure the first row is a header
  .option("inferSchema", "true")  // Automatically infer data types
  .csv("/people.csv")

// Check DataFrame Schema
df.printSchema()

// Display DataFrame
df.show()

// Convert DataFrame to Dataset
val ds: Dataset[Person] = df.as[Person]  // Strongly typed Dataset

// Show Dataset
ds.show()

// Transformation: Filter people older than 18
val adultsDS = ds.filter(_.Age > 18)

// Display Filtered Dataset
adultsDS.show()
