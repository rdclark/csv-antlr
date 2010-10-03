// $ANTLR 3.0 /development/grammars/CSV Parser/grammar/CSV.g 2007-07-28 21:03:46

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class CSVParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEWLINE", "COMMA", "QUOTED", "UNQUOTED"
    };
    public static final int COMMA=5;
    public static final int QUOTED=6;
    public static final int EOF=-1;
    public static final int UNQUOTED=7;
    public static final int NEWLINE=4;

        public CSVParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[3+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "/development/grammars/CSV Parser/grammar/CSV.g"; }


    protected static class line_scope {
        List fields;
    }
    protected Stack line_stack = new Stack();


    // $ANTLR start line
    // /development/grammars/CSV Parser/grammar/CSV.g:18:1: line returns [List<String> result] : ( ( NEWLINE )=> NEWLINE | field ( COMMA field )* NEWLINE ) ;
    public final List<String> line() throws RecognitionException {
        line_stack.push(new line_scope());
        List<String> result = null;

         ((line_scope)line_stack.peek()).fields = new ArrayList(); 
        try {
            // /development/grammars/CSV Parser/grammar/CSV.g:21:2: ( ( ( NEWLINE )=> NEWLINE | field ( COMMA field )* NEWLINE ) )
            // /development/grammars/CSV Parser/grammar/CSV.g:21:4: ( ( NEWLINE )=> NEWLINE | field ( COMMA field )* NEWLINE )
            {
            // /development/grammars/CSV Parser/grammar/CSV.g:21:4: ( ( NEWLINE )=> NEWLINE | field ( COMMA field )* NEWLINE )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NEWLINE) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred1()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (backtracking>0) {failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("21:4: ( ( NEWLINE )=> NEWLINE | field ( COMMA field )* NEWLINE )", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA2_0>=COMMA && LA2_0<=UNQUOTED)) ) {
                alt2=2;
            }
            else {
                if (backtracking>0) {failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("21:4: ( ( NEWLINE )=> NEWLINE | field ( COMMA field )* NEWLINE )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /development/grammars/CSV Parser/grammar/CSV.g:22:6: ( NEWLINE )=> NEWLINE
                    {
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_line47); if (failed) return result;

                    }
                    break;
                case 2 :
                    // /development/grammars/CSV Parser/grammar/CSV.g:23:8: field ( COMMA field )* NEWLINE
                    {
                    pushFollow(FOLLOW_field_in_line56);
                    field();
                    _fsp--;
                    if (failed) return result;
                    // /development/grammars/CSV Parser/grammar/CSV.g:23:14: ( COMMA field )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==COMMA) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /development/grammars/CSV Parser/grammar/CSV.g:23:15: COMMA field
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_line59); if (failed) return result;
                    	    pushFollow(FOLLOW_field_in_line62);
                    	    field();
                    	    _fsp--;
                    	    if (failed) return result;

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    match(input,NEWLINE,FOLLOW_NEWLINE_in_line66); if (failed) return result;

                    }
                    break;

            }

            if ( backtracking==0 ) {
               result = ((line_scope)line_stack.peek()).fields; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            line_stack.pop();
        }
        return result;
    }
    // $ANTLR end line


    // $ANTLR start field
    // /development/grammars/CSV Parser/grammar/CSV.g:28:1: field : (f= QUOTED | f= UNQUOTED | ) ;
    public final void field() throws RecognitionException {
        Token f=null;

        try {
            // /development/grammars/CSV Parser/grammar/CSV.g:29:2: ( (f= QUOTED | f= UNQUOTED | ) )
            // /development/grammars/CSV Parser/grammar/CSV.g:29:4: (f= QUOTED | f= UNQUOTED | )
            {
            // /development/grammars/CSV Parser/grammar/CSV.g:29:4: (f= QUOTED | f= UNQUOTED | )
            int alt3=3;
            switch ( input.LA(1) ) {
            case QUOTED:
                {
                alt3=1;
                }
                break;
            case UNQUOTED:
                {
                alt3=2;
                }
                break;
            case NEWLINE:
            case COMMA:
                {
                alt3=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("29:4: (f= QUOTED | f= UNQUOTED | )", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /development/grammars/CSV Parser/grammar/CSV.g:29:6: f= QUOTED
                    {
                    f=(Token)input.LT(1);
                    match(input,QUOTED,FOLLOW_QUOTED_in_field91); if (failed) return ;

                    }
                    break;
                case 2 :
                    // /development/grammars/CSV Parser/grammar/CSV.g:30:6: f= UNQUOTED
                    {
                    f=(Token)input.LT(1);
                    match(input,UNQUOTED,FOLLOW_UNQUOTED_in_field100); if (failed) return ;

                    }
                    break;
                case 3 :
                    // /development/grammars/CSV Parser/grammar/CSV.g:32:4: 
                    {
                    }
                    break;

            }

            if ( backtracking==0 ) {
               ((line_scope)line_stack.peek()).fields.add((f == null) ? "" : f.getText()); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end field

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // /development/grammars/CSV Parser/grammar/CSV.g:22:6: ( NEWLINE )
        // /development/grammars/CSV Parser/grammar/CSV.g:22:7: NEWLINE
        {
        match(input,NEWLINE,FOLLOW_NEWLINE_in_synpred142); if (failed) return ;

        }
    }
    // $ANTLR end synpred1

    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_NEWLINE_in_line47 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_in_line56 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_COMMA_in_line59 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_field_in_line62 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_NEWLINE_in_line66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_in_field91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNQUOTED_in_field100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_synpred142 = new BitSet(new long[]{0x0000000000000002L});

}