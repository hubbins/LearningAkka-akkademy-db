package com.akkademy

import akka.actor.Actor
import akka.event.Logging
import com.akkademy.messages.SetText

class TextDemo extends Actor {
  val log = Logging(context.system, this)
  var textValue = ""

  override def receive = {
    case SetText(text) => {
      log.info("received SetText - text: {}", text)
      textValue = text
    }
    case o => log.info("received unknown message: {}", o)
  }
}
