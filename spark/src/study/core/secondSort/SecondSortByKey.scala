package study.core.secondSort

class SecondSortByKey(val first: Int, val second: Int) extends Ordered[SecondSortByKey] with Serializable {
  override def compare(that: SecondSortByKey): Int = {
    if (this.first - that.first != 0){
      this.first - that.first
    }else{
      this.second - that.second
    }
  }
}
