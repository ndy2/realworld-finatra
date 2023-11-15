namespace java hello.realworld.port.in
#@namespace scala hello.realworld.port.in

service PingService {

  /**
   * Respond with 'pong'
   */
  string ping()

  string echo(
    1: string a
  )
}
