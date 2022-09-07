package day11;

public class String_Assignment1 {
	public static void main(String[] args) {
		String paragraph = new String("Neuro-linguistic programming (NLP) is a psychological approach that involves analyzing strategies used by successful individuals and applying them to reach a personal goal. It relates thoughts, language, and patterns of behavior learned through experience to specific outcomes.Natural Language Processing (NLP) is a subfield of artificial intelligence (AI).It is useful. It helps machines process and understand the human language so that they can automatically perform repetitive tasks. Examples include machine translation, summarization, ticket classification, and spell check.");
		int wordLength = paragraph.split(" ").length;
		//int senLength = paragraph.split("\\.").length;
		int sentCount = 0;
		System.out.println("Number of character: " + paragraph.length());
		int len = paragraph.length();
		for(int i = 0; i < len; i++) {
			if(paragraph.charAt(i) == '.') {
				sentCount++;
			}
		}
		System.out.println("Number of sentences: " + sentCount);
		System.out.println("Number of words: " + wordLength);
	}
}
