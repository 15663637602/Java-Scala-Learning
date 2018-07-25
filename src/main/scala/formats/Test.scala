package formats

object Test {
  def main(args: Array[String]): Unit = {
    val sql = """(SELECT max(id_sch)
            FROM data_unit d
            INNER JOIN map m ON m.id_du=d.id_du
            INNER JOIN rtab t ON t.id_rtab=m.id_rtab
            WHERE t.id_lschma=l.id_lschma)"""

    println("""SELECT
          l.id_org
          ,l.id_lschma
          ,%s as id_sch
          ,l.lsch_name AS schema_name
          ,coalesce(p.jdbc_url, p.default_out_path) AS outputpath
          ,p.login AS ouser
          ,p.pwd AS opassword
          ,l.format
          ,l.compression
          ,l.savemode_cd AS savemode
        FROM lschma l
        LEFT OUTER JOIN pschma p ON p.id_lschma=l.id_lschma
        WHERE l.id_lschma=?""".format(sql))
  }
}
