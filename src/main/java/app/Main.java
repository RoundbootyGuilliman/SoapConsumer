package app;


import com.epam.jmstask.soap.CardValidatorService;
import com.epam.jmstask.soap.CreditCard;
import com.epam.jmstask.soap.Validator;

public class Main {
	
	private static CardValidatorService cardValidatorService = new CardValidatorService();
	
	public static void main(String[] args) {
		
		CreditCard creditCard = new CreditCard();
		creditCard.setNumber("12341234");
		creditCard.setExpirationDate("10/10");
		creditCard.setControlNumber(1234);
		creditCard.setType("VISA");
		
		Validator cardValidator = cardValidatorService.getCardValidatorPort();
		System.out.println("IS VALID? " + cardValidator.validate(creditCard));
		
		creditCard.setNumber("12341233");
		System.out.println("IS VALID? " + cardValidator.validate(creditCard));
	}
}
