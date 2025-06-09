//Double RDD:

import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder()
  .appName("DoubleRDD Example with Rounding")
  .master("local[*]")
  .getOrCreate()

val sc = spark.sparkContext  // Getting SparkContext

// Creating a DoubleRDD
val numbersRDD = sc.parallelize(Seq(10.5, 20.3, 30.7, 40.2, 50.9))

// Performing calculations with rounding
val sum = numbersRDD.sum()
val mean = numbersRDD.mean()
val variance = numbersRDD.variance()
val stdev = numbersRDD.stdev()

// Using BigDecimal to round to 2 decimal places
def round(value: Double, places: Int = 2): Double = BigDecimal(value).setScale(places, BigDecimal.RoundingMode.HALF_UP).toDouble

println(s"Sum: ${round(sum)}")
println(s"Mean: ${round(mean)}")
println(s"Variance: ${round(variance)}")
println(s"Standard Deviation: ${round(stdev)}")
