package businesslogic;

public class RegistrationValidation {
	public boolean checkUserDetails(String email, String password, String confirmPassword) {
		if(validEmail(email) && validPassword(password,confirmPassword))
			return true;
		else
			return false;
	}
	
	private static boolean validPassword(String password, String confirmPassword) {
		int lenPassword=0,lenConfirmPassword=0;
		lenConfirmPassword=confirmPassword.length();
		lenPassword=password.length();
		if(password.length()==0 || confirmPassword.length()==0 || !(password.equals(confirmPassword)) || !((lenPassword>=8 && lenPassword<=20) || (lenConfirmPassword>=8 && lenConfirmPassword<=20)))
			return false;
		else {
			if (passwordOk(password) && passwordOk(confirmPassword))
				return true;
			else
				return false;
		}
	}

	private static boolean passwordOk(String password) {
		int upperCase=0,lowerCase=0,digit=0,spChar=0;
		for (int i=0;i<password.length();i++){
			if(Character.isUpperCase(password.charAt(i)))
				upperCase++;
			else if(Character.isLowerCase(password.charAt(i)))
				lowerCase++;
			else if(Character.isDigit(password.charAt(i)))
				digit++;
			else if(isSpecilCharacter(password.charAt(i)))
				spChar++;
			else
				return false;
		}
//		System.out.println("upperCase = "+upperCase+"\nlowerCase = "+lowerCase+"\ndigit = "+digit+"\nspecialCharacter = "+spChar);

		if(upperCase>0 && lowerCase>0 && digit>0)
			return true;
		else
			return false;
	}

	private static boolean isSpecilCharacter(char c) {
		char[] specialCharacter = {'~','!','@','#','$','%','^','&','*','(',')','_','+','-','=','{','}','|',';',':','<','.','>','/','?'};
		int flag=1;
		for(int i=0;i<specialCharacter.length;i++){
			flag=1;
			if(specialCharacter[i]==c){
				flag=0;
				break;
			}
		}
		if(flag==0)
			return true;
		else
			return false;
	}
	
	private boolean validEmail(String email) {
		int atTheRate=0,dot=0,alphbetes=0,len=0;
		len = email.length();
		len-=2;
		if(email.length()==0)
			return false;
		else {
			for(int i=0;i<email.length();i++) {
				if(email.charAt(i)=='@')
					atTheRate++;
				else if(email.charAt(i)=='.')
					dot++;
				else if(Character.isAlphabetic(email.charAt(i)))
					alphbetes++;
				else
					return false;
			}
//			System.out.println("@ = "+atTheRate+"\n. = "+dot+"\nAlphabets = "+alphbetes);
		}
		if(atTheRate==1 && dot==1 && len==alphbetes)
			return true;
		else
			return false;

	}
}