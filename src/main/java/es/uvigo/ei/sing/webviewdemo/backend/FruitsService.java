package es.uvigo.ei.sing.webviewdemo.backend;

import static es.uvigo.ei.sing.javafx.webview.Java2JavascriptUtils.call;
import static java.lang.Thread.sleep;
import static javafx.application.Platform.runLater;

import static java.util.Arrays.asList;
import static java.util.Collections.shuffle;
import netscape.javascript.JSObject;

import java.util.List;

public class FruitsService {

	// async function
	public void loadFruits(final JSObject callbackfunction){
		
		// a database...
		final Fruit[] fruits = 
                    new Fruit[] { new Fruit("orange"), new Fruit("apple"), new Fruit("banana"), new Fruit("strawberry") };
		
		// launch a background thread (async)
		new Thread( () -> {
				try {
                                        shuffleArray(fruits);
					sleep(1000); //add some processing simulation...
					runLater( () -> {
                                            call(callbackfunction, (Object) fruits);
					});
					
				} catch (InterruptedException e) {	}
			}
		).start();
	}
	
	private static Object[] shuffleArray(Object[] array) {
            List<Object> list = asList(array);
            shuffle(list);
            return list.toArray(new Object[]{});
	}
}
