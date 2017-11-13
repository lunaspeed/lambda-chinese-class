package hello

import java.time.format.DateTimeFormatter
import java.util.Locale

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}

import scala.collection.JavaConverters

class Handler extends RequestHandler[Request, Response] {

	def handleRequest(input: Request, context: Context): Response = {
		return new Response("Go Serverless v1.0! Your function executed successfully!", input)
	}
}

class ApiGatewayHandler extends RequestHandler[Request, ApiGatewayResponse] {

  def handleRequest(input: Request, context: Context): ApiGatewayResponse = {


    val headers = Map("x-custom-response-header" -> "my custom response header value")
    ApiGatewayResponse(200, "Go Serverless v1.0! Your function executed successfully!",
      JavaConverters.mapAsJavaMap[String, Object](headers),
      true)
  }
}

//object Handler {
//	private val df = DateTimeFormatter.ofPattern("yyyyMMdd'T'hh", Locale.TAIWAN)
//
//
//	def main(args: String*): Unit = {
//		println(df.parse("2001/02/23'T'13"))
//	}
//}
