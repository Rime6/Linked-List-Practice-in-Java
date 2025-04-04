import java.io.*;

public class ReadInput {
  private static String line = null;    // line read from input.
  private static int pos = 0;           // Position of next char in input line, not processed yet.
  private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  //  input stream
  private static boolean readingIn = true;


 /**
  *  reads a value of type char from input,
  */
    public static char getlnChar() {  
        char ch=getChar(); 
        line = null;
        return ch;
    }

    /*reads a character from input.  
     */
    public static char getChar() { 
        return readChar();
    }

    /**
  * return next character from input
  */
   
    private static char nextChar () {  
       if (line == null || pos > line.length())
            fillLine();
       
         if (pos == line.length())
            return '\n';
        else 
            return line.charAt(pos);
    }
    
   /**
  * returns and discards next character from input
  */
    private static char readChar() {  
        char ch = nextChar ();
        if (line == null) {
            if (readingIn)
                throw new IllegalArgumentException("Illegal Argument");
            
        }
        pos++;
        return ch;
    }   
    /**
     * Type a line and return,
     */
     private static void fillLine() {    
       try {
            line = in.readLine();
        }
        catch (Exception e) {
            if (readingIn)
                throw new IllegalArgumentException("Standard input error");
        }
        pos = 0;
      
    }
  
  /**
     * Reads all the characters from the current input source, up to the next end-of-line.  The end-of-line
     * is read but is not included in the return value.  
     */
    public static String getln() {
        StringBuffer str = new StringBuffer(100);
        char ch = readChar();
        while (ch != '\n') {
            str.append(ch);
            ch = readChar();
        }
        return str.toString();
    }

/**
     * reads a value of type in from input
     */   
     static public int getInt() {
       
        try {
            return Integer.parseInt(in.readLine());
        }
        catch (Exception e) {
            System.out.println("Input error " + e.getMessage());
            System.exit(-1);
        }
        return 0;
    }
}


