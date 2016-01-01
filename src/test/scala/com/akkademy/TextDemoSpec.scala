package com.akkademy

import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}
import akka.actor.ActorSystem
import com.akkademy.messages.SetText
import akka.testkit.TestActorRef

class TextDemoSpec extends FunSpecLike with Matchers with BeforeAndAfterEach {
  implicit val system = ActorSystem()

  describe("TextDemo") {
    describe("given SetText") {
      it("should set the text value") {

        val actorRef = TestActorRef(new TextDemo)

        actorRef ! SetText("Test 1")

        val textDemo = actorRef.underlyingActor
        textDemo.textValue should equal("Test 1")
      }

      it("should set another text value") {

        val actorRef = TestActorRef(new TextDemo)

        actorRef ! SetText("Test 2")

        val textDemo = actorRef.underlyingActor
        textDemo.textValue should equal("Test 2")
      }
    }
  }
}
