// Persistence:

// With and Without Persistence

import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel

// Initialize SparkSession
val spark = SparkSession.builder()
  .appName("RDD Persistence Example")
  .master("local[*]")
  .getOrCreate()

val sc = spark.sparkContext  // Get SparkContext

val rdd = sc.textFile("/Users/pavithrapurushothaman/Documents/bigdata/people.csv") // Load Data into RDD

val header = rdd.first()
val dataRDD = rdd.filter(row => row != header) // Remove Header

val peopleRDD = dataRDD.map(line => {
  val cols = line.split(",")
  (cols(0), cols(1).trim.toInt)
}) // Convert to Key-Value Pairs

peopleRDD.persist(StorageLevel.MEMORY_ONLY) // Persist the RDD

val startTime1 = System.currentTimeMillis() // Measure execution time for first run

val adultsRDD = peopleRDD.filter { case (_, age) => age > 18 } // Transformation: Filter Adults (Age > 18)

val result1 = adultsRDD.collect() // Action: Collect and Print
result1.foreach(println)

val endTime1 = System.currentTimeMillis()
println(s"Execution Time WITHOUT Persistence (First Run): ${endTime1 - startTime1} ms")

val startTime2 = System.currentTimeMillis() // Measure execution time for second run (cached data)

val result2 = adultsRDD.collect()  // Using persisted data
result2.foreach(println)

val endTime2 = System.currentTimeMillis()
println(s"Execution Time WITH Persistence (Second Run): ${endTime2 - startTime2} ms")

peopleRDD.unpersist() // Unpersist when no longer needed
