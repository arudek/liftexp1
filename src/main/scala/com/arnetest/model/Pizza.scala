package com.arnetest {
  package model {

    import _root_.net.liftweb.mapper._
    import _root_.net.liftweb.util._
    import _root_.net.liftweb.common._

/**
* The singleton that has methods for accessing the database
*/
object Pizza extends Pizza with LongKeyedMetaMapper[Pizza] with CRUDify[Long,Pizza] {
  override def dbTableName = "pizza" // define the DB table name
  override def fieldOrder = List(id, size)
  override def showAllMenuName = "Pizzas"
  override def createMenuName = "Neue Pizza"
}

class Pizza extends LongKeyedMapper[Pizza] with IdPK {
  def getSingleton = Pizza

  object size extends MappedInt (this)
  object weight extends MappedInt (this)
}

}
}
