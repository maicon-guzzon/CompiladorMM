package gals;

public class SemanticAnalyzer implements Constants
{
    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("A��o #"+action+", Token: "+token);
    }	
}
