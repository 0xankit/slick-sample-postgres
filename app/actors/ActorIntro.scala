package actors

import akka.actor.{Actor, ActorSystem, Props}

object ActorsIntro extends App {
  val actorSystem = ActorSystem("firstActorSystem")
  println(actorSystem.name)

  class WordCountActor extends Actor {
    var totalWords = 0
      def receive : Receive = {
        case message: String =>
          println(s"message $message")
          totalWords += message.split(" ").length
        case msg => println("UnknownMessage")
      }
  }

  val wordCounter = actorSystem.actorOf(Props[WordCountActor](), "wordCounter")

  wordCounter ! "Loving it"

  object Person {
    def props(name: String) = Props(new Person(name))
  }

  class Person(name : String) extends Actor {
    def receive: Receive = {
      case "hi" => println(s"Name is $name")
    }
  }

  val personA = actorSystem.actorOf(Props(new Person("Bob")))
  val personB = actorSystem.actorOf(Person.props("rob"))

  personA ! "hi"
  personB ! "hi"
}
