// $ANTLR 3.0 /development/grammars/CSV Parser/grammar/CSV.g 2007-07-28 21:03:47

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CSVLexer extends Lexer {
    public static final int COMMA=5;
    public static final int QUOTED=6;
    public static final int EOF=-1;
    public static final int Tokens=8;
    public static final int UNQUOTED=7;
    public static final int NEWLINE=4;

    List<RecognitionException> exceptions = new ArrayList<RecognitionException>();

    public List<RecognitionException> getExceptions() {
      return exceptions;
    }

    @Override
    public void reportError(RecognitionException e) {
      super.reportError(e);
      exceptions.add(e);
    }


    public CSVLexer() {;} 
    public CSVLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "/development/grammars/CSV Parser/grammar/CSV.g"; }

    // $ANTLR start NEWLINE
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            // /development/grammars/CSV Parser/grammar/CSV.g:36:9: ( ( '\\r' )? '\\n' )
            // /development/grammars/CSV Parser/grammar/CSV.g:36:11: ( '\\r' )? '\\n'
            {
            // /development/grammars/CSV Parser/grammar/CSV.g:36:11: ( '\\r' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='\r') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /development/grammars/CSV Parser/grammar/CSV.g:36:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NEWLINE

    // $ANTLR start COMMA
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            // /development/grammars/CSV Parser/grammar/CSV.g:38:7: ( ( ( ' ' )* ',' ( ' ' )* ) )
            // /development/grammars/CSV Parser/grammar/CSV.g:38:9: ( ( ' ' )* ',' ( ' ' )* )
            {
            // /development/grammars/CSV Parser/grammar/CSV.g:38:9: ( ( ' ' )* ',' ( ' ' )* )
            // /development/grammars/CSV Parser/grammar/CSV.g:38:11: ( ' ' )* ',' ( ' ' )*
            {
            // /development/grammars/CSV Parser/grammar/CSV.g:38:11: ( ' ' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /development/grammars/CSV Parser/grammar/CSV.g:38:11: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(','); 
            // /development/grammars/CSV Parser/grammar/CSV.g:38:20: ( ' ' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /development/grammars/CSV Parser/grammar/CSV.g:38:20: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMA

    // $ANTLR start QUOTED
    public final void mQUOTED() throws RecognitionException {
        try {
            int _type = QUOTED;
            // /development/grammars/CSV Parser/grammar/CSV.g:40:8: ( ( '\"' ( options {greedy=false; } : . )+ '\"' )+ )
            // /development/grammars/CSV Parser/grammar/CSV.g:40:10: ( '\"' ( options {greedy=false; } : . )+ '\"' )+
            {
            // /development/grammars/CSV Parser/grammar/CSV.g:40:10: ( '\"' ( options {greedy=false; } : . )+ '\"' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\"') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /development/grammars/CSV Parser/grammar/CSV.g:40:11: '\"' ( options {greedy=false; } : . )+ '\"'
            	    {
            	    match('\"'); 
            	    // /development/grammars/CSV Parser/grammar/CSV.g:40:15: ( options {greedy=false; } : . )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0=='\"') ) {
            	            alt4=2;
            	        }
            	        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='\uFFFE')) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // /development/grammars/CSV Parser/grammar/CSV.g:40:42: .
            	    	    {
            	    	    matchAny(); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt4 >= 1 ) break loop4;
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);

            	    match('\"'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            	  	StringBuffer txt = new StringBuffer(getText()); 
            	  	// Remove first and last double-quote
            	  	txt.deleteCharAt(0);
            	  	txt.deleteCharAt(txt.length()-1);
            	  	// "" -> "
            	  	int probe;
            	  	while ((probe = txt.lastIndexOf("\"\"")) >= 0) {
            	  		txt.deleteCharAt(probe);
            	  	}
            	  	setText(txt.toString()); 
            	  

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUOTED

    // $ANTLR start UNQUOTED
    public final void mUNQUOTED() throws RecognitionException {
        try {
            int _type = UNQUOTED;
            // /development/grammars/CSV Parser/grammar/CSV.g:56:2: ( (~ ( '\\r' | '\\n' | ',' | ' ' ) )+ )
            // /development/grammars/CSV Parser/grammar/CSV.g:56:4: (~ ( '\\r' | '\\n' | ',' | ' ' ) )+
            {
            // /development/grammars/CSV Parser/grammar/CSV.g:56:4: (~ ( '\\r' | '\\n' | ',' | ' ' ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\u001F')||(LA6_0>='!' && LA6_0<='+')||(LA6_0>='-' && LA6_0<='\uFFFE')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /development/grammars/CSV Parser/grammar/CSV.g:56:4: ~ ( '\\r' | '\\n' | ',' | ' ' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\u001F')||(input.LA(1)>='!' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end UNQUOTED

    public void mTokens() throws RecognitionException {
        // /development/grammars/CSV Parser/grammar/CSV.g:1:8: ( NEWLINE | COMMA | QUOTED | UNQUOTED )
        int alt7=4;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // /development/grammars/CSV Parser/grammar/CSV.g:1:10: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 2 :
                // /development/grammars/CSV Parser/grammar/CSV.g:1:18: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 3 :
                // /development/grammars/CSV Parser/grammar/CSV.g:1:24: QUOTED
                {
                mQUOTED(); 

                }
                break;
            case 4 :
                // /development/grammars/CSV Parser/grammar/CSV.g:1:31: UNQUOTED
                {
                mUNQUOTED(); 

                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\3\uffff\1\4\1\uffff\1\4\1\uffff\2\6";
    static final String DFA7_eofS =
        "\11\uffff";
    static final String DFA7_minS =
        "\1\0\2\uffff\1\0\1\uffff\1\0\1\uffff\2\0";
    static final String DFA7_maxS =
        "\1\ufffe\2\uffff\1\ufffe\1\uffff\1\ufffe\1\uffff\2\ufffe";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\uffff\1\3\2\uffff";
    static final String DFA7_specialS =
        "\11\uffff}>";
    static final String[] DFA7_transitionS = {
            "\12\4\1\1\2\4\1\1\22\4\1\2\1\4\1\3\11\4\1\2\uffd2\4",
            "",
            "",
            "\12\5\1\6\2\5\1\6\22\5\1\6\13\5\1\6\uffd2\5",
            "",
            "\12\5\1\6\2\5\1\6\22\5\1\6\1\5\1\7\11\5\1\6\uffd2\5",
            "",
            "\12\5\1\uffff\2\5\1\uffff\22\5\1\uffff\1\5\1\10\11\5\1\uffff"+
            "\uffd2\5",
            "\12\5\1\uffff\2\5\1\uffff\22\5\1\uffff\1\5\1\10\11\5\1\uffff"+
            "\uffd2\5"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( NEWLINE | COMMA | QUOTED | UNQUOTED );";
        }
    }
 

}