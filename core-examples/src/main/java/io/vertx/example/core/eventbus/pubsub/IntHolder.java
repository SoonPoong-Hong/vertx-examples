package io.vertx.example.core.eventbus.pubsub;

public class IntHolder {
	private int k = 0;
	public int get(){
		return ++k;
	}
}
