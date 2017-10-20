package gabriel.schmoeller.app.sample.web;

import gabriel.schmoeller.app.sample.config.SampleConfiguration;
import gabriel.schmoeller.app.sample.persistence.SampleRepository;
import gabriel.schmoeller.app.sample.web.domain.SampleViewBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SampleConfiguration.class)
@TestPropertySource(locations="classpath:test.properties")
public class SampleControllerIT {

    private static final int YEAR = 2017;
    private static final int FRIDAY = 20;

    private static final int VALID_HOUR = 12;

    private static final LocalDateTime DATE = LocalDateTime.of(YEAR, Month.OCTOBER, FRIDAY, VALID_HOUR, 0);
    private static final LocalDateTime DATE_2 = LocalDateTime.of(YEAR, Month.OCTOBER, FRIDAY, VALID_HOUR, 30);
    private static final String NAME = "Puding";
    private static final String NAME_2 = "Puding 2";

    @Autowired
    private SampleController sampleController;

    @Autowired
    private SampleRepository repository;

    @Test
    public void shouldCreateThings() {
        // given
        SampleViewBean viewBean = new SampleViewBean();
        viewBean.setName(NAME);
        viewBean.setDate(DATE);

        // when
        SampleViewBean things = sampleController.createThings(viewBean);

        // then
        Assert.assertNotNull(repository.findOne(things.getId()));
    }

    @Test
    public void shouldLoadThings() {
        // given
        SampleViewBean viewBean = new SampleViewBean();
        viewBean.setName(NAME);
        viewBean.setDate(DATE);

        SampleViewBean viewBean2 = new SampleViewBean();
        viewBean2.setName(NAME_2);
        viewBean2.setDate(DATE_2);

        List<SampleViewBean> expectedList = new ArrayList<>();
        expectedList.add(sampleController.createThings(viewBean));
        expectedList.add(sampleController.createThings(viewBean2));

        // when
        List<SampleViewBean> listOfThings = sampleController.listThings();

        // then
        Assert.assertEquals(expectedList, listOfThings);
    }
}