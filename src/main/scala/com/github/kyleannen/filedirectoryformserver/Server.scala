package com.github.kyleannen.filedirectoryformserver

import org.clojars.kyleannen.javaserver.{ConfigureServer, ControllerForm, Router}

import scala.util.Properties

object Server {
  def start(): Unit = {
    val router = new Router()
    router.addRoute("GET", "/form", new ControllerForm)
    val port: String = Properties.envOrElse("PORT", "3434")
    val args: Array[String] = Array("-p", port)
    val server = new ConfigureServer().configure(args, router)
    server.run()
  }

  def main(args: Array[String]): Unit = {
    start()
  }
}
