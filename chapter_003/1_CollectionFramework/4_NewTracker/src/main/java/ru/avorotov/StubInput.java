package ru.avorotov;

/**
 * Stub Input.
 */
public class StubInput implements IInput  {
    /**
     * Массив ответов.
     */
    private String[] answers;
    /**
     * Позиция.
     */
    private int position = 0;

    /**
     * Конструктор.
     * @param answers Ответы.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Спросить.
     *
     * @param question Вопрос
     * @param range    Ключи допустимых действий.
     * @return Ответ на вопрос.
     */
    @Override
    public int ask(String question, int[] range) {
        return Integer.valueOf(this.answers[position++]);
    }

    /**
     * Спросить.
     *
     * @param question Вопрос
     * @return Ответ на вопрос.
     */
    @Override
    public String ask(String question) {
        return this.answers[position++];
    }

    /**
     * Спросить.
     *
     * @param question Вопрос
     * @return Ответ на вопрос в формате boolean.
     */
    @Override
    public boolean askBoolean(String question) {
        return Boolean.valueOf("да".equals(this.answers[position++]));
    }

//    private String getAnswer() {
//
//        if(position <= answers.length) {
//
//        } else {
//            return "да";
//        }
//        position++;
//    }
}
