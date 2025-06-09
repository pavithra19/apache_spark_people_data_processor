import org.apache.spark.sql.SparkSession

// Create SparkSession
val spark = SparkSession.builder()
  .appName("EXPLAIN Query Lifecycle Example")
  .config("spark.ui.enabled", "true")
  .config("spark.ui.port", "4041")
  .getOrCreate()

// Sample DataFrame operation
val df = spark.read.option("header", "true").csv("/people.csv")

// Apply some transformations
val result = df.filter(df("age") > 18)
  .groupBy("Name")
  .count()

// Show the plan using EXPLAIN to understand the query lifecycle
println("Query Plan with EXPLAIN:")

// Unoptimized logical plan
result.explain(true)  // "true" gives detailed plan, including optimizations

// Show the result
result.show()
