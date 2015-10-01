
var data1 = sc.textFile("join_example/data1.tsv").map(_.split("\t"))
var data2 = sc.textFile("join_example/data2.tsv").map(_.split("\t"))

case class Data1(date: String, uid: String, count: Int)
case class Data2(date: String, uid: String, count: Int, a: Float, b:Float)

var data11 = data1.map(l => (l(1), Data1(l(0), l(1), l(2).toInt)))
// var data11 = data1.map((_(1), Data1(_(0), _(1), _(2).toInt)))
//var data11 = data1.map(println(_))

var data21 = data2.map(l => (l(1), Data2(l(0), l(1), l(2).toInt, l(3).toFloat, l(4).toFloat)))

var joinedData = data11.join(data21)
joinedData.foreach(r => println(r._1 + ":" + r._2._1.count + ":" + r._2._2.count))

