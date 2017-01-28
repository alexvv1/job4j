package ru.avorotov;

import org.junit.Assert;
import org.junit.Test;
import ru.avorotov.Model.Claim;

/**
 * Тестирование работы с Заявками.
 */
public class TrackerTest {

    /**
     * Тестирование добавления заявки.
     */
    @Test
    public void addClaimSuccessPath() {
        //Arrange
        Claim claim1 = new Claim("", "");
        Claim claim2 = new Claim("", "");
        Claim claim3 = new Claim("", "");
        //Act
        Tracker tracker = new Tracker();
        tracker.add(claim1);
        tracker.add(claim2);
        tracker.add(claim3);
        //Assert
        final int expectedSizeClaims = 3;
        Claim[] actualClaims = tracker.findAll();
        Assert.assertEquals(actualClaims.length, expectedSizeClaims);
    }

    /**
     * Тестирование findById.
     * Найдена заявка по Id.
     */
    @Test
    public void findByIdSuccessPath() {
        Tracker tracker = new Tracker();
        String newClaimId = tracker.add(new Claim("", "")).getId();
        String findClaimId = tracker.findById(newClaimId).getId();
        //Assert
        Assert.assertEquals(true, newClaimId.equals(findClaimId));
    }

    /**
     * Тестирование findByAll.
     * Найдены все заявки.
     */
    @Test
    public void findAllSuccessPath() {
        //Arrange
        Tracker tracker = new Tracker();
        String claim1Id = tracker.add(new Claim("", "")).getId();
        String claim2Id = tracker.add(new Claim("", "")).getId();
        String claim3Id = tracker.add(new Claim("", "")).getId();
        //Act
        Claim[] actualClaims = tracker.findAll();
        //Assert
        final int expectedCountClaims = 3;
        Assert.assertEquals(expectedCountClaims, actualClaims.length);
        Assert.assertEquals(claim1Id, actualClaims[0].getId());
        Assert.assertEquals(claim2Id, actualClaims[1].getId());
        Assert.assertEquals(claim3Id, actualClaims[2].getId());
    }

    /**
     * Тестирование update.
     * Заявка обновлена.
     */
    @Test
    public void updateSuccessPath() {
        //Arrange
        Tracker tracker = new Tracker();
        String claimId = tracker.add(new Claim("", "")).getId();
        final String claimName = "name";
        final String claimDesc = "desc";
        Claim updateClaim = new Claim(claimName, claimDesc);
        updateClaim.setId(claimId);
        //Act
        tracker.update(updateClaim);
        //Assert
        Claim updatedClaim = tracker.findById(claimId);
        Assert.assertEquals(claimId, updatedClaim.getId());
        Assert.assertEquals(claimName, updatedClaim.getName());
        Assert.assertEquals(claimDesc, updatedClaim.getDescription());
    }

    /**
     * Тестирование delete.
     * Заявка удалена.
     */
    @Test
    public void deleteSuccesPath() {
        //Arrange
        Tracker tracker = new Tracker();
        tracker.add(new Claim("name1", ""));
        Claim claimDeleted = tracker.add(new Claim("name2", ""));
        tracker.add(new Claim("name3", ""));
        //Act
        String claimDeletedId = claimDeleted.getId();
        tracker.delete(claimDeleted);
        //Assert
        int expectedCountClaims = 2;
        Claim[] expectedClaims = tracker.findAll();
        Assert.assertEquals(expectedCountClaims, expectedClaims.length);
        boolean isFindDeleted = true;
        for (Claim currentClaim : expectedClaims) {
            if (claimDeletedId.equals(currentClaim.getId())) {
                isFindDeleted = false;
                break;
            }
        }
        Assert.assertEquals(true, isFindDeleted);
    }

    /**
         * Тестирование findByName.
         * Поиск заявки по имени.
         */
    @Test
    public void findByNameSuccessPath() {
        //Arrange
        String claimName1 = "name1";
        String claimName2 = "name22";
        String claimName3 = "name3";
        Tracker tracker = new Tracker();
        tracker.add(new Claim(claimName1, ""));
        tracker.add(new Claim(claimName2, ""));
        tracker.add(new Claim(claimName2, ""));
        tracker.add(new Claim(claimName3, ""));
        //Act
        Claim[] findClaims = tracker.findByName(claimName2);
        //Assert
        int expectedCount = 2;
        Assert.assertEquals(expectedCount, findClaims.length);
        Assert.assertEquals(findClaims[0].getName(), claimName2);
        Assert.assertEquals(findClaims[1].getName(), claimName2);
    }
}