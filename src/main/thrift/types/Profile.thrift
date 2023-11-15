namespace java hello.realworld.core.domain
#@namespace scala hello.realworld.core.domain

include "User.thrift"

enum ProfileStatus {
    CREATED,
    DELETED
}

struct Profile {

    1: string username
    2: string bio
    3: string imageUrl
    4: User.User user
    5: ProfileStatus status = ProfileStatus.CREATED
}
