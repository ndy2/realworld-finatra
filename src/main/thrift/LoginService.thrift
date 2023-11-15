namespace java hello.realworld.port.in
#@namespace scala hello.realworld.port.in

include "types/User.thrift"

service LoginService {

  User.User login(
    1: string email
    2: string password
  )
}
