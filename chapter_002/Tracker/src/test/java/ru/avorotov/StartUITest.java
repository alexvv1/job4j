package ru.avorotov;

import org.junit.Assert;
import org.junit.Test;
import ru.avorotov.Model.Claim;
import ru.avorotov.Model.Comment;

/**
 * Тест Tracker.
 */
public class StartUITest {

    /**
     * Тест добавления задач.
     */
    @Test
    public void addClaimSuccessPath() {
        final String[] answers = new String[]{"1", "name1", "desc1", "да", "comm1", "", "",
                "1", "name1", "desc1", "да", "comm1", "", "да"};
        IInput stubInput = new StubInput(answers);
        ITracker tracker = new Tracker();
        StartUI startUI = new StartUI(stubInput, tracker);
        startUI.start();
        //Assert
        int expectedCountClaim = 2;
        Assert.assertEquals(expectedCountClaim, tracker.findAll().length);
    }

    /**
     * Тест редактирования задачи.
   	 */
    @Test
    public void editClaimSuccessPath() {
        final String[] answers = new String[]{"1", "name1", "desc1", "да", "comm1", "", "",
                "3", "1", "name2", "desc2", "да", "comm2", "", "да"};
        IInput stubInput = new StubInput(answers);
        ITracker tracker = new Tracker();
        StartUI startUI = new StartUI(stubInput, tracker);
        startUI.start();
        //Assert
        int expectedCountClaim = 1;
        Assert.assertEquals(expectedCountClaim, tracker.findAll().length);
        Claim claim = new Claim("name2", "desc2");
        claim.setId("1");
        claim.setComments(new Comment[]{new Comment("comm1")});
        equalClaim(claim, tracker.findAll()[0]);
    }

    /**
     * Сравнить две заявки.
     *
     * @param expectedClaim Expected Claim
     * @param actualClaim   Actual Claim.
     */
    private void equalClaim(Claim expectedClaim, Claim actualClaim) {
        Assert.assertEquals(expectedClaim.getId(), actualClaim.getId());
        Assert.assertEquals(expectedClaim.getName(), actualClaim.getName());
        Assert.assertEquals(expectedClaim.getDescription(), actualClaim.getDescription());
        for (Comment expectedComment : expectedClaim.getComments()) {
            for (Comment actualComment : expectedClaim.getComments()) {
                Assert.assertEquals(expectedComment.getText(), actualComment.getText());
            }
        }
    }

    /**
     * Тест удаления задачи.
     */
    @Test
    public void deleteClaimSuccessPath() {
        final String[] answers = new String[]{"1", "name1", "desc1", "да", "comm1", "", "",
                "1", "name2", "desc2", "да", "comm1", "", "", "5", "2", "да"};
        IInput stubInput = new StubInput(answers);
        ITracker tracker = new Tracker();
        StartUI startUI = new StartUI(stubInput, tracker);
        startUI.start();
        //Assert
        int expectedCountClaim = 1;
        Assert.assertEquals(expectedCountClaim, tracker.findAll().length);
    }
}