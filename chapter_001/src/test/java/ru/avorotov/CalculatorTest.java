package ru.avorotov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для класса Calculator.
 *
 * @author avorotov
 * @version 1.0
 * @since 17.12.2016
 */
public class CalculatorTest {

	/**
	 * Тест проверяет сложение двух чисел.
     */
	@Test
	public void whenTwoNumberAddToReturnResult() {
		//Arange
		final double first = 5.5;
		final double second = 7.2;
		final double targetResult = 12.7;
		//Act
		Calculator calculator = new Calculator();
		calculator.add(first, second);
		//Assert
		assertThat(calculator.getResult(), is(targetResult));
	}
	/**
	 * Тест проверяет вычитание двух чисел.
     */
	@Test
	public void whenTwoNumberSubtractToReturnResult() {
		//Arange
		final double first = 5.1;
		final double second = 5;
		final double targetResult = 0.09999999999999964;
		//Act
		Calculator calculator = new Calculator();
		calculator.subtract(first, second);
		//Assert
		assertThat(calculator.getResult(), is(targetResult));
	}
	/**
	 * Тест проверяет умножение двух чисел.
     */
	@Test
	public void whenTwoNumberMultipleToReturnResult() {
		//Arange
		final double first = 5.1;
		final double second = 5;
		final double targetResult = 25.5;
		//Act
		Calculator calculator = new Calculator();
		calculator.multiple(first, second);
		//Assert
		assertThat(calculator.getResult(), is(targetResult));
	}
	/**
	 * Тест проверяет деление двух чисел.
     */
	@Test
	public void whenTwoNumberDivToReturnResult() {
		//Arange
		final double first = 5.1;
		final double second = 5;
		final double targetResult = 1.02;
		//Act
		Calculator calculator = new Calculator();
		calculator.div(first, second);
		//Assert
		assertThat(calculator.getResult(), is(targetResult));
	}
	/**
	 * Тест проверяет что при делении на ноль throw Exception.
     */
	@Test(expected = ArithmeticException.class)
	public void whenNumberDivZeroToException() {
		//Arange
		final double first = 5.1;
		final double second = 0;
		//Act
		Calculator calculator = new Calculator();
		calculator.div(first, second);
		//Assert
	}
}