//Creations:

//Create DataFrame:

{
  import org.apache.spark.sql.SparkSession

  val spark = SparkSession.builder
    .appName("Create DataFrame")
    .master("local")
    .getOrCreate()

  // Load the CSV file as a DataFrame
  val df = spark.read
    .option("header", "true") // First row as header
    .option("inferSchema", "true") // Automatically infer data types
    .csv("/people.csv")

  // Show the DataFrame
  df.show()

  // Print schema of the DataFrame
  df.printSchema()
}

//Create Dataset:

// Case class should be defined outside the block
case class Person(Name: String, Age: Int)

{
  import org.apache.spark.sql.SparkSession

  // Initialize SparkSession
  val spark = SparkSession.builder
    .appName("Create Dataset")
    .master("local")
    .getOrCreate()

  // Import Spark implicits
  import spark.implicits._

  // Load the CSV file as a DataFrame
  val df = spark.read
    .option("header", "true") // Use the first row as the header
    .option("inferSchema", "true") // Automatically infer data types
    .csv("/people.csv")

  // Convert DataFrame to Dataset
  val ds = df.as[Person]

  // Show the Dataset
  ds.show()

  // Print the schema of the Dataset
  ds.printSchema()
}
  //Create RDD:

{
  import org.apache.spark.sql.SparkSession

  val spark = SparkSession.builder
    .appName("Create RDD")
    .master("local")
    .getOrCreate()

  val sc = spark.sparkContext

  // Load the CSV file as an RDD
  val rdd = sc.textFile("/people.csv")

  // Extract header and split rows into a structured RDD
  val header = rdd.first()
  val dataRDD = rdd.filter(_ != header).map(line => {
    val cols = line.split(",")
    (cols(0), cols(1).toInt) // Map to (Name, Age)
  })

  // Print the RDD
  dataRDD.collect().foreach(println)
}
