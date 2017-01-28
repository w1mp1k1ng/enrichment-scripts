<pre>
import org.apache.spark.SparkContext, org.apache.spark.SparkConf

object WordCount {
  def main(args: Array[String]) {
    val conf = new SparkConf().
      setAppName("Word Count").
      setMaster("local")
    val sc = new SparkContext(conf)
    val inputPath = args(0)
    val outputPath = args(1)
      
    val wc = sc.textFile(inputPath).
      flatMap(rec => rec.split(" ")).
      map(rec => (rec, 1)).
      reduceByKey((acc, value) => acc + value)
      
    wc.saveAsTextFile(outputPath)

  }
}
</pre>