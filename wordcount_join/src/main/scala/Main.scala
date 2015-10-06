import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object Main {
  def main(args: Array[String]) : Unit = {
    val conf = new SparkConf().setAppName("wordcount_join").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val SPARK_HOME = sys.env("SPARK_HOME")
    println("SPARK_HOME: " + SPARK_HOME)
    val changeRdd = sc.textFile(s"${SPARK_HOME}/CHANGES.txt")
    val readmeeRdd = sc.textFile(s"${SPARK_HOME}/README.md")
    val a = wordcount(changeRdd)
    val b = wordcount(readmeeRdd)
    val result = a.join(b)
    result.take(30).foreach(println)

  }
  
  def wordcount(rdd : RDD[String]) : RDD[(String, Int)] = {
    rdd.flatMap( _.split(" ") )
        .filter( _.contains("Spark") )
        .map( (_, 1) )
        .reduceByKey( _+_)
  }
}