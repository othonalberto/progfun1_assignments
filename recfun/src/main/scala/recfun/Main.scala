package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      if (c == r || c == 0) 1
      else pascal(c-1, r-1) + pascal(c, r-1)

  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def auxFunction(n: Int, chars: List[Char]): Boolean = {
        if (n < 0) false // there are more ')' than '('
        else if (chars.isEmpty) {
          if (n == 0) true
          else false
        }
        else if (chars.head == '(') auxFunction(n + 1, chars.tail)
        else if (chars.head == ')') auxFunction(n - 1, chars.tail)
        else auxFunction(n, chars.tail) // any other character
      }

      auxFunction(0, chars)

    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money < 0 || coins.isEmpty) 0
      else if (money == 0) 1
      else countChange(money, coins.tail) + countChange(money-coins.head, coins)
    }
  }
