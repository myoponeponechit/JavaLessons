package day6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment1 {

	public static void main(String[] args) {
		String paragraph = new String("Neuro-linguistic programming (NLP) is a psychological approach that involves analyzing strategies used by successful individuals and applying them to reach a personal goal. It relates thoughts, language, and patterns of behavior learned through experience to specific outcomes.Natural Language Processing (NLP) is a subfield of artificial intelligence (AI).It is useful. It helps machines process and understand the human language so that they can automatically perform repetitive tasks. Examples include machine translation, summarization, ticket classification, and spell check.");
		//String search_char = "([.])";
		// create pattern obj
		Pattern patt = Pattern.compile("([.])");
		
		// create matcher obj
		Matcher m = patt.matcher(paragraph);
		//System.out.println(m);
		int count = 0;
		while(m.find()) {
			count++;  // count = 6
			//System.out.println(count);
		}
		count++; // for the lest line, which will not get includeed here.
		System.out.println("Number of sentences: " + count);
		
		String[] data = paragraph.split(" ");
		System.out.println("Noumber of words: " + data.length);
	}
}
