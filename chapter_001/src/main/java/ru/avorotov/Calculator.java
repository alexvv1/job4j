package ru.avorotov;

/**
 * Калькулятор. Выполняемые действия Сложение, Вычитание, Умножение, Деление.
 * @author avorotov
 * @since 17.12.2016
 * @version 1
 */
public class Calculator {
    /**
     * Результат вычисления.
     */
	private double result;
	/**
     * Операция сложения двух чесел.
	 * @param first Первое число для сложения
	 * @param second Второе число для сложения
     */
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
     * Операция разности двух чисел.
	 * @param first Уменьшаемое
	 * @param second Вычитаемое
     */
	public void subtract(double first, double second) {
		this.result = first - second;
	}
	/**
     * Операция умножения двух чисел.
	 * @param first Первый множитель
	 * @param second Второй множитель
     */
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	/**
     * Операция деления первого числа на второе.
	 * @param first Делимое
	 * @param second Делитель
     */
	public void div(double first, double second) {
		if (second != 0) {
				this.result = first / second;
		} else {
			throw new ArithmeticException("division by zero");
		}
	}
	/**
     * Возвращает результат арифметической операции.
	 * @return Возвращает результат арифметической операции
     */
	public double getResult() {
		return this.result;
	}
}