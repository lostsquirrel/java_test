package demo.exception;

@SuppressWarnings("finally")
public class TestFinally {

	public static void main(String[] args) {
		System.out.println( TestFinally.test());
		System.out.println( TestFinally.test1());
		System.out.println( TestFinally.test2());
	}

	static int test() {
		int x = 1;
		try
		{
			return x;
		}
		finally
		{
			++x;
		}
	}
	
	
	static int test1() {
		 try {
               return 1 ;
         } finally {
               return 2;
         }
	}
	
	static int test2()
    {
         try
         {
             return func1();
         }
         finally
         {
             return func2();
         }

    }

    

	static int func1()
    {
         System.out.println("func1");
         return 1;
    }

	static int func2()
    {
         System.out.println("func2");
         return 2;
    }    
}
