package ru.avorotov;

import ru.avorotov.Model.Claim;
import ru.avorotov.Model.Comment;

import java.util.Optional;

/**
 * Действия.
 */
public class Actions {
    /**
     * Создать заявку.
     *
     * @param input Ввод/вывод.
     * @return Заявка.
     */
    private static Claim createClaim(IInput input) {
        String name = input.ask("Введите, пожалуйста, имя заявки: ");
        String desc = input.ask("Введите, пожалуйста, описание заявки: ");
        Claim claim = new Claim(name, desc);
        final int countComments = 5;
        Comment[] comments = new Comment[countComments];
        boolean needAddComments = true;
        int positionComment = 0;
        while (needAddComments) {
            needAddComments = input.askBoolean("Добавить комментарии(да)? ");
            if (needAddComments && positionComment < comments.length - 1) {
                String commentText = input.ask("Введите, пожалуйста, текст комментария: ");
                comments[positionComment++] = new Comment(commentText);
            }
        }
        claim.setComments(comments);
        return claim;
    }

    /**
     * Действие "Добавить заявку".
     */
    public static class AddAction extends BaseAction {
        /**
         * Наименования действия.
         */
        private static final String NAME_ACTION = "Добавить заявку";

        /**
         * Конструктор.
         *
         * @param key Ключ действия.
         */
        public AddAction(int key) {
            super(NAME_ACTION, key);
        }

        /**
         * Выполнить действие.
         *
         * @param input   Объект для ввода/вывода.
         * @param tracker Объект для работы с заявками
         */
        @Override
        public void execute(IInput input, ITracker tracker) {
            Claim claim = createClaim(input);
            tracker.add(claim);
            System.out.println(String.format("Заявка с Id - %s добавлена.", claim.getId()));
        }
    }

    /**
     * Действие "Просмотреть заявку".
     */
    public static class ShowClaimAction extends BaseAction {
        /**
         * Наименования действия.
         */
        private static final String NAME_ACTION = "Просмотреть заявку";

        /**
         * Конструктор.
         *
         * @param key Ключ действия.
         */
        public ShowClaimAction(int key) {
            super(NAME_ACTION, key);
        }

        /**
         * Выполнить действие.
         *
         * @param input   Объект для ввода/вывода.
         * @param tracker Объект для работы с заявками
         */
        @Override
        public void execute(IInput input, ITracker tracker) {
            String id = input.ask("Введите, пожалуйста, номер заявки: ");
            Optional<Claim> findedClaim = tracker.findById(id);
            if (findedClaim.isPresent()) {
                System.out.println(String.format("Идентификатор - %s", findedClaim.map(Claim::getId).get()));
                System.out.println(String.format("Наименование - %s", findedClaim.map(Claim::getName).get()));
                System.out.println(String.format("Описание - %s", findedClaim.map(Claim::getDescription).get()));
                System.out.println(String.format("Дата создания - %s", findedClaim.map(Claim::getCreateDate).get()));
                Comment[] comments = findedClaim.map(Claim::getComments).get();
                for (int i = 0; i < comments.length - 1; i++) {
                    if (comments[i] != null) {
                        System.out.println(String.format("Комментарий №%s - %s", i + 1, comments[i].getText()));
                    }
                }
            } else {
                System.out.println("Заявка не найдена");
            }
        }
    }

    /**
     * Действие "Редактировать заявку".
     */
    public static class EditClaimAction extends BaseAction {
        /**
         * Наименования действия.
         */
        private static final String NAME_ACTION = "Редактировать заявку";

        /**
         * Конструктор.
         *
         * @param key Ключ действия.
         */
        public EditClaimAction(int key) {
            super(NAME_ACTION, key);
        }

        /**
         * Выполнить действие.
         *
         * @param input   Объект для ввода/вывода.
         * @param tracker Объект для работы с заявками
         */
        @Override
        public void execute(IInput input, ITracker tracker) {
            String id = input.ask("Введите, пожалуйста, номер заявки: ");
            Optional<Claim> findedClaim = tracker.findById(id);
            if (findedClaim.isPresent()) {
                Claim claim = createClaim(input);
                claim.setId(findedClaim.get().getId());
                tracker.update(claim);
            } else {
                System.out.println("Заявка не найдена");
            }
        }
    }

    /**
     * Действие "Редактировать заявку".
     */
    public static class ShowAllClaimAction extends BaseAction {
        /**
         * Наименования действия.
         */
        private static final String NAME_ACTION = "Показать все заявки";

        /**
         * Конструктор.
         *
         * @param key Ключ действия.
         */
        public ShowAllClaimAction(int key) {
            super(NAME_ACTION, key);
        }

        /**
         * Выполнить действие.
         *
         * @param input   Объект для ввода/вывода.
         * @param tracker Объект для работы с заявками
         */
        @Override
        public void execute(IInput input, ITracker tracker) {
            for (Claim claim : tracker.findAll()) {
                System.out.println(String.format("%s - %s", claim.getId(), claim.getName()));
            }
        }
    }

    /**
     * Действие "Редактировать заявку".
     */
    public static class DeleteClaimAction extends BaseAction {
        /**
         * Наименования действия.
         */
        private static final String NAME_ACTION = "Удалить заявку";

        /**
         * Конструктор.
         *
         * @param key Ключ действия.
         */
        public DeleteClaimAction(int key) {
            super(NAME_ACTION, key);
        }

        /**
         * Выполнить действие.
         *
         * @param input   Объект для ввода/вывода.
         * @param tracker Объект для работы с заявками
         */
        @Override
        public void execute(IInput input, ITracker tracker) {
            String id = input.ask("Введите, пожалуйста, номер заявки: ");
            Optional<Claim> findedClaim = tracker.findById(id);
            if (findedClaim.isPresent()) {
                tracker.delete(findedClaim.get());
            } else {
                System.out.println("Заявка не найдена");
            }
        }
    }

//    /**
//     * Действие "Выйти".
//     */
//    public static class ExitClaimAction extends BaseAction {
//
//        /**
//         * Наименования действия.
//         */
//        private static final String NAME_ACTION = "Выйти";
//
//        /**
//         * Конструктор.
//         *
//         * @param key Ключ действия.
//         */
//        public ExitClaimAction(int key) {
//            super(NAME_ACTION, key);
//        }
//
//        /**
//         * Выполнить действие.
//         *
//         * @param input   Объект для ввода/вывода.
//         * @param tracker Объект для работы с заявками
//         */
//        @Override
//        public void execute(IInput input, ITracker tracker) {
//            tracker.s
//        }
//    }
}
