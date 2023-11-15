namespace java hello.realworld.core.domain
#@namespace scala hello.realworld.core.domain

enum UserStatus {
    CREATED,
    DELETED
}

struct User {

    1: string email
    2: string password
    3: UserStatus status = UserStatus.CREATED
}
