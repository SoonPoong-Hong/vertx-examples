package io.vertx.example.core.net.echo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.streams.Pump;
import io.vertx.example.util.Runner;

/*
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class Server extends AbstractVerticle {

  // Convenience method so you can run it in your IDE
  public static void main(String[] args) {
//    Runner.runExample(Server.class);
		Vertx v = Vertx.vertx(new VertxOptions().setBlockedThreadCheckInterval(1000 * 60 * 60));
		v.deployVerticle(new Server());
  }

  @Override
  public void start() throws Exception {
//vertx.createHttpClient();

    vertx.createNetServer().connectHandler(sock -> {

      // Create a pump
      Pump.pump(sock, sock).start();

    }).listen(1234);

    System.out.println("Echo server is now listening");

  }
}
