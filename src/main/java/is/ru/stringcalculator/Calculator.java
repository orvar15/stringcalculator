package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")) {
			return sum(splitNumbers(text), null);
		}
		else if(text.contains(",\n") || text.contains("\n,")) {
			return 0;
		}
		else if(text.contains("//")){
			String delimiter = text.substring(text.indexOf("//") + 2, text.indexOf("\n"));
			return sum(splitDelimiter(text, delimiter), delimiter);
		}
		else
			return toInt(text);
	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers) {

	    return numbers.split(",|\n");
	}

	/*private static String[] splitNumbersOnNewLine(String numbers) {
		return numbers.split("\n");
	}*/
      
	private static String[] splitDelimiter(String numbers, String delimiter){
		return numbers.substring(numbers.indexOf("\n") + 1, numbers.length()).split(delimiter);
	}

    private static int sum(String[] numbers, String delimiter) {
 	    int total = 0;
 	    String negative = null;

        for(String number : numbers){

        	if(toInt(number) > 0 && toInt(number) <= 1000){
				 total += toInt(number);
			}
		    else if(toInt(number) < 0){
		    	if(!(negative == "")){
					
					negative = negative + "," + number;
				}
				else 
					negative += number;
				}
			if(toInt(number) < 0){
				throw new IllegalArgumentException(negative);
			}
			else if(delimiter != null){
				System.out.println(total + "(the delimiter is " + delimiter + ")");
			}
		}

		return total;
    }
}