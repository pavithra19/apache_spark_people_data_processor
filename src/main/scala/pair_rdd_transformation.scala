//Pair RDD:

//Creation:

import org.apache.spark.sql.SparkSession

// Initialize SparkSession
val spark = SparkSession.builder()
  .appName("PairRDD Example")
  .master("local[*]")  // Runs locally with all CPU cores
  .getOrCreate()

// Get SparkContext
val sc = spark.sparkContext

// Creating a Pair RDD (Key-Value Pairs)
val pairRDD = sc.parallelize(Seq(
  ("apple", 3),
  ("banana", 2),
  ("orange", 5),
  ("apple", 1),
  ("banana", 4)
))

val fruitCounts = pairRDD.reduceByKey(_ + _)

// Collect and Print
fruitCounts.collect().foreach(println)

// Stop Spark after computations (to free resources)
spark.stop()


//Transformation and Aggregations:

import org.apache.spark.sql.SparkSession

// Initialize Spark
val spark = SparkSession.builder().appName("PairRDD Example").master("local[*]").getOrCreate()
val sc = spark.sparkContext

// Creating first Pair RDD (product -> price)
val productPrices = sc.parallelize(Seq(
  ("Laptop", 10),
  ("Phone", 20),
  ("Tablet", 30),
  ("Headphones", 40)
))

// Creating second Pair RDD (product -> units sold)
val productSales = sc.parallelize(Seq(
  ("Laptop", 1),
  ("Phone", 2),
  ("Tablet", 3),
  ("Headphones", 4),
  ("Phone", 5)
))

// Transformation: Joining both RDDs on product name
val joinedRDD = productPrices.join(productSales) 

// Aggregation: Calculating total revenue per product
val revenueRDD = joinedRDD.mapValues { case (price, quantity) => price * quantity }
                          .reduceByKey(_ + _) 

// Collect and Print Results
println("Joined RDD:")
joinedRDD.collect().foreach(println)

println("\nTotal Revenue per Product:")
revenueRDD.collect().foreach(println)

// Stop Spark
spark.stop()
