import org.apache.spark.rdd.RDD

var sparkHome = sys.env("SPARK_HOME")
var readmeMdFile = sc.textFile(sparkHome + "/README.md")
readmeMdFile.count()
readmeMdFile.first()

@SerialVersionUID(15L)
class Test extends Serializable{
  
	def filterTest() : Unit = {
		println("====================")
		readmeMdFile.filter(line => line.toLowerCase().contains("spark")).foreach(println)
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
		println(readmeMdFile.map(line => line.split(" ").size).reduce(max))
		println("====================")

	}
	


	def properlySplit(line: String) : Array[String] = {
		var delimiters:Array[String] = Array(" ", "\"", ".", ",", "\\[", "]", "\\(", ")", "=", "-", "<", ">", "#", ":", "`")
		for(d <- delimiters){
			if(line.contains(d)){
				return line.split(d).flatMap(properlySplit)
			}
		}
		Array(line)
	}

	def wordCount() : RDD[(String, Int)] = {
		// var allWords = readmeMdFile.flatMap(line => line.split(" ")).map(a => a.st)
		var allWords = readmeMdFile.flatMap(properlySplit)
		var wordPairs = allWords.map(word => (word.toLowerCase(), 1))
		var countsUnsorted = wordPairs.reduceByKey((a:Int, b:Int) => a+b)
		// countsUnsorted.sortByKey(false)
		countsUnsorted.sortBy(_._1)
	}
}


// filterTest()
// mapTest()
// max(1, 2)
println("word count result ==================")
var wordCounts:RDD[(String, Int)] = new Test().wordCount()
wordCounts.foreach(println)
wordCounts.count()

