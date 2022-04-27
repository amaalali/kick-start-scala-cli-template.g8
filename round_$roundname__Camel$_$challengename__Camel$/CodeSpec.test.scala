//> using resourceDir "./resources"

//> using lib "org.scalatest::scalatest:3.2.9"
//> using lib "com.lihaoyi::os-lib:0.8.0"

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers._
import java.util._
import java.io.StringReader
import java.io.ByteArrayOutputStream

// Solution for challenge at $challengeurl$
class CodeSpec extends AnyFreeSpec {

  "test runs and passes" in {
    val testInput = os.read(os.resource(getClass.getClassLoader) / "sample_input")
    val expectedResult = os.read(os.resource(getClass.getClassLoader) / "sample_output")

    val mockIn = new StringReader(testInput)
    val outputStream: ByteArrayOutputStream = new ByteArrayOutputStream()

    Console.withIn(mockIn) {
      Console.withOut(outputStream) {
        Code.main(Array.empty)
      }
    }

    val result = outputStream.toString()

    result mustEqual expectedResult
  }
}
