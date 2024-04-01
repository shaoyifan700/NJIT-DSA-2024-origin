package oy.tol.tra;

/**
 * Uses the StackInterface implementation to check that parentheses in text files
 * match. 
 * <p>
 * TODO: Students, implement the checkParentheses() method using your StackImplementation
 * to check if parentheses in the two test files match or not.
 * <p>
 * NOTE: The Person.json test file has an error, but the tests expect that. So the test will 
 * not fail with that file -- the erroneus json file is _expected_.
 * <p>
 * Note that you do not have to instantiate this class anywhere. The ParenthesisTests:
 * <ul>
 *  <li>Constructs your implementation of the {@code StackImplementation<Character>}, and
 *  <li>Calls ParenthesisChecker.checkParentheses.
 * </ul>
 * So your job is just to have a working StackImplementation and implement the ParenthesisChecker.checkParentheses.
 * Then execute the ParenthesisTests.
 */
public class ParenthesisChecker {

   private ParenthesisChecker() {
   }

   /**
    * TODO: Implement this function which checks if the given string has matching opening and closing
    * parentheses. It should check for matching parentheses:<p>
    *  <code>Lorem ipsum ( dolor sit {  amet, [ consectetur adipiscing ] elit, sed } do eiusmod tempor ) incididunt ut...</code>,
    * <p>
    * which can be found for example in Java source code and JSON structures.
    * <p>
    * If the string has issues with parentheses, you should throw a {@code ParenthesisException} with a
    * descriptive message and error code. Error codes are already defined for you in the ParenthesesException
    * class to be used.
    * <p>
    * What is to be tested:
    * <ul>
    *  <li>when an opening parenthesis is found in the string, it is successfully pushed to the stack.
    *  <li>when a closing parenthesis is found in the string, a matching opening parenthesis is popped from the stack.
    *  <li>when popping a parenthesis from the stack, it must not be null. Otherwise string has too many closing parentheses.
    *  <li>when the string has been handled, and if the stack still has parentheses, there are too few closing parentheses.
    * </ul>
    * @param stack The stack object used in checking the parentheses from the string.
    * @param fromString A string containing parentheses to check if it is valid.
    * @return Returns the number of parentheses found from the input in total (both opening and closing).
    * @throws ParenthesesException if the parentheses did not match as intended.
    * @throws StackAllocationException If the stack cannot be allocated or reallocated if necessary.
    */
    /* public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {
      // TODO:
      // for each character in the input string
      //   if character is an opening parenthesis -- one of "([{"
      //      push it into the stack (check for failure and throw an exception if so)
      //   else if character is a closing parenthesis -- one of ")]}"
      //      pop the latest opening parenthesis from the stack
      //      if the popped item is null
      //         throw an exception, there are too many closing parentheses 
      //      check the popped opening parenthesis against the closing parenthesis read from the string
      //      if they do not match -- opening was { but closing was ], for example.
      //         throw an exception, wrong kind of parenthesis were in the text (e.g. "asfa ( asdf } sadf")
      // if the stack is not empty after all the characters have been handled
      //   throw an exception since the string has more opening than closing parentheses.

   } */
   public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {
      // 遍历字符串中的每个字符
      for (char c : fromString.toCharArray()) {
          if (c == '(' || c == '[' || c == '{') {
              // 如果字符是开放括号之一，则将其推入堆栈
              try {
                  stack.push(c);
              } catch (StackAllocationException e) {
                  throw new ParenthesesException("Failed to push opening parenthesis onto stack", ParenthesesException.STACK_FAILURE);
              }
          } else if (c == ')' || c == ']' || c == '}') {
              // 如果字符是关闭括号之一
              try {
                  // 弹出堆栈中的最新开放括号
                  Character popped = stack.pop();
                  if (popped == null) {
                      // 如果弹出的项目为null，则有太多的关闭括号
                      throw new ParenthesesException("Too many closing parentheses", ParenthesesException.TOO_MANY_CLOSING_PARENTHESES);
                  }
                  // 检查弹出的开放括号与读取的关闭括号是否匹配
                  if (!((c == ')' && popped == '(') || (c == ']' && popped == '[') || (c == '}' && popped == '{'))) {
                      // 如果它们不匹配，则抛出异常
                      throw new ParenthesesException("Wrong kind of parenthesis in text", ParenthesesException.PARENTHESES_IN_WRONG_ORDER);
                  }
              } catch (StackIsEmptyException e) {
                  // 如果堆栈为空，则有太少的关闭括号
                  throw new ParenthesesException("Too few closing parentheses", ParenthesesException.TOO_FEW_CLOSING_PARENTHESES);
              }
          }
      }
  
      // 如果堆栈不为空，则字符串中有更多的开放括号而没有关闭括号
      if (!stack.isEmpty()) {
          throw new ParenthesesException("String has more opening than closing parentheses", ParenthesesException.TOO_FEW_CLOSING_PARENTHESES);
      }
  
      // 返回字符串中找到的括号的总数（包括开放和关闭）
      return countParentheses(fromString);
  }
  
  // 辅助方法：计算字符串中括号的数量
  private static int countParentheses(String str) {
      int count = 0;
      for (char c : str.toCharArray()) {
          if (c == '(' || c == '[' || c == '{' || c == ')' || c == ']' || c == '}') {
              count++;
          }
      }
      return count;
  }
  
  
}
