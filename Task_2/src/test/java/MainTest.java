import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Nested
    class MathOperationOnStringTests {

        @Test
        void should_doCorrectAddition_when_correctInput() {
            // given
            String input = "12;43;2+";

            // when
            BigInteger result = Main.mathOperationOnString(input);

            // then
            assertEquals(BigInteger.valueOf(57), result);
        }

        @Test
        void should_doCorrectSubtraction_when_correctInput() {
            // given
            String input = "12;43;2-";

            // when
            BigInteger result = Main.mathOperationOnString(input);

            // then
            assertEquals(BigInteger.valueOf(-57), result);
        }

        @Test
        void should_doCorrectMultiplication_when_correctInput() {
            // given
            String input = "12;43;2*";

            // when
            BigInteger result = Main.mathOperationOnString(input);

            // then
            assertEquals(BigInteger.valueOf(1032), result);
        }

        @Test
        void should_throwException_when_inputEmpty() {
            // given
            String emptyString = "";

            // when
            Executable executable = () -> Main.mathOperationOnString(emptyString);

            // then
            assertThrows(RuntimeException.class, executable);
        }

        @Test
        void should_throwException_when_numbersAreMissing() {
            // given
            String justOperator = "+";

            // when
            Executable executable = () -> Main.mathOperationOnString(justOperator);

            // then
            assertThrows(RuntimeException.class, executable);
        }

        @Test
        void should_throwException_when_OperatorIsMissing() {
            // given
            String inputWithoutOperator = "12;43;";

            // when
            Executable executable = () -> Main.mathOperationOnString(inputWithoutOperator);

            // then
            assertThrows(RuntimeException.class, executable);
        }

        @Test
        void should_throwException_when_numbersAreIncorrect() {
            // given
            String incorrectNumbers = "12;43/;31;+";

            // when
            Executable executable = () -> Main.mathOperationOnString(incorrectNumbers);

            // then
            assertThrows(NumberFormatException.class, executable);
        }

    }
}