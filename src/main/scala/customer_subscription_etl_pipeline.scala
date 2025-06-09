import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder()
   .appName("ETL Pipleline - Subscription processing")
  .config("spark.ui.enabled", "true")
  .config("spark.ui.port", "4041")
  .getOrCreate()

// Extract
val data = spark.read
 .option("header", "true")
 .option("inferSchema", "true")
 .csv("/customers.csv")

// Transform
val filtered = data
 .select("Customer_Id", "First_Name", "Last_Name", "Subscription_Date")
 .filter($"Subscription_Date".startsWith("2021"))
 .withColumn("Subscription_Year", lit(2021))

// Load
filtered.write
 .option("header", "true")
 .mode("overwrite")
 .csv("/subscriptions_2021")
