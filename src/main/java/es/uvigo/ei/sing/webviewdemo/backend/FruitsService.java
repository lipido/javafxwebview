package es.uvigo.ei.sing.webviewdemo.backend;

import static es.uvigo.ei.sing.javafx.webview.Java2JavascriptUtils.call;
import static java.lang.Thread.sleep;
import static javafx.application.Platform.runLater;

import static java.util.Arrays.asList;
import static java.util.Collections.shuffle;
import netscape.javascript.JSObject;

import java.util.List;

public class FruitsService {

        // a database... WARNING: I use a static field, since references from javascript seem not to be taken into account for GC, then,
        // if I set fruits as a local variable inside loadFruits, they could be garbage collected and not seen anymore from
        // javascript
        
        private static Fruit[] fruits;
        static {
              fruits =
                    new Fruit[] { new Fruit("orange"), new Fruit("apple"), new Fruit("banana"), new Fruit("strawberry") };
        }
	// async function
	public void loadFruits(final JSObject callbackfunction){
		
		
		
		// launch a background thread (async)
		new Thread( () -> {
				try {
                                        shuffleFruits();
					sleep(1000); //add some processing simulation...
					runLater( () -> {
                                            call(callbackfunction, (Object) FruitsService.fruits);
					});
					
				} catch (InterruptedException e) {	}
			}
		).start();
	}
	
	private static void shuffleFruits() {
            List<Object> list = asList(FruitsService.fruits);
            shuffle(list);
            FruitsService.fruits = list.toArray(new Fruit[]{});
	}
}
