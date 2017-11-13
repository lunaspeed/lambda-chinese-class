package org.lunary.http

import java.util.{Collections, Map => JMap}

import scala.beans._

object request {

  //adopt from https://github.com/bbilger/jrestless
  class HttpRequest {

    @BeanProperty var resource: String = _
    @BeanProperty var httpMethod: String = _
    @BeanProperty var path: String = _
    @BeanProperty var headers: JMap[String, String] = Collections.emptyMap()
    @BeanProperty var pathParameters: JMap[String, String] = Collections.emptyMap()
    @BeanProperty var queryStringParameters: JMap[String, String] = Collections.emptyMap()
    @BeanProperty var stageVariables: JMap[String, String] = Collections.emptyMap()
    @BeanProperty var requestContext: GatewayRequestContext = _
    @BeanProperty var body: String = _
    @BeanProperty var base64Encoded: Boolean = false

  }

  class GatewayRequestContext {

    @BeanProperty var accountId: String = _
    @BeanProperty var resourceId: String = _
    @BeanProperty var stage: String = _
    @BeanProperty var requestId: String = _
    @BeanProperty var identity: GatewayIdentity = _
    @BeanProperty var resourcePath: String = _
    @BeanProperty var httpMethod: String = _
    @BeanProperty var apiId: String = _
    @BeanProperty var authorizer: JMap[String, Any] = Collections.emptyMap()

    override def toString(): String = {
      s"DefaultGatewayRequestContext [accountId=$accountId, resourceId=$resourceId, stage=$stage, requestId=$requestId, identity=$identity, resourcePath=$resourcePath, httpMethod=$httpMethod, apiId=$apiId, authorizer=$authorizer]"
    }
  }

  class GatewayIdentity {

    @BeanProperty var cognitoIdentityPoolId: String = _
    @BeanProperty var accountId: String = _
    @BeanProperty var cognitoIdentityId: String = _
    @BeanProperty var caller: String = _
    @BeanProperty var apiKey: String = _
    @BeanProperty var sourceIp: String = _
    @BeanProperty var accessKey: String = _
    @BeanProperty var cognitoAuthenticationType: String = _
    @BeanProperty var cognitoAuthenticationProvider: String = _
    @BeanProperty var userArn: String = _
    @BeanProperty var userAgent: String = _
    @BeanProperty var user: String = _

    override def toString(): String = {
      s"DefaultGatewayIdentity [cognitoIdentityPoolId=$cognitoIdentityPoolId, accountId=$accountId, cognitoIdentityId=$cognitoIdentityId, caller=$caller, apiKey=$apiKey, sourceIp=$sourceIp, accessKey=$accessKey, cognitoAuthenticationType=$cognitoAuthenticationType, cognitoAuthenticationProvider=$cognitoAuthenticationProvider, userArn=$userArn, userAgent=$userAgent, user=$user]"
    }
  }

}

object response {
  class HttpResponse {
    @BeanProperty var body: String = ""
    @BeanProperty var headers: JMap[String, String] = Collections.emptyMap()
    @BeanProperty var statusCode: Int = -1
    @BeanProperty var base64Encoded: Boolean = false
  }

//  object HttpResponse {
//
//    implicit def toResponse[T](t: T)(implicit writes: OWrites[T]): HttpResponse = {
//
//      val resp = new HttpResponse
//      resp.body = writes.writes(t).toString()
//      resp.statusCode = 200
//      resp
//    }
//  }

}
