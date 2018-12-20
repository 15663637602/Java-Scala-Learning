package ssnowflakee

import java.net.URI

/**
  * define TODO
  *
  * @author yuqili
  *         Date 03/12/18  15:18
  * @version 1.0
  **/
object Test extends {
  val str = "snowflake://us%40er:passwo%3Ard@fw41796.eu-central-1.snowflakecomputing.com/database?param=value&preactions=USE%20DATABASE%20yqtest%3B"
  val str2 = "snowflake://wasd@swordurl/database?param=value&preactions=USE%20DATABASE%20yqtest%3B"
  val uri = new URI(str)
  val authority: String = uri.getAuthority
  val userInfo = uri.getUserInfo

  def main(args: Array[String]): Unit = {
    println(authority)
  }
}
