package gabriel.schmoeller.app.sample.web;

import gabriel.schmoeller.app.sample.business.SampleService;
import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import gabriel.schmoeller.app.sample.web.converter.SampleConverter;
import gabriel.schmoeller.app.sample.web.domain.SampleViewBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sample")
public class SampleController {

    private final SampleService service;
    private final SampleConverter converter;

    @Autowired
    public SampleController(SampleService service, SampleConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping
    public List<SampleViewBean> listThings() {
        return converter.encodeAll(service.listSamples());
    }

    @GetMapping("random")
    public SampleViewBean createRandom() {
        SampleEntity random = new SampleEntity();
        random.setName(UUID.randomUUID().toString());
        random.setDate(LocalDateTime.now());

        return converter.encode(service.create(random));
    }

    @PostMapping
    public SampleViewBean createThings(SampleViewBean viewBean) {
        SampleEntity saved = service.create(converter.dencode(viewBean));

        return converter.encode(saved);
    }

    @PutMapping
    public void updateThings(SampleViewBean viewBean) {
        service.create(converter.dencode(viewBean));
    }
}
