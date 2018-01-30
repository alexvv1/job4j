package ru.avorotov.newtracker;

import ru.avorotov.newtracker.Model.Claim;
import ru.avorotov.newtracker.Model.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Действия.
 */
class Actions {
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
        ArrayList<Comment> comments = new ArrayList<>();
        boolean needAddComments = true;
        while (needAddComments) {
            needAddComments = input.askBoolean("Добавить комментарии(да)? ");
            if (needAddComments) {
                String commentText = input.ask("Введите, пожалуйста, текст комментария: ");
                comments.add(new Comment(commentText));
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
        AddAction(int key) {
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
        ShowClaimAction(int key) {
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
                List<Comment> comments = findedClaim.map(Claim::getComments).get();
                for (int i = 0; i < comments.size() - 1; i++) {
                    if (comments.get(i) != null) {
                        System.out.println(String.format("Комментарий №%s - %s", i + 1, comments.get(i).getText()));
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
        EditClaimAction(int key) {
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
        ShowAllClaimAction(int key) {
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
        DeleteClaimAction(int key) {
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
}
