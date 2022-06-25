import java.util.*;
public class ColumnCipher {
	static StringBuffer s ;
	static String k;
	static char [][]a;
	static int w,n;
	static int t[];
	static void read(String s1)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the " + s1 +" text");
		String s = in.nextLine();
		System.out.println("Enter the key ");
		k = in.next();
		n = k.length();
		if(n==1)
			n = Integer.parseInt(k);
		else{
			t = new int[n];
			for(int i =0;i<n;i++)
				t[i]= (int)(k.charAt(i))-(int)('0');
		}
		int v = s.length();
		if(v%n ==0)
			w = v/n;
		else
			w = v/n +1;
		if(s1.equalsIgnoreCase("cipher")){
			int temp =w;
			w =n;
			n=temp;
		}
		a = new char[w][n];
		try{
			int q =0;
			for(int i =0;i<w;i++)
				for(int j =0;j<n;j++)
					a[i][j] =s.charAt(q++); 
		}
		catch(StringIndexOutOfBoundsException e){
			for(int q = n-1;q>=(v%n);q--)
				a[w-1][q] = '#';
		}	
	}
	static void encrypt(){
		s = new StringBuffer();
		read("plain");
		if(k.length()==1){
			for (int i = 0; i < n; i++) 
				for(int j =0;j < w;j++)
					s.append(a[j][i]);
		}
		else{
			int u=0;
			for (int i = 1; i <= n; i++){ 
				for(int k =0;k<n;k++)
					if(i==t[k])
						u=k;
				for(int j =0;j < w;j++){
					s.append(a[j][u]);
				}
			}	
		}
		System.out.println("the cipher text is "+"'"+s+"'");
	}
	
	
	static void decrypt(){
		s = new StringBuffer();
		read("cipher");
		if(k.length()!=1){
			char x[][]= new char[w][n];
			for(int i =0;i<w;i++){
				x[i]=a[t[i]-1];
			}
			a=x;
		}
		for (int i = 0; i < n; i++) 
			for(int j =0;j < w;j++){
				if(a[j][i]=='#' )
					continue;
				s.append(a[j][i]);
			}
		System.out.println("the decrpyted text is "+"'"+s+"'");
	}
	
	public static void main(String []argv){
		System.out.println("Enter the choice");
		System.out.println("1-Encrypt");
		System.out.println("2-Decrypt");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		switch(n){
		case 1:
			encrypt();
			break;
		case 2:
			decrypt();
		}	
	}
}
