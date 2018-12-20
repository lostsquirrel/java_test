package demo.exception;

@SuppressWarnings("finally")
public class FinallyDemos {


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


    /**
     * finally 块中的 return 返回后方法结束执行，不会再执行 try 块中的 return 语句。
     * @return 2
     */
	public static int testReturnInFinally() {
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
