package ru.avorotov;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Calculate Class.
 *
 * @author avorotov
 * @version 1.0
 * @since 17.12.2016
 */
public class CalculateTest {
	/**
     * Тестируем  "Hello World!".
     */
	@Test
	public void whenRunMainToPrintHelloWorld() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Calculate.main(null);
		assertThat(
			out.toString(),
			is(
				String.format(
					"Hello World!%s",
					System.getProperty("line.separator")
				)
			)
		);
	}
}