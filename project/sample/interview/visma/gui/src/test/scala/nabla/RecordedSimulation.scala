package nabla 
import com.excilys.ebi.gatling.core.Predef._
import com.excilys.ebi.gatling.http.Predef._
import com.excilys.ebi.gatling.jdbc.Predef._
import com.excilys.ebi.gatling.http.Headers.Names._
import akka.util.duration._
import bootstrap._
import assertions._

class RecordedSimulation extends Simulation {

	val httpConf = httpConfig
			.baseURL("http://localhost:9090")
			.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
			.acceptEncodingHeader("gzip, deflate")
			.acceptLanguageHeader("en-US,en;q=0.5")
			.connection("keep-alive")
			.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:32.0) Gecko/20100101 Firefox/32.0")


	val headers_1 = Map(
			"Cache-Control" -> """max-age=0"""
	)

	val headers_2 = Map(
			"Content-Type" -> """application/x-www-form-urlencoded"""
	)

	val headers_3 = Map(
			"Accept" -> """text/css,*/*;q=0.1"""
	)


	val scn = scenario("Scenario Name")
		.exec(http("request_1")
					.get("/visma/loan.xhtml")
					.headers(headers_1)
			)
		.pause(13)
		.exec(http("request_2")
					.post("/visma/loan.xhtml")
					.headers(headers_2)
						.param("""loan_form""", """loan_form""")
						.param("""loan_form:loanType""", """1""")
						.param("""loan_form:loanAmount""", """100000""")
						.param("""loan_form:paybackTime""", """10""")
						.param("""loan_form:payment""", """Show monthlty payments""")
						.param("""javax.faces.ViewState""", """2996547759582942541:511639537175624412""")
			)
		.pause(151 milliseconds)
		.exec(http("request_3")
					.get("/visma/RES_NOT_FOUND")
					.headers(headers_3)
					.check(status.is(404))
			)
		.pause(5)
		.exec(http("request_4")
					.get("/visma/loan.xhtml")
			)

	setUp(scn.users(1).protocolConfig(httpConf))
}
