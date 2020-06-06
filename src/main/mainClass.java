package main;

public class mainClass {

	public static void main(String[] args) {
				
		String str ="fgr685";
		
		String str2 = encrypt(str);
		String str3 = decipher(str2);
		
		System.out.println(" 암호화된 문자 : "+str2+" 복호화된 문자 : "+ str3);
					
	}
	
	static String encrypt(String str) {
		
		// 목적 : 문자열을 암호화시킨다.
		//방법 : 
		// 알파벳 소문자 아스키코드값 : 97 ~ 122 숫자 : 48 ~ 57
		// 아스키코드 값과 암호표의 인덱스값은 수의 차이로 순서대로 대응한다.
		// -> 알파벳의 경우는 수의 차이가 97이 나기 때문에 97을 감소시키면 암호표의 위치값을 얻을수 있다.
		// -> 숫자는 48차이가 난다.
		//결론 : 문자의 위치값(아스키 코드)과 암호의 위치값(배열의 인덱스)의 차이로 암호화를 시킨다.
		// 만약에 연속된 두 숫자의 집합이 있으면 특정 수의 차이로 각자 접근할 수 있다.
		
		// abcdefghijklmnopqrstuvwxyz
		char[] abcCode =
			{ '`','~','!','@','#','$','%','^','&','*',
			'(',')','-','_','+','=','|','[',']','{',
			'}',';',':',',','.','/'};
		
		// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
		String str2 = "";
		
		for (int i = 0; i < str.length(); i++) {
			
			int c = (int)str.charAt(i);//charAt()는 문자열의 위치값을 필요로 한다.
			if(c>96 && c<123) {
				int index = c - 97;
				str2 = str2 + abcCode[index];
			}
			else if(c>47 && c<58) {
				int index = c - 48;
				str2 = str2 + numCode[index];
			}
		}	
		return str2;
	}
	
	static String decipher(String str2) {
		
		// 목적 : 받은 문자를 다시 복호화 시킨다.
		// 방법 : 
		// 복호화 같은 경우 암호화된 문자를 주기 때문에 그 문자를 암호표에서 찾고 인덱스값을 얻어야 한다.
		// 그 인덱스 값은 본래 문자의 위치값과 연속이면서 일정 수의 차이로 대응이 되기 때문에 수의 차이로 본래 문자 데이터로 접근한다.
		// ex) 문자 : q 위치값 : [0] -> 문자 : 0 위치값 : 48
		
		// abcdefghijklmnopqrstuvwxyz
		char[] abcCode =
			{ '`','~','!','@','#','$','%','^','&','*',
			'(',')','-','_','+','=','|','[',']','{',
			'}',';',':',',','.','/'};
		
		// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
		String str3 = "";
		
		for (int i = 0; i < str2.length(); i++) {
			int c = (int)str2.charAt(i);
			
			if(c>96 &&c<123) {
				for (int j = 0; j < numCode.length; j++) {
					if((char)c==numCode[j]) {
						c = 48 + j;
						str3 = str3 + (char)c;
					}
				}
			}
			else {
				for (int j = 0; j < abcCode.length; j++) {
					if((char)c==abcCode[j]) {
						c = 97 + j;
						str3 = str3 + (char)c;
					}
				}
			}		
		}
		return str3;
	}
}
