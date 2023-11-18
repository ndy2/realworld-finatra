package hello.realworld.adapter.in.model

import org.joda.time.LocalDateTime

case class CreateArticleReq(
                             title: String,
                             description: String,
                             body: String,
                             tagList: List[String]
                           )

case class UpdateArticleReq(
                             title: String,
                             description: String,
                             body: String,
                             tagList: List[String]
                           )


case class SingleArticleResp(
                              slug: String,
                              title: String,
                              description: String,
                              body: String,
                              tagList: List[String],
                              createdAt: LocalDateTime,
                              updatedAt: LocalDateTime,
                              favorited: Boolean,
                              favoritesCount: String,
                              author: ArticleAuthorResp
                            )

case class MultipleArticlesResp(
                                 articles: List[SingleArticleResp],
                                 articleCount: Int
                               )

case class ArticleAuthorResp(
                       username: String,
                       bio: Option[String],
                       image: Option[String],
                       following: Boolean
                     )
