package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collectors;

public class FootballTeamTests {
    private final String DEFAULT_NAME = "Ronaldo";
    private final String DEFAULT_TEAM_NAME = "Manchester";
    private final int DEFAULT_POSITIONS = 1;

    private Footballer footballer;
    private FootballTeam footballTeam;

    @Before
    public void init() {
        footballer = new Footballer(DEFAULT_NAME);
        footballTeam = new FootballTeam(DEFAULT_TEAM_NAME, DEFAULT_POSITIONS);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(DEFAULT_NAME, footballer.getName());
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionWhenNameIsEmptyString() {
        FootballTeam footballTeam1 = new FootballTeam("  ", DEFAULT_POSITIONS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenNegativePositions() {
        FootballTeam footballTeam1 = new FootballTeam(DEFAULT_TEAM_NAME, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFootballerTest() {
        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFootballerTest() {
        footballTeam.removeFootballer(DEFAULT_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void footballerForSaleTestException() {
        footballTeam.footballerForSale(DEFAULT_NAME);
    }

    @Test()
    public void getCountTest() {
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(footballTeam.getCount(), DEFAULT_POSITIONS);
    }

    @Test()
    public void getStatisticsTest() {
        footballTeam.addFootballer(footballer);
        String test = String.format("The footballer %s is in the team %s.", DEFAULT_NAME, DEFAULT_TEAM_NAME);
        Assert.assertEquals(footballTeam.getStatistics(), test);
    }
}
