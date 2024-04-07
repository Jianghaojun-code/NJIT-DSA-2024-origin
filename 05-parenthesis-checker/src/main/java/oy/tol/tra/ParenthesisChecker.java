package oy.tol.tra;


public class ParenthesisChecker {

   private ParenthesisChecker() {
   }

   
    
    public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {

      int count=0;
    
      for(int i = 0; i < fromString.length(); i++){
         char Characterchecked = fromString.charAt(i);
      if(Characterchecked=='('|| Characterchecked=='['||Characterchecked=='{'){
      
          if(stack==null){
            throw new ParenthesesException("the stack is null and failure",ParenthesesException.STACK_FAILURE);
          }
          stack.push(Characterchecked);
          count++;
         
      }
      else if(Characterchecked==')'|| Characterchecked==']'||Characterchecked=='}'){
        
         if(stack.isEmpty()){
            throw new ParenthesesException("there are too many closing parentheses ",ParenthesesException.TOO_MANY_CLOSING_PARENTHESES);
         }
         
         Character poped = stack.pop();
         count++;
      
      if ((Characterchecked == ')' && poped != '(') ||(Characterchecked == ']' && poped != '[') ||(Characterchecked == '}' && poped != '{')){
           throw new ParenthesesException("wrong kind of parenthesis were in the text",ParenthesesException.PARENTHESES_IN_WRONG_ORDER);
      }
      }
      }
     
      if (!stack.isEmpty()) {
         throw new ParenthesesException("Too many opening parentheses.",ParenthesesException.STACK_FAILURE);
      }
          return count;
         }
      }
   

   