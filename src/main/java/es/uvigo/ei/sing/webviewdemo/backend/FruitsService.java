package es.uvigo.ei.sing.webviewdemo.backend;

import static es.uvigo.ei.sing.javafx.webview.Java2JavascriptUtils.call;
import static java.lang.Thread.sleep;
import static java.util.Arrays.asList;
import static java.util.Collections.shuffle;
import static javafx.application.Platform.runLater;
import static org.json.simple.JSONValue.toJSONString;

import java.util.List;

public class FruitsService {

	// async function
	public void loadFruits(final Object callbackfunction){
		
		// a database...
		final List<String> fruits = asList(
				new String[] { "orange", "apple", "banana", "strawberry" });
		
		// launch a background thread (async)
		new Thread( () -> {
				try {
					shuffle(fruits);
					sleep(1000); //add some processing simulation...
					runLater( () -> 							
					call(callbackfunction, toJSONString(fruits))
					);
				} catch (InterruptedException e) {	}
			}
		).start();
	}
}
