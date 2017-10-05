package com.github.kyleannen.webtictactoe

import org.clojars.kyleannen.javaserver.{ConfigureServer, ControllerForm, Router}

import scala.util.Properties

object GameServer {
  def start(): Unit = {
    val router = new Router()
    router.addRoute("GET", "/form", new ControllerForm)
    val port: String = Properties.envOrElse("PORT", "3434")
    val args: Array[String] = Array("-p", port)
    val gameServer = new ConfigureServer().configure(args, router)
    println("Play TicTacToe at http://localhost:3000/")
    gameServer.run()
  }

  def main(args: Array[String]): Unit = {
    start()
  }
}
