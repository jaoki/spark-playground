package test1

object Main{
  def main(args: Array[String]){
    new `List&Closures`().f_--()
  }
}



class `List&Closures` {
  
  def f_--(){
    println("go")
    val list = List(1, "two", Array(2.1d, 5.2d), Vector(1, 2, 3, 5, 8, 13, 21))
    val types = list.map{
      case _ : Int => "int"
      case _ : String => "string"
      case _ : Array[Double] => "double array"
      case c : AnyRef => c.getClass.getName()
      case _ => "something else"
      
    }
    
    println(types.mkString("|"))
    
  }
}