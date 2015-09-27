var sparkHome = sys.env("SPARK_HOME")
var readmeMdFile = sc.textFile(sparkHome + "/README.md")
readmeMdFile.count()
readmeMdFile.first()

def filterTest() : Unit = {
	println("====================")
	readmeMdFile.filter(line => line.toLowerCase().contains("spark")).foreach(println)
	println("====================")
	
}

filterTest()

