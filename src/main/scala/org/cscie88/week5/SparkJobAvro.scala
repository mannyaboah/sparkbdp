package org.cscie88.week5

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession
import org.cscie88.config.ConfigUtils
import org.cscie88.utils.SparkUtils
import pureconfig.generic.auto._

case class SparkRDDConfig(
    name: String,
    masterUrl: String,
    inputPath: String
)

object SparkJobAvro {

  val SPARK_RDD_CONF_PATH = "org.cscie88.spark-rdd-application"

  def main(args: Array[String]): Unit = {
    implicit val conf: SparkRDDConfig = readConfig()

    val spark = SparkUtils.sparkSession(conf.name, conf.masterUrl)

    val schemaDS = loadData(spark)

    schemaDS.saveAsTextFile("results")

  }

  def readConfig(): SparkRDDConfig =
    ConfigUtils.loadAppConfig[SparkRDDConfig](SPARK_RDD_CONF_PATH)

//   def loadData(spark: SparkSession)(implicit
//       conf: SparkRDDConfig
//   ): RDD[Row] = spark.read.format("avro").load(conf.inputPath).rdd
  def loadData(
      spark: SparkSession
  )(implicit
      conf: SparkRDDConfig
  ): RDD[String] = spark.sparkContext.textFile(conf.inputPath)
}
