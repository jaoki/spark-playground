package wordcount1

import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.MappedRDD

object Main{
  def main(args: Array[String]) : Unit = {
    val SPARK_HOME = sys.env("SPARK_HOME")
    val sc = new SparkContext("local", "WordCount1", SPARK_HOME)


    val readmeMdRdd = sc.textFile(SPARK_HOME + "/README.md")
    println("count: " + readmeMdRdd.count())
    println("first: " + readmeMdRdd.first())
    val wordcount = new WordCount1(readmeMdRdd)
    wordcount.filterTest()
    wordcount.mapTest()



  }
}

class WordCount1(data: RDD[String]) extends Serializable{

	def filterTest() : Unit = {
		println("====================")
		data.filter(line => line.toLowerCase().contains("spark")).take(3).foreach(println)
		println("====================")
	}

	def max(a:Int, b:Int) : Int = {
		if (a > b){
			a
		}else{
			b
		}
	}

	def mapTest() : Unit = {
		println("====================")
		println(data.map(line => line.split(" ").size).reduce(max))
		println("====================")

	}



//	def properlySplit(line: String) : Array[String] = {
//		var delimiters:Array[String] = Array(" ", "\"", ".", ",", "\\[", "]", "\\(", ")", "=", "-", "<", ">", "#", ":", "`")
//		for(d <- delimiters){
//			if(line.contains(d)){
//				return line.split(d).flatMap(properlySplit)
//			}
//		}
//		Array(line)
//	}
//
//	def wordCount() : RDD[(String, Int)] = {
//		// var allWords = readmeMdFile.flatMap(line => line.split(" ")).map(a => a.st)
//		var allWords = readmeMdFile.flatMap(properlySplit)
//		var wordPairs = allWords.map(word => (word.toLowerCase(), 1))
//		var countsUnsorted = wordPairs.reduceByKey((a:Int, b:Int) => a+b)
//		// countsUnsorted.sortByKey(false)
//		countsUnsorted.sortBy(_._1)
//	}
}
//
//
//// filterTest()
//// mapTest()
//// max(1, 2)
//println("word count result ==================")
//var wordCounts:RDD[(String, Int)] = new Test().wordCount()
//wordCounts.foreach(println)
//wordCounts.count()

