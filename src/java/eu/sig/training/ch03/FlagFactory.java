package eu.sig.training.ch03;

import java.awt.Color;
import java.lang.reflect.Method;
import java.util.List;

public class FlagFactory {

    // tag::getFlag[]
    public List<Color> getFlagColors(Nationality nationality) {
    	List<Color> colors = null;
    	
        Class<?> clazz = nationality.getClass();
        try {
        	Method method = clazz.getMethod("getFlag");
            Flag flag = (Flag) method.invoke(nationality, null);
            colors = flag.getColors();
        } catch (Exception e) {
        	e.printStackTrace();
        }        
    	return colors;    	
    }
    // end::getFlag[]

}