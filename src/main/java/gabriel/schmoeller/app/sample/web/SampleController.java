package gabriel.schmoeller.app.sample.web;

import gabriel.schmoeller.app.sample.business.SampleService;
import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sample")
public class SampleController {

    private final SampleService service;

    @Autowired
    public SampleController(SampleService service) {
        this.service = service;
    }

    @GetMapping
    public List<SampleEntity> listThings() {
        return service.listSamples();
    }

    @GetMapping("random")
    public SampleEntity createRandom() {
        SampleEntity random = new SampleEntity();
        random.setName(UUID.randomUUID().toString());
        random.setDate(LocalDateTime.now());

        return service.create(random);
    }

    @PostMapping
    public void createThings(SampleEntity entity) {

    }
}
