namespace java hello.realworld.core.domain
#@namespace scala hello.realworld.core.domain

include "Profile.thrift"

enum ArticleStatus {
    CREATED,
    DELETED
}


struct Article {

    1: string slug
    2: string title
    3: string description
    4: string body
    5: list<string> tags
    6: i64 createdAt
    7: optional i64 updatedAt
    8: Profile.Profile author
    9: ArticleStatus status = ArticleStatus.CREATED
}

