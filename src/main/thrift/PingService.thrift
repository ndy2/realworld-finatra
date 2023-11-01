namespace java hello.realworld
#@namespace scala hello.realworld

service PingService {

  /**
   * Respond with 'pong'
   */
  string ping()

  string echo(
    1: string a
  )
}
