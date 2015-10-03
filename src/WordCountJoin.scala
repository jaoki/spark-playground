

object WordCountJoin {
  var data1 = sc.textFile("join_example/data1.tsv").map(_.split("\t"))
}