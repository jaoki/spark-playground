val lines = scala.io.Source.fromFile("line_number/data.txt").getLines
// lines.foreach(println)
var count = 0
var lines2 = lines.map(line => {count = count+1; count + ": " + line;}).foreach(println)
lines2.foreach(println)

