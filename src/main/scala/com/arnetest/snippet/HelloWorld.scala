package com.arnetest {
package snippet {

import _root_.scala.xml.{NodeSeq, Text}
import _root_.net.liftweb.util._
import _root_.net.liftweb.common._
import _root_.java.util.Date
import com.arnetest.lib._
import com.arnetest.model._
import Helpers._

class HelloWorld {
  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date

  // bind the date into the element with id "time"
  //def howdy = "#time *" #> date.map(_.toString)
//  def howdy = "#time *" #> "Juhuuu! :-) jetzt mit rebel?"

  def howdy = "#time *" #> Pizza.findAll().toString

  def myform = "*" #> Pizza.toForm(Full("Save"), { _.save })

  // var p = Pizza.create.size(100).weight(50)
  // //p.size=100
  // p.save()
  /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy = "#time *" #> date.toString
   */
}

}
}
