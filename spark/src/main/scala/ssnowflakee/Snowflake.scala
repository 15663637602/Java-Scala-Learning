package ssnowflakee

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType
import net.snowflake.spark.snowflake.Utils.SNOWFLAKE_SOURCE_NAME
/**
  * define TODO
  *
  * @author yuqili
  *         Date 12/11/18  16:53
  * @version 1.0
  **/
object Snowflake {
  val spark = SparkSession.builder.master("local[*]").appName("Snowflake")
    .getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")

  val input = "/home/yuqili/data/mobile"
  val userSchema = new StructType().add("header", "string").add("num", "int").add("date", "string").add("time", "string").add("content", "string").add("bignum", "string")
  val tsvDF = spark.read.format("csv").option("sep", " ").schema(userSchema)
//    .option("maxFilesPerTrigger", 1)
//    .option("latestFirst", value = true)
    //.option("fileNameOnly", true)
    .load(input)





  val sfOptions = Map(
    "sfURL" -> "fw41796.eu-central-1.snowflakecomputing.com",
//    "sfAccount" -> "fw41796",
    "sfUser" -> "yuqi_li",
    "sfPassword" -> "18646086080Lyq",
    "sfDatabase" -> "yqtest2",
    "sfSchema" -> "public",
    "sfWarehouse" -> "etl"
//    "preactions" -> "USE DATABASE yqtest;"
  )
  val extra: Map[String, String] = Map()


  def main(args: Array[String]): Unit = {
    tsvDF.printSchema()
    tsvDF.write
      .format(SNOWFLAKE_SOURCE_NAME)
      .options(sfOptions)
      .options(extra)
      .option("dbtable", "test")
      .mode("overwrite")
      .saveAsTable("assd")
  }
}
