package com.arnetest.comet 

import net.liftweb.mapper._
import net.liftweb.common._
import net.liftweb.http._
import net.liftweb.http.SHtml
import net.liftweb.http.js.JE._
import net.liftweb.http.js.JsCmds._
import net.liftweb.http.js.jquery.JqJsCmds._
import net.liftweb.http.js.jquery.JqJsCmds.ModalDialog
import net.liftweb.util._
import net.liftweb.util.Helpers._
import scala.xml._
import java.util.Date
import java.text.SimpleDateFormat

class Clock extends CometActor {
  override def defaultPrefix = Full("clk")

  def render = bind("servertime" -> timeSpan)

  def timeSpan = (<span id="servertime">{timeNow}</span>)

  // schedule a ping every 1 seconds so we redraw
  ActorPing.schedule(this, Tick, 1000L)

  override def lowPriority : PartialFunction[Any, Unit] = { 
    case Tick => {
      println("Got tick " + new Date()); 
      partialUpdate(SetHtml("servertime", Text(timeNow.toString))) 
      // schedule an update in 1 seconds 
      ActorPing.schedule(this, Tick, 1000L)
    }
  } 
} 

case object Tick