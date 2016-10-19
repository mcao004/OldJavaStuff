// Project 8.7
//Generate random Blurbs using recursion
/*In the language of an alien race, all words take the form of Blurbs. A Blurb is a Whoozit
followed by one or more Whatzits. A Whoozit is the character x followed by zero or more ys. A
Whatzit is a q followed by either a z or a d, followed by a Whoozit. Design and implement a
recursive program that generates random Blurbs in this alien language.  */

import java.util.Random;
import java.lang.StringBuffer;

public class BlurbGenerator {

    public BlurbGenerator()
    {
    	chooser = new Random();
    }

    private String getWhoozits()
    {
    	StringBuffer y = new StringBuffer();
    	boolean stop = chooser.nextBoolean();
    	if (!stop)
    		y.append(getWhoozits());
    	else
    		return y.toString();

    	y.append("y");
    	return y.toString();
    }

    // a whatzit is a character 'x' followed by a zero or more 'y's
    private String getwhatzit()
    {
    	StringBuffer whatzit = new StringBuffer();
    	whatzit.append("q");
    	boolean more = chooser.nextboolean();
    	if (more)
    		whatzit.append("z");
    	else
    		whatzit.append("d");
    	whatzit.append(getWhoozit());
    }

    private String getMultiplewhatzits()
    {
    	StringBuffer whatzits = new StringBuffer();

    	whatzits.append(getwhatzit());
    	boolean stop = chooser.nextBoolean();
    	if (!stop)
    		whatzits.append(getMultiplewhatzits());
    	else
    		return whatzits.toString();

    	return whatzits.toString();
    }

    public String generateBlurb()
    {
    	StringBuffer blurb = new StringBuffer();
    	blurb.append(getwhoozit());
    	blurb.append(getMultiplewhatzits());

    	return blurb.toString();
    }

}
