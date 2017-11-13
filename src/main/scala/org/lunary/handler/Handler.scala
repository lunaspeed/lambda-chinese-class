package org.lunary.handler

import java.time.{LocalDateTime, ZoneId, ZonedDateTime}
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.{Map => JMap}

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import hello.ApiGatewayResponse
import org.lunary.http.request.HttpRequest


class Handler extends RequestHandler[HttpRequest, ApiGatewayResponse] {

  override def handleRequest(input: HttpRequest, context: Context): ApiGatewayResponse = {

    val name = input.queryStringParameters.get("name")
    val test = 測試(name)

    ApiGatewayResponse(200, test.toString, new java.util.HashMap(), false)

  }


}

case class 測試(name: String)
