import java.io.InputStream
import java.io.InputStreamReader
import java.io.BufferedReader
import java.util.Scanner

// Solution for challenge at $challengeurl$
object Code {

  type Return = String

  def main(args: Array[String]): Unit = {
    val reader: BufferedReader = Console.in
    val in: Scanner = new Scanner(reader)

    val numberOfTestCases: Int = in.nextInt();

    for (i <- 1 to numberOfTestCases) {
      val caseInput1 = in.nextInt() // N
      val caseInput2 = in.nextInt() // M
      val data = in.next()

      val caseResult = logic(caseInput1, caseInput2, data)
      println(s"Case #\$i: \$caseResult")
    }

    in.close()
  }

  private def logic(caseInput1: Int, caseInput2: Int, data: String): Return = {
    "" + (caseInput1 + caseInput2) + " " + (caseInput1 * caseInput2)
  }

}
