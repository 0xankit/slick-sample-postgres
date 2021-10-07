package actors

import akka.actor.{Actor, ActorSystem, Props}
import controllers.CreatePersonForm


object ActorCaps  extends  App {
  class SimpleActor extends  Actor {
    def receive: Receive = {
      case message: String =>
        println(s"I have recieved a message $message")
      case SpecialMessage(contents) =>
        println(s"I have a special message $contents")
    }
  }

  val system = ActorSystem("ActorCapsDemo")
  val actorCapsA = system.actorOf(Props[SimpleActor](), "actorCapsA")

  actorCapsA ! "I kicked it"

  case class SpecialMessage(contents: String)
  actorCapsA ! SpecialMessage("Special Content")

  actorCapsA ! "allPersons"
}
