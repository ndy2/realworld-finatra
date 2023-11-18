package hello.realworld.adapter.in.model

import org.joda.time.LocalDateTime

case class AddCommentReq(
                          body: String
                        )

case class SingleCommentResp(
                              id: Int,
                              createdAt: LocalDateTime,
                              updatedAt: LocalDateTime,
                              body: String,
                              author: CommentAuthorResp
                            )

case class MultipleCommentsResp(
                                 comments: List[SingleCommentResp],
                                 commentCount: Int
                               )

case class CommentAuthorResp(
                              username: String,
                              bio: Option[String],
                              image: Option[String],
                              following: Boolean
                            )