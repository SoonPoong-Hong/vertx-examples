package io.vertx.example.core.http.websockets;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.example.util.Runner;

/*
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class Server extends AbstractVerticle {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// Convenience method so you can run it in your IDE
	public static void main(String[] args) {
		Runner.runExample(Server.class);
	}

	@Override
	public void start() throws Exception {
		vertx.createHttpServer()
				.websocketHandler(ws -> ws.handler(b -> ws.writeFinalTextFrame("돌려보냄.. ==> " + b.toString(Charset.forName("UTF8"))+"=>" + this.context)))
				.requestHandler(req -> {
					if (req.uri().equals("/")) {
						req.response().sendFile("ws.html");
					}
				}).listen(8080, r->{
					if(r.succeeded()){
						logger.warn("== listening 시작..");
					}
				});
	}
}
